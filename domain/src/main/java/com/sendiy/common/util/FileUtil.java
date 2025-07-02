package com.sendiy.common.util;


public final class FileUtil {
    private static final String FILE_PATH = "./files";
    public static final String IMAGE_PATH = FILE_PATH + "/images/";
    public static final String VIDEO_PATH = FILE_PATH + "/videos/";

    public static String getFileExtension(String fileName) {
        int lastIndex = fileName.lastIndexOf('.');
        return (lastIndex != -1 || lastIndex != fileName.length() - 1) ? fileName.substring(lastIndex + 1) : null;
    }
}
