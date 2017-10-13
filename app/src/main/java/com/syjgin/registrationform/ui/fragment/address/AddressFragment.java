package com.syjgin.registrationform.ui.fragment.address;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.presentation.presenter.address.AddressPresenter;
import com.syjgin.registrationform.presentation.view.address.AddressView;
import com.syjgin.registrationform.ui.fragment.base.BaseFormFragment;

public class AddressFragment extends BaseFormFragment implements AddressView {
    @InjectPresenter
    AddressPresenter presenter;

    private EditText addressText;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);
        addressText = view.findViewById(R.id.address);
        return view;
    }

    @Override
    protected void onFirstVisible() {
        presenter.onCreate();
    }
}
