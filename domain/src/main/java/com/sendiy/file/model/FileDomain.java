package com.sendiy.file.model;

import com.sendiy.file.enums.FileType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.UUID;
/**
 * @author ahror
 * @since 30/10/2024
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileDomain implements Serializable {
    private UUID id;
    private String name;
    private FileType type;
    private String path;

    public FileDomain(String name, FileType type, String path) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.type = type;
        this.path = path;
    }
}
