package com.redalpha.callsmanager.dao;

import java.util.Date;
import java.util.List;

import com.redalpha.callsmanager.AbstractTest;
import com.redalpha.callsmanager.domain.Call;
import com.redalpha.callsmanager.util.StringManager;
import com.redalpha.callsmanager.util.TestUtils;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CallRepositoryTest extends AbstractTest {

    @Autowired
    CallRepository callRepository;

    @Test
    public void shouldSaveFormattedCallInFile() {
        Call call = new Call();
        call.setFirstName("Andrei");
        call.setLastName("Padhaiski");
        call.setTime(new Date());
        call.setTelephoneNumber("+(375)293674994");
        String file = StringManager.createFileName(call);
        callRepository.save(call);
        List<String> rows = TestUtils.getFileContent(file);
        String savedNumber = rows.get(0);
        String savedTime = rows.get(1);
        String actualTime = StringManager.getFormattedTime(call.getTime());
        Assert.assertEquals("00375 293 674 994", savedNumber);
        Assert.assertEquals(actualTime, savedTime);
        TestUtils.cleanResources(file);
    }
}
