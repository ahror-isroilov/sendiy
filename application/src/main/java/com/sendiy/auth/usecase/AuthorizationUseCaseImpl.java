package com.sendiy.auth.usecase;

import com.sendiy.auth.dto.*;
import com.sendiy.auth.port.AuthorizationUseCase;
import com.sendiy.auth.dto.request.LoginRequest;
import com.sendiy.auth.dto.request.SetPasswordRequest;
import com.sendiy.auth.dto.request.UpdatePasswordRequest;
import com.sendiy.auth.dto.response.AccessTokenResponse;
import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.BadCredentialsException;
import com.sendiy.common.exception.BadRequestException;
import com.sendiy.common.exception.ForbiddenException;
import com.sendiy.common.util.BaseUtil;
import com.sendiy.common.util.JwtUtil;
import com.sendiy.common.util.MyPasswordEncoder;
import com.sendiy.common.util.RegexUtil;
import com.sendiy.otp.model.Otp;
import com.sendiy.otp.persistence.OtpService;
import com.sendiy.otp.persistence.entity.OtpEntity;
import com.sendiy.otp.persistence.mapper.OtpPersistenceMapper;
import com.sendiy.refresh_token.mapper.AccessTokenTokenRestMapper;
import com.sendiy.refresh_token.model.AccessToken;
import com.sendiy.refresh_token.model.RefreshToken;
import com.sendiy.refresh_token.port.out.RefreshTokenCreatePort;
import com.sendiy.refresh_token.port.out.RefreshTokenGetPort;
import com.sendiy.user.dto.request.UserCreateRequest;
import com.sendiy.user.model.User;
import com.sendiy.user.model.enums.UserStatus;
import com.sendiy.user.port.out.UserGetPort;
import com.sendiy.user.port.out.UserUpdatePort;
import com.sendiy.user.port.usecase.UserCreateUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * author: ahror
 * <p>
 * since: 21/10/2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class AuthorizationUseCaseImpl implements AuthorizationUseCase {
    private final MyPasswordEncoder encoder;
    private final UserCreateUseCase userCreateUseCase;
    private final RefreshTokenCreatePort refreshTokenCreatePort;
    private final AccessTokenTokenRestMapper mapper;
    private final UserGetPort userGetPort;
    private final UserUpdatePort userUpdatePort;
    private final OtpPersistenceMapper otpMapper;
    private final OtpService otpService;
    private final RefreshTokenGetPort refreshTokenGetPort;

    @Override
    public AccessTokenResponse login(LoginRequest request) {
        User user = userGetPort.getByPhone(request.getPhone());
        validateUserAndPhone(user, request);
        if (request.getPassword() != null && !request.getPassword().isEmpty()) {
            checkPassword(request.getPassword(), user.getPasswordHash());
            AccessToken token = generateToken(user);
            return mapper.toResponse(token);
        } else if (request.getOtp() != null && !request.getOtp().isEmpty()) {
            String otp = request.getOtp();
            if (otpService.valid(request.getPhone(), otp)) {
                AccessToken token = generateToken(user);
                return mapper.toResponse(token);
            }
            throw new BadRequestException(ErrorMessages.INVALID_OTP);
        }
        throw new BadRequestException(ErrorMessages.MISSING_FIELDS, new HashMap<>() {{
            put("required (or)", List.of("password", "otp"));
        }});
    }

    @Override
    public AccessTokenResponse refresh(String refreshToken) {
        RefreshToken token = refreshTokenGetPort.get(refreshToken);
        AccessToken accessToken = refreshToken(token);
        return mapper.toResponse(accessToken);
    }

    @Override
    public Otp sendOtp(String phone) {
        if (RegexUtil.isValidPhone(phone)) {
            phone = BaseUtil.formatPhone(phone);
            OtpEntity entity = otpMapper.mapToEntity(new Otp(phone));
            OtpEntity otp = otpService.save(entity);
            log.info("OTP sent to phone: {} ({})", phone, otp.getOtp());
            return otpMapper.mapToDomain(otp);
        } else throw new BadCredentialsException(ErrorMessages.INVALID_PHONE_NUMBER);
    }

    private AccessToken generateToken(User user) {
        RefreshToken refreshToken = new RefreshToken();
        refreshToken.setUserId(user.getId());
        refreshToken.setExpiryDate(LocalDateTime.now().plusDays(7));// 7 days
        refreshToken.setToken(JwtUtil.createRefreshToken(user.getPhone(), refreshToken.getExpiryDate()));
        RefreshToken created = refreshTokenCreatePort.create(refreshToken);

        AccessToken token = new AccessToken();
        token.setExpiryDate(LocalDateTime.now().plusHours(1)); // 1 hour
        token.setToken(JwtUtil.createAccessToken(user.getPhone(), token.getExpiryDate()));
        token.setRefreshToken(created);
        return token;
    }

    private AccessToken refreshToken(RefreshToken refreshToken) {
        User user = userGetPort.get(refreshToken.getUserId());
        AccessToken token = new AccessToken();
        token.setExpiryDate(LocalDateTime.now().plusHours(1)); // 1 hour
        token.setToken(JwtUtil.createAccessToken(user.getPhone(), token.getExpiryDate()));
        token.setRefreshToken(refreshToken);
        return token;
    }

    @Override
    public AuthType getAuthType(String phone) {
        if (!userGetPort.existsByPhone(phone))
            return AuthType.REGISTER;
        else {
            User user = userGetPort.getByPhone(phone);
            if (user.getPasswordHash() != null && !user.getPasswordHash().isEmpty())
                return AuthType.LOGIN_PASSWORD;
            else return AuthType.LOGIN_OTP;
        }
    }

    @Override
    public UUID register(UserCreateRequest request) {
        return userCreateUseCase.create(request);
    }

    @Override
    public void setPassword(SetPasswordRequest request) {
        User user = userGetPort.getByPhone(request.getPhone());
        if (user.getPasswordHash() == null || user.getPasswordHash().isEmpty() || user.getPasswordHash().isBlank()) {
            if (request.getPassword().equals(request.getConfirmPassword())) {
                user.setPasswordHash(encoder.encode(request.getConfirmPassword()));
                userUpdatePort.update(user);
            } else throw new BadRequestException(ErrorMessages.PASSWORDS_DIDNT_MATCH);
        } else
            throw new BadRequestException(ErrorMessages.PASSWORD_ALREADY_SET);
    }

    @Override
    public void updatePassword(UpdatePasswordRequest request) {
        User user = userGetPort.getByPhone(request.getPhone());
        if (user.getPasswordHash() != null && !user.getPasswordHash().isEmpty() && !user.getPasswordHash().isBlank()) {
            if (encoder.matches(request.getOldPassword(), user.getPasswordHash())) {
                if (request.getNewPassword().equals(request.getConfirmPassword())) {
                    user.setPasswordHash(encoder.encode(request.getConfirmPassword()));
                    userUpdatePort.update(user);
                } else throw new BadRequestException(ErrorMessages.PASSWORDS_DIDNT_MATCH);
            } else throw new BadRequestException(ErrorMessages.OLD_PASSWORD_IS_INCORRECT);
        } else throw new BadRequestException(ErrorMessages.SET_PASSWORD_FIRST);
    }

    private void validateUserAndPhone(User user, LoginRequest request) {
        boolean validPhone = RegexUtil.isValidPhone(request.getPhone());
        if (validPhone) {
            request.setPhone(BaseUtil.formatPhone(request.getPhone()));
            UserStatus status = user.getStatus();
            if (status.equals(UserStatus.BLOCKED) || status.equals(UserStatus.DISABLED))
                throw new ForbiddenException(ErrorMessages.USER_BLOCKED);
        } else
            throw new BadRequestException(ErrorMessages.INVALID_PHONE_NUMBER);
    }

    private void checkPassword(String rawPassword, String encodedPassword) {
        if (!encoder.matches(rawPassword, encodedPassword))
            throw new BadCredentialsException(ErrorMessages.INCORRECT_PASSWORD);
    }
}
