package com.sendiy.file.persistence.service;

import com.sendiy.common.constant.ErrorMessages;
import com.sendiy.common.exception.NotFoundException;
import com.sendiy.common.jooq.tables.records.FilesRecord;
import com.sendiy.file.model.FileDomain;
import com.sendiy.file.persistence.mapper.FilePersistenceMapper;
import com.sendiy.file.persistence.repository.FileRepository;
import com.sendiy.file.port.out.FileCreatePort;
import com.sendiy.file.port.out.FileGetPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

/**
 * @author ahror
 * @since 05/11/2024
 */
@Service
@RequiredArgsConstructor
public class FileService implements FileCreatePort, FileGetPort {
    private final FileRepository fileRepository;
    private final FilePersistenceMapper mapper;

    @Override
    public UUID create(FileDomain domain) {
        return fileRepository.save(mapper.toRecord(domain));
    }

    @Override
    public FileDomain get(UUID id) {
        Optional<FilesRecord> record = fileRepository.get(id);
        return record.map(mapper::toDomain).orElseThrow(() -> new NotFoundException(ErrorMessages.FILE_NOT_FOUND, new HashMap<>() {{
            put("id", id);
        }}));
    }
}
