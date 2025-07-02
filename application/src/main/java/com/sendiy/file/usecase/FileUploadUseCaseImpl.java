package com.sendiy.file.usecase;

import com.sendiy.common.util.FileUtil;
import com.sendiy.file.enums.FileType;
import com.sendiy.file.model.FileDomain;
import com.sendiy.file.port.out.FileCreatePort;
import com.sendiy.file.port.usecase.FileUploadUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

/**
 * @author ahror
 * @since 14/11/2024
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class FileUploadUseCaseImpl implements FileUploadUseCase {
    private final FileCreatePort fileCreatePort;

    @Override
    public UUID upload(File file, String contentType) {
        if (contentType.startsWith("image/")) {
            Path path = Paths.get(FileUtil.IMAGE_PATH);
            checkDirectory(path);
            try {
                Runtime.getRuntime().exec("cwebp -q 70 %s -o %s".formatted(file.getAbsolutePath(),
                        path + File.separator + file.getName() + ".webp")).waitFor();
                return fileCreatePort.create(new FileDomain(
                        file.getName(),
                        FileType.IMAGE,
                        path + File.separator + file.getName() + ".webp"
                ));
            } catch (InterruptedException | IOException e) {
                log.error("Error processing file", e);
            }
        } else if (contentType.startsWith("video/")) {
            Path path = Paths.get(FileUtil.VIDEO_PATH);
            checkDirectory(path);
            Path destFile = path.resolve(file.getName() + ".mp4");
            try (FileInputStream in = new FileInputStream(file);
                 FileOutputStream out = new FileOutputStream(destFile.toFile())) {
                byte[] buffer = new byte[1024 * 8];
                int length;
                while ((length = in.read(buffer)) > 0) {
                    out.write(buffer, 0, length);
                }
                UUID id = fileCreatePort.create(new FileDomain(
                        file.getName(),
                        FileType.VIDEO,
                        path + File.separator + file.getName() + ".mp4"
                ));
                log.info("File copied successfully! {}", destFile);
                return id;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }

    private void checkDirectory(Path path) {
        if (!Files.exists(path)) {
            try {
                Files.createDirectories(path);
            } catch (IOException e) {
                log.error("Failed to create directory: {}", e.getMessage());
            }
        }
    }
}
