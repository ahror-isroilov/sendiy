package com.sendiy.file.web.controller;

import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.response.GenericResponse;
import com.sendiy.common.util.PathNames;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.UUID;

/**
 * @author ahror
 * @since 14/11/2024
 */
@RequestMapping(PathNames.FILE_V1)
@Validated
public interface FileController {
    @PostMapping("/upload")
    GenericResponse<?> upload(MultipartFile file) throws IOException;

    @GetMapping("/view/{id}")
    ResponseEntity<ByteArrayResource> view(@PathVariable UUID id) throws NotFoundException;
}
