package com.cp317.utils;

import java.io.File;
import java.io.IOException;

public class FileValidator {

    public static void validateTxtFile(String filePath) throws IOException {
        File file = new File(filePath);

        // Check if the file exists
        if (!file.exists()) {
            throw new IOException("File does not exist: " + filePath);
        }

        // Check if the file is a .txt file
        if (!filePath.endsWith(".txt")) {
            throw new IOException("File is not a .txt file: " + filePath);
        }
    }
}
