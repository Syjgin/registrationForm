package com.syjgin.registrationform.presentation.presenter.contacts;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.syjgin.registrationform.model.FormData;
import com.syjgin.registrationform.presentation.view.contacts.ContactsView;

import org.greenrobot.eventbus.EventBus;

import java.util.regex.Pattern;

@InjectViewState
public class ContactsPresenter extends MvpPresenter<ContactsView> {
    private String phoneNumber = "";
    private String email = "";

    public void onCreate() {
        validate();
    }

    private void validate() {
        boolean isValid = validatePhone() && validateEmail();
        FormData event = new FormData(isValid);
        if(isValid) {
            event.setEmail(email);
            event.setPhone(phoneNumber);
        }
        EventBus.getDefault().post(event);
    }

    public void updatePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        validate();
    }

    public void updateEmail(String email) {
        this.email = email;
        validate();
    }

    private boolean validateEmail() {
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        return emailPattern.matcher(email).find();
    }

    private boolean validatePhone() {
        Pattern phonePattern = Pattern.compile("^[0-9]{10}$", Pattern.CASE_INSENSITIVE);
        return phonePattern.matcher(phoneNumber).find();
    }
}
