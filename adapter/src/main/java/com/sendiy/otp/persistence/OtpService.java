package com.sendiy.otp.persistence;

import com.sendiy.otp.persistence.entity.OtpEntity;

/**
 * author: ahror
 * <p>
 * since: 24/10/2024
 */
public interface OtpService {
    OtpEntity findByPhone(String phone);

    OtpEntity save(OtpEntity otp);

    boolean existsByPhone(String phone);

    boolean valid(String phone, String otp);
}
