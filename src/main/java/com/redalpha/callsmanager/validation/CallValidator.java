package com.redalpha.callsmanager.validation;

import com.redalpha.callsmanager.domain.Call;
import com.redalpha.callsmanager.exception.ValidationException;
import com.redalpha.callsmanager.util.StringManager;
import com.redalpha.callsmanager.util.TelephoneNumberConstants;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

/**
 * Class consists of validation rules for Call.
 */
@Component
public class CallValidator {

    private static final int CHARACTER_MAX_LENGTH = 30;
    private static final String REGEX_SUPPORTED_CHARACTERS = "\\+?(-|\\(|\\)|\\s|\\d)+";

    public void validate(Call call) {
        String firstName = call.getFirstName();
        String lastName = call.getLastName();
        String telephoneNumber = call.getTelephoneNumber();
        validateFirstName(firstName);
        validateLastName(lastName);
        validateTelephoneNumber(telephoneNumber);
    }

    private void validateFirstName(String firstName) {
        if (!StringUtils.isEmpty(firstName) && firstName.length() > CHARACTER_MAX_LENGTH) {
            throw new ValidationException("First name cannot be more than 30 characters.");
        }
    }

    private void validateLastName(String lastName) {
        if (StringUtils.isEmpty(lastName)) {
            throw new ValidationException("Last name can not be empty.");
        }
        if (lastName.length() > CHARACTER_MAX_LENGTH) {
            throw new ValidationException("Last name cannot be more than 30 characters.");
        }
    }

    private void validateTelephoneNumber(String telephoneNumber) {
        if (StringUtils.isEmpty(telephoneNumber)) {
            throw new ValidationException("Telephone number can not be empty.");
        }
        if (!telephoneNumber.matches(REGEX_SUPPORTED_CHARACTERS)) {
            throw new ValidationException("Telephone number has unsupported characters.");
        }
        if (!isBracesMatches(telephoneNumber)) {
            throw new ValidationException("Telephone number has unclosed (unopened) braces.");
        }
        String digits = StringManager.onlyDigits(telephoneNumber);
        int digitsQuantity = digits.length();
        if (!isSupportedQuantityOfDigits(digitsQuantity)) {
            throw new ValidationException("Telephone number has unsupported quantity of digits.");
        }
        if (digitsQuantity == TelephoneNumberConstants.QUANTITY_DIGITS_INTERNATIONAL) {
            if (!digits.startsWith("00")) {
                throw new ValidationException("Telephone number has invalid international code format.");
            }
        }
    }

    private boolean isBracesMatches(String telephoneNumber) {
        int openBraceCount = StringUtils.countOccurrencesOf(telephoneNumber, "(");
        int closeBraceCount = StringUtils.countOccurrencesOf(telephoneNumber, ")");
        return openBraceCount == closeBraceCount;
    }

    private boolean isSupportedQuantityOfDigits(int quantity) {
        return quantity == TelephoneNumberConstants.QUANTITY_DIGITS_LOCAL
                || quantity == TelephoneNumberConstants.QUANTITY_DIGITS_AREA
                || quantity == TelephoneNumberConstants.QUANTITY_DIGITS_INTERNATIONAL;
    }
}
