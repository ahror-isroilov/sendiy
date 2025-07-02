package com.sendiy.otp.persistence.service;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.BadRequestException;
import com.sendiy.otp.persistence.OtpService;
import com.sendiy.otp.persistence.entity.OtpEntity;
import com.sendiy.otp.persistence.repository.OtpRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

/**
 * author: ahror
 * <p>
 * since: 24/10/2024
 */
@Service
@RequiredArgsConstructor
public class OtpServiceImpl implements OtpService {
    private final OtpRepository otpRepository;

    @Override
    public OtpEntity findByPhone(String phone) {
        return otpRepository.findByPhone(phone);
    }

    @Override
    public OtpEntity save(OtpEntity otp) {
        return otpRepository.save(otp);
    }

    @Override
    public boolean existsByPhone(String phone) {
        return otpRepository.existsByPhone(phone);
    }

    @Override
    public boolean valid(String phone, String otpCode) {
        if (otpRepository.existsById(phone)) {
            Optional<OtpEntity> otp = otpRepository.findById(phone);
            if (otp.isPresent() && otp.get().getExpiry().isAfter(LocalDateTime.now()))
                return Objects.equals(otp.get().getOtp(), otpCode);
            return false;
        } else
            throw new BadRequestException(ErrorMessages.EXPIRED_OTP);
    }
}
