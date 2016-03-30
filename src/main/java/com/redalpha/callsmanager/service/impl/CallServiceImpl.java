package com.redalpha.callsmanager.service.impl;

import java.util.Date;

import com.redalpha.callsmanager.dao.CallRepository;
import com.redalpha.callsmanager.domain.Call;
import com.redalpha.callsmanager.service.CallService;
import com.redalpha.callsmanager.util.StringManager;
import com.redalpha.callsmanager.validation.CallValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CallServiceImpl implements CallService {

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private CallValidator callValidator;

    @Override
    public void save(Call call) {
        StringManager.removeSpaces(call);
        callValidator.validate(call);
        call.setTime(new Date());
        callRepository.save(call);
    }
}
