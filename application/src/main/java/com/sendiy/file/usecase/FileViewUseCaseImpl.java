package com.sendiy.file.usecase;

import com.sendiy.file.model.FileDomain;
import com.sendiy.file.port.out.FileGetPort;
import com.sendiy.file.port.usecase.FileViewUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.UUID;

/**
 * @author ahror
 * @since 15/11/2024
 */
@Service
@RequiredArgsConstructor
public class FileViewUseCaseImpl implements FileViewUseCase {
    private final FileGetPort fileGetPort;

    @Override
    public File view(UUID fileId) {
        FileDomain fileDomain = fileGetPort.get(fileId);
        File file = new File(fileDomain.getPath());
        return file.exists() ? file : null;
    }
}
