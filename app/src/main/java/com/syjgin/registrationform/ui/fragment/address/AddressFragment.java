package com.syjgin.registrationform.ui.fragment.address;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.presentation.presenter.address.AddressPresenter;
import com.syjgin.registrationform.presentation.view.address.AddressView;

public class AddressFragment extends MvpAppCompatFragment implements AddressView {
    @InjectPresenter
    AddressPresenter presenter;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_address, container, false);
    }
}
