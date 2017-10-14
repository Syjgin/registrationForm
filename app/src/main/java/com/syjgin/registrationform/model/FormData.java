package com.syjgin.registrationform.model;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public class FormData {
    private boolean isValidationSuccess;
    private String name;
    private String surname;
    private String fathername;
    private String email;
    private String phone;
    private String address;

    public boolean isValidationSuccess() {
        return isValidationSuccess;
    }

    public FormData(boolean success) {
        isValidationSuccess = success;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if(name != null)
            this.name = name;
    }

    public void copyData(FormData other) {
        if(other.name != null)
            name = other.name;
        if(other.surname != null)
            surname = other.surname;
        if(other.fathername != null)
            fathername = other.fathername;
        if(other.email != null)
            email = other.email;
        if(other.phone != null)
            phone = other.phone;
        if(other.address != null)
            address = other.address;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        if(surname != null)
            this.surname = surname;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        if(fathername != null)
            this.fathername = fathername;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null)
            this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        if(phone != null)
            this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if(address != null)
            this.address = address;
    }

    @Override
    public String toString() {
        return String.format("FIO: %s %s %s, phone: %s, email: %s, address: %s", name, surname, fathername, phone, email, address);
    }
}
