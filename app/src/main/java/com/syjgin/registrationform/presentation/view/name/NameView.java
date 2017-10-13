package com.syjgin.registrationform.presentation.view.name;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface NameView extends MvpView {

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setup(String name, String surname, String fathername);
}
