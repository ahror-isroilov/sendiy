package com.sendiy.otp.model;

import com.sendiy.common.util.BaseUtil;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * author: ahror
 * <p>
 * since: 24/10/2024
 */
@Getter
@Setter
public class Otp implements Serializable {
    private String phone;
    private String otp;
    private LocalDateTime expiry;

    public Otp(String phone) {
        this.phone = phone;
        this.expiry = LocalDateTime.now().plusMinutes(1);
        this.otp = BaseUtil.generateOtp();
    }
}
