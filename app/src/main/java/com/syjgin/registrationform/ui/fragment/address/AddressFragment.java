package com.syjgin.registrationform.ui.fragment.address;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.presentation.presenter.address.AddressPresenter;
import com.syjgin.registrationform.presentation.view.address.AddressView;
import com.syjgin.registrationform.ui.fragment.base.BaseFormFragment;
import com.syjgin.registrationform.utils.AfterTextChangedWatcher;

import java.util.ArrayList;

public class AddressFragment extends BaseFormFragment implements AddressView {
    @InjectPresenter
    AddressPresenter presenter;

    private AutoCompleteTextView addressText;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_address, container, false);
        addressText = view.findViewById(R.id.address);
        addressText.addTextChangedListener(new AfterTextChangedWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.requestSuggestions(editable.toString());
            }
        });
        return view;
    }

    @Override
    protected void onFirstVisible() {
        presenter.onCreate();
    }

    @Override
    public void renderResponse(ArrayList<String> response) {
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(),
                android.R.layout.simple_dropdown_item_1line, response);
        addressText.setAdapter(adapter);
        if(response.size() > 1)
            addressText.showDropDown();
        else
            addressText.dismissDropDown();
    }

    @Override
    public void setAddress(String address) {
        addressText.setText(address);
    }
}
