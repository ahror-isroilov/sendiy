package com.sendiy.file.port.usecase;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ahror
 * @since 14/11/2024
 */

public interface FileUploadUseCase {
    UUID upload(File file,String contentType);
}
