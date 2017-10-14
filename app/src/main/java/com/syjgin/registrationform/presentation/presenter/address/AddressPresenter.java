package com.syjgin.registrationform.presentation.presenter.address;


import com.syjgin.registrationform.interactor.SuggestionInteractor;
import com.syjgin.registrationform.model.DaDataResponse;
import com.syjgin.registrationform.model.DaDataSuggestion;
import com.syjgin.registrationform.model.FormData;
import com.syjgin.registrationform.presentation.view.address.AddressView;
import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import java.util.ArrayList;

@InjectViewState
public class AddressPresenter extends MvpPresenter<AddressView> {

    private static final int MIN_LENGHT = 4;
    private boolean isRequestInProgress = false;
    private String addressText = "";

    private SuggestionInteractor interactor = new SuggestionInteractor();

    public void onCreate() {
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
        getViewState().setAddress(addressText);
        validate();
        requestSuggestions(addressText);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        interactor.unsubscribe();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onResponseReceived(DaDataResponse response) {
        ArrayList<String> values = new ArrayList<>();
        for(DaDataSuggestion suggestion : response.suggestions) {
            values.add(suggestion.value);
        }
        getViewState().renderResponse(values);
        isRequestInProgress = false;
    }

    private void validate() {
        FormData event = new FormData(!addressText.isEmpty());
        if(event.isValidationSuccess()) {
            event.setAddress(addressText);
        }
        EventBus.getDefault().post(event);
    }

    public void requestSuggestions(String text) {
        addressText = text;
        validate();
        if(text.length() < MIN_LENGHT)
            return;
        if(isRequestInProgress)
            return;
        isRequestInProgress = true;
        interactor.startLoading(text);
    }
}
