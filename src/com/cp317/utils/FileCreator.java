package com.cp317.utils;

public interface FileCreator {
    default void validateFilePath(String filePath) {
        if (filePath == null || filePath.isEmpty()) {
            throw new IllegalArgumentException("File path cannot be null or empty");
        }
    }
}