package com.sendiy.file.port.usecase;

import java.io.File;
import java.io.FileInputStream;
import java.util.UUID;

/**
 * @author ahror
 * @since 14/11/2024
 */

public interface FileViewUseCase {
    File view(UUID fileId);
}
