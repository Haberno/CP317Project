package com.cp317.utils;

import java.io.IOException;
import java.util.List;

public interface FileReader<T> {
    List<T> readFromFile(String filePath) throws IOException;
}
