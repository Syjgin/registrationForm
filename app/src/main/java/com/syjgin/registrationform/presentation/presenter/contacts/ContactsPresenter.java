package com.syjgin.registrationform.presentation.presenter.contacts;


import com.syjgin.registrationform.model.ValidationEvent;
import com.syjgin.registrationform.presentation.view.contacts.ContactsView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

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
        Pattern phonePattern = Pattern.compile("^\\+[0-9]\\([0-9]{3}\\)[0-9]{3}-[0-9]{2}-[0-9]{2}$", Pattern.CASE_INSENSITIVE);
        Pattern emailPattern = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        boolean isPhoneValid = phonePattern.matcher(phoneNumber).find();
        boolean isEmailValid = emailPattern.matcher(email).find();
        boolean isValid = isPhoneValid && isEmailValid;
        EventBus.getDefault().post(new ValidationEvent(isValid));
    }

    public void updatePhone(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        validate();
    }

    public void updateEmail(String email) {
        this.email = email;
        validate();
    }
}
