package com.syjgin.registrationform.presentation.presenter.name;


import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.syjgin.registrationform.model.ValidationEvent;
import com.syjgin.registrationform.presentation.view.name.NameView;

import org.greenrobot.eventbus.EventBus;

@InjectViewState
public class NamePresenter extends MvpPresenter<NameView> {

    private String name = "";
    private String surname = "";
    private String fathername = "";

    public void onCreate() {
        validate();
        getViewState().setup(name, surname, fathername);
    }

    private void validate() {
        boolean isValid = !name.isEmpty() && !surname.isEmpty() && !fathername.isEmpty();
        EventBus.getDefault().post(new ValidationEvent(isValid));
    }

    public void updateName(String name) {
        this.name = name;
        validate();
    }

    public void updateSurname(String surname) {
        this.surname = surname;
        validate();
    }

    public void updateFathername(String fathername) {
        this.fathername = fathername;
        validate();
    }
}
