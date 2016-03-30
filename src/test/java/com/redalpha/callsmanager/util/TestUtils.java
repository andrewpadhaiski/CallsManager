package com.redalpha.callsmanager.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.redalpha.callsmanager.exception.DataAccessException;

/**
 * Helper class for file access.
 */
public class TestUtils {
    public static List<String> getFileContent(String fileName) {
        try (FileReader fileReader = new FileReader(fileName)) {
            try (BufferedReader bufferedReader = new BufferedReader(fileReader)) {
                List<String> result = new ArrayList<>();
                String temp;
                while ((temp = bufferedReader.readLine()) != null) {
                    result.add(temp);
                }
                return result;
            }
        } catch (IOException e) {
            throw new DataAccessException("Data access error.", e);
        }
    }

    public static void cleanResources(String fileName) {
        File file = new File(fileName);
        file.delete();
    }
}
