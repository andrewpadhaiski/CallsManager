package com.redalpha.callsmanager.domain;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Call {

    private String firstName;
    private String lastName;
    private Date time;
    private String telephoneNumber;

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    @JsonFormat(pattern = "HH:mm:ss")
    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Call call = (Call) o;

        if (firstName != null ? !firstName.equals(call.firstName) : call.firstName != null) {
            return false;
        }
        if (lastName != null ? !lastName.equals(call.lastName) : call.lastName != null) {
            return false;
        }
        if (time != null ? !time.equals(call.time) : call.time != null) {
            return false;
        }
        return telephoneNumber != null ? telephoneNumber.equals(call.telephoneNumber) : call.telephoneNumber == null;
    }

    @Override
    public int hashCode() {
        int result = firstName != null ? firstName.hashCode() : 0;
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        result = 31 * result + (telephoneNumber != null ? telephoneNumber.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Call{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", time=" + time +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                '}';
    }
}
