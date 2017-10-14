package com.syjgin.registrationform.presentation.view.main;

import com.arellomobile.mvp.MvpView;
import com.arellomobile.mvp.viewstate.strategy.AddToEndSingleStrategy;
import com.arellomobile.mvp.viewstate.strategy.StateStrategyType;

public interface MainView extends MvpView {
    @StateStrategyType(AddToEndSingleStrategy.class)
    void setTitle(int resource);

    void finish();

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setButtonText(int resource);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setButtonEnabled(boolean isEnabled);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setCurrentFragment(int fragment);

    @StateStrategyType(AddToEndSingleStrategy.class)
    void setBackButtonVisible(boolean visible);
}
