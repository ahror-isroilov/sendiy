package com.sendiy.file.port.out;

import com.sendiy.file.model.FileDomain;

import java.util.UUID;

/**
 * @author ahror
 * @since 05/11/2024
 */
public interface FileGetPort {
    FileDomain get(UUID id);
}
