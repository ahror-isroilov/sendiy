package com.sendiy.otp.persistence.entity;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Indexed;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
import org.springframework.data.redis.core.TimeToLive;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

/**
 * author: ahror
 * <p>
 * since: 24/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document
@RedisHash(value = "otp")
public class OtpEntity implements Serializable {
    @Id
    @Indexed
    private String phone;

    @TimeToLive(unit = TimeUnit.SECONDS)
    private Long expiration;

    @Indexed
    private String otp;

    @Indexed
    private LocalDateTime expiry;
}
