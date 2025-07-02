package com.sendiy.file.web.controller.impls;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.response.GenericResponse;
import com.sendiy.common.util.BaseUtil;
import com.sendiy.common.util.FileUtil;
import com.sendiy.file.port.usecase.FileUploadUseCase;
import com.sendiy.file.port.usecase.FileViewUseCase;
import com.sendiy.file.web.controller.FileController;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.UUID;

/**
 * @author ahror
 * @since 14/11/2024
 */
@RestController
@RequiredArgsConstructor
public class FileControllerImpl implements FileController {
    private final FileUploadUseCase fileUploadUseCase;
    private final FileViewUseCase fileViewUseCase;

    @Override
    public GenericResponse<?> upload(MultipartFile file) throws IOException {
        String fileName = file.getName();
        File temp = File.createTempFile(BaseUtil.genRandomString(15), FileUtil.getFileExtension(fileName));
        file.transferTo(temp);
        return GenericResponse.success(new HashMap<>() {{
            put("id", fileUploadUseCase.upload(temp, file.getContentType()));
        }});
    }

    @Override
    public ResponseEntity<ByteArrayResource> view(UUID id) throws NotFoundException {
        File file = fileViewUseCase.view(id);
        if (file == null)
            throw new NotFoundException(ErrorMessages.FILE_NOT_FOUND);
        HttpHeaders headers = new HttpHeaders();
        headers.add("content-disposition", "inline;filename = " + file.getName());
        ByteArrayResource resource;
        try {
            resource = new ByteArrayResource(Files.readAllBytes(file.toPath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        long contentLength = file.length();
        return GenericResponse.ok()
                .headers(headers)
                .contentLength(contentLength)
                .contentType(MediaType.IMAGE_JPEG)
                .body(resource);
    }
}
