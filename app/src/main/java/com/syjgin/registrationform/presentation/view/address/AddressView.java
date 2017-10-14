package com.syjgin.registrationform.presentation.view.address;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

import java.util.ArrayList;

public interface AddressView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void renderResponse(ArrayList<String> response);
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setAddress(String address);
}
