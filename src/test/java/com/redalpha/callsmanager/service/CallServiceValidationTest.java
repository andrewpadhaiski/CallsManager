package com.redalpha.callsmanager.service;

import com.redalpha.callsmanager.AbstractTest;
import com.redalpha.callsmanager.domain.Call;
import com.redalpha.callsmanager.exception.ValidationException;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class CallServiceValidationTest extends AbstractTest {

    @Autowired
    private CallService callService;

    @Test(expected = ValidationException.class)
    public void shouldValidateFirstNameForLength() {
        Call call = createCall("AndreiAndreiAndreiAndreiAndreiAndrei", null, null);
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateLastNameForNull() {
        Call call = createCall("Andrei", null, null);
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateLastNameForEmptyString() {
        Call call = createCall("Andrei", "", null);
        callService.save(call);
    }

    public void shouldValidateLastNameForSpaces() {
        Call call = createCall("Andrei", "       ", null);
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForNull() {
        Call call = createCall("Andrei", "Padhaiski", null);
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForEmptyString() {
        Call call = createCall("Andrei", "Padhaiski", "");
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForSpaces() {
        Call call = createCall("Andrei", "Padhaiski", "     ");
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForUnsupportedCharacters() {
        Call call = createCall("Andrei", "Padhaiski", "Telephone (111222333)");
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForUnclosedBrace() {
        Call call = createCall("Andrei", "Padhaiski", "(111222333");
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForDigitsQuantity() {
        Call call = createCall("Andrei", "Padhaiski", "11122233");
        callService.save(call);
    }

    @Test(expected = ValidationException.class)
    public void shouldValidateTelephoneNumberForInternationalCode() {
        Call call = createCall("Andrei", "Padhaiski", "45293749237234");
        callService.save(call);
    }

    private Call createCall(String firstName, String lastName, String telephoneNumber) {
        Call call = new Call();
        call.setFirstName(firstName);
        call.setLastName(lastName);
        call.setTelephoneNumber(telephoneNumber);
        return call;
    }
}
