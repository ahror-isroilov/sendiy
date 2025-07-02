package com.sendiy.otp.persistence.repository;

import com.redis.om.spring.repository.RedisDocumentRepository;
import com.sendiy.otp.persistence.entity.OtpEntity;
import org.springframework.stereotype.Repository;

/**
 * author: ahror
 * <p>
 * since: 24/10/2024
 */
@Repository
public interface OtpRepository extends RedisDocumentRepository<OtpEntity, String> {
    boolean existsByPhone(String phone);

    OtpEntity findByPhone(String phone);

}
