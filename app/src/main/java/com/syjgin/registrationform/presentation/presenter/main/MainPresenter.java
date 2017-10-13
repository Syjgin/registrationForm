package com.syjgin.registrationform.presentation.presenter.main;


import android.support.v4.app.Fragment;

import com.arellomobile.mvp.InjectViewState;
import com.arellomobile.mvp.MvpPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.app.App;
import com.syjgin.registrationform.model.ValidationEvent;
import com.syjgin.registrationform.navigation.FragmentId;
import com.syjgin.registrationform.presentation.view.main.MainView;
import com.syjgin.registrationform.ui.adapter.MainAdapter;
import com.syjgin.registrationform.ui.fragment.address.AddressFragment;
import com.syjgin.registrationform.ui.fragment.contacts.ContactsFragment;
import com.syjgin.registrationform.ui.fragment.name.NameFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import static com.syjgin.registrationform.navigation.FragmentId.FRAGMENT_ID_NAME;
import static com.syjgin.registrationform.navigation.FragmentId.FRAGMENT_ID_NONE;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> implements MainAdapter.AdapterDelegate {

    private int currentFragment = 0;

    public void onCreate() {
        refreshViewState();
        if(!EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().register(this);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    private void refreshViewState() {
        FragmentId currentId = FragmentId.valueOf(currentFragment);
        boolean backButtonVisible = false;
        String title = "";
        String buttonTitle = "";
        switch (currentId) {
            case FRAGMENT_ID_NAME:
                backButtonVisible = false;
                title = App.instance().getString(R.string.personal_data);
                buttonTitle = App.instance().getString(R.string.next);
                break;
            case FRAGMENT_ID_CONTACTS:
                backButtonVisible = true;
                title = App.instance().getString(R.string.contacts);
                buttonTitle = App.instance().getString(R.string.next);
                break;
            case FRAGMENT_ID_ADDRESS:
                backButtonVisible = true;
                title = App.instance().getString(R.string.address);
                buttonTitle = App.instance().getString(R.string.done);
                break;
            case FRAGMENT_ID_NONE:
                break;
        }
        getViewState().setTitle(title);
        getViewState().setBackButtonVisible(backButtonVisible);
        getViewState().setButtonText(buttonTitle);
        getViewState().setCurrentFragment(currentFragment);
    }

    public void onNextButtonClick() {
        FragmentId nextFragment = FragmentId.valueOf(currentFragment+1);
        if(nextFragment != FRAGMENT_ID_NONE) {
            currentFragment = nextFragment.getValue();
            refreshViewState();
        }
    }


    public void onBackButtonClick() {
        if(currentFragment == FRAGMENT_ID_NAME.getValue()) {
            getViewState().finish();
            return;
        }
        FragmentId prevFragment = FragmentId.valueOf(currentFragment-1);
        currentFragment = prevFragment.getValue();
        refreshViewState();
    }

    @Subscribe
    public void setButtonEnabled(ValidationEvent event) {
        getViewState().setButtonEnabled(event.isValidationSuccess());
    }

    @Override
    public Fragment getItem(int position) {
        FragmentId fragmentId = FragmentId.valueOf(position);
        switch (fragmentId) {
            case FRAGMENT_ID_NAME:
                return new NameFragment();
            case FRAGMENT_ID_CONTACTS:
                return new ContactsFragment();
            case FRAGMENT_ID_ADDRESS:
                return new AddressFragment();
            case FRAGMENT_ID_NONE:
                break;
        }
        return null;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
