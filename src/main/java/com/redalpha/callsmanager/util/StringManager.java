package com.redalpha.callsmanager.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.redalpha.callsmanager.domain.Call;
import org.springframework.util.StringUtils;

/**
 * Class consists only static helper method for handling strings.
 */
public class StringManager {

    private static final String AREA_CODE = "420";
    private static final String INTERNATIONAL_CODE = "00";
    private static final String TIME_FORMAT = "HH:mm:ss";

    public static void removeSpaces(Call call) {
        String firstName = call.getFirstName();
        String lastName = call.getLastName();
        String telephoneNumber = call.getTelephoneNumber();
        call.setFirstName(removeSpaces(firstName));
        call.setLastName(removeSpaces(lastName));
        call.setTelephoneNumber(removeSpaces(telephoneNumber));
    }

    public static String removeSpaces(String field) {
        return StringUtils.deleteAny(field, " ");
    }

    public static String onlyDigits(String telephoneNumber) {
        return StringUtils.deleteAny(telephoneNumber, "-+()");
    }


    public static String createFileName(Call call) {
        String firstName = call.getFirstName().toUpperCase();
        String lastName = call.getLastName().toUpperCase();
        return firstName + "_" + lastName + ".txt";
    }

    public static String getFormattedTime(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_FORMAT);
        return sdf.format(date);
    }

    public static String normalizeTelephoneNumber(String number) {
        String digits = StringManager.onlyDigits(number);
        int quantity = digits.length();
        String normalizedNumber = null;
        switch (quantity) {
            case TelephoneNumberConstants.QUANTITY_DIGITS_LOCAL:
                normalizedNumber = fromLocalNumber(digits);
                break;
            case TelephoneNumberConstants.QUANTITY_DIGITS_AREA:
                normalizedNumber = fromAreaNumber(digits);
                break;
            case TelephoneNumberConstants.QUANTITY_DIGITS_INTERNATIONAL:
                normalizedNumber = fromInternationalNumber(digits);
                break;
        }
        return normalizedNumber;
    }

    public static String fromLocalNumber(String digits) {
        StringBuilder builder = new StringBuilder();
        builder.append(INTERNATIONAL_CODE);
        builder.append(AREA_CODE);
        builder.append(" ");
        builder.append(digits.substring(0, 3));
        builder.append(" ");
        builder.append(digits.substring(3, 6));
        builder.append(" ");
        builder.append(digits.substring(6, 9));
        return builder.toString();
    }

    public static String fromAreaNumber(String digits) {
        StringBuilder builder = new StringBuilder();
        builder.append(INTERNATIONAL_CODE);
        builder.append(digits.substring(0, 3));
        builder.append(" ");
        builder.append(digits.substring(3, 6));
        builder.append(" ");
        builder.append(digits.substring(6, 9));
        builder.append(" ");
        builder.append(digits.substring(9, 12));
        return builder.toString();
    }

    public static String fromInternationalNumber(String digits) {
        StringBuilder builder = new StringBuilder();
        builder.append(INTERNATIONAL_CODE);
        builder.append(digits.substring(2, 5));
        builder.append(" ");
        builder.append(digits.substring(5, 8));
        builder.append(" ");
        builder.append(digits.substring(8, 11));
        builder.append(" ");
        builder.append(digits.substring(11, 14));
        return builder.toString();
    }
}
