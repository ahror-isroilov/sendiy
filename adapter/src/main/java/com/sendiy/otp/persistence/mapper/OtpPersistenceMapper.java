package com.sendiy.otp.persistence.mapper;

import com.sendiy.otp.model.Otp;
import com.sendiy.otp.persistence.entity.OtpEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * author: ahror
 <p>
 * since: 28/10/2024
 */
@Mapper(componentModel = "spring")
public interface OtpPersistenceMapper {
    Otp mapToDomain(OtpEntity entity);

    @Mapping(target = "expiration", expression = "java(60L)")
    OtpEntity mapToEntity(Otp otp);
}
