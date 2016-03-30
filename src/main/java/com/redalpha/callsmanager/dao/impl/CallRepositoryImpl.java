package com.redalpha.callsmanager.dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import com.redalpha.callsmanager.dao.CallRepository;
import com.redalpha.callsmanager.domain.Call;
import com.redalpha.callsmanager.exception.DataAccessException;
import com.redalpha.callsmanager.util.StringManager;
import org.springframework.stereotype.Repository;

/**
 * Current implementation is used file as a source for storing data.
 */
@Repository
public class CallRepositoryImpl implements CallRepository {

    @Override
    public void save(Call call) {
        String fileName = StringManager.createFileName(call);
        File file = new File(fileName);
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            try (BufferedWriter bufferedWriter = new BufferedWriter(fileWriter)) {
                try (PrintWriter printWriter = new PrintWriter(bufferedWriter)) {
                    String number = call.getTelephoneNumber();
                    String normalizedNumber = StringManager.normalizeTelephoneNumber(number);
                    call.setTelephoneNumber(normalizedNumber);
                    printWriter.print(normalizedNumber);
                    printWriter.println();
                    String currentTime = StringManager.getFormattedTime(call.getTime());
                    printWriter.print(currentTime);
                    printWriter.println();
                }
            }
        } catch (IOException e) {
            throw new DataAccessException("Data access error.", e);
        }
    }

}
