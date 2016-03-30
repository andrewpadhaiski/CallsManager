package com.redalpha.callsmanager.web;

import com.redalpha.callsmanager.domain.Call;
import com.redalpha.callsmanager.service.CallService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller of the application which accepts http requests.
 */
@RestController
@RequestMapping("/api")
public class CallController {

    @Autowired
    private CallService callService;

    @RequestMapping(path = "/call", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Call> saveCall(@RequestBody Call call) {
        callService.save(call);
        return new ResponseEntity<>(call, HttpStatus.CREATED);
    }
}
