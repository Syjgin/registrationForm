package com.syjgin.registrationform.ui.fragment.base;

import com.arellomobile.mvp.MvpAppCompatFragment;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public abstract class BaseFormFragment extends MvpAppCompatFragment {
    protected boolean isUserVisibleHintFailed;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if(isVisibleToUser) {
            if(getView() != null) {
                onFirstVisible();
            } else {
                isUserVisibleHintFailed = true;
            }
        }
    }

    protected abstract void onFirstVisible();

    protected void finishSetup() {
        if(isUserVisibleHintFailed) {
            isUserVisibleHintFailed = false;
            onFirstVisible();
        }
    }
}
