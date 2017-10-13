package com.syjgin.registrationform.ui.fragment.contacts;

import android.os.Bundle;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.presentation.presenter.contacts.ContactsPresenter;
import com.syjgin.registrationform.presentation.view.contacts.ContactsView;
import com.syjgin.registrationform.ui.fragment.base.BaseFormFragment;
import com.syjgin.registrationform.utils.AfterTextChangedWatcher;

import br.com.sapereaude.maskedEditText.MaskedEditText;

public class ContactsFragment extends BaseFormFragment implements ContactsView {
    @InjectPresenter
    ContactsPresenter presenter;

    private MaskedEditText phoneText;
    private EditText emailText;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        emailText = view.findViewById(R.id.email);
        emailText.addTextChangedListener(new AfterTextChangedWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.updateEmail(editable.toString());
            }
        });

        phoneText = view.findViewById(R.id.phoneNumber);
        phoneText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId,KeyEvent event) {
                switch (actionId) {
				case EditorInfo.IME_ACTION_NEXT:
					return false;
                    default:
                        return true;
                }
            }
        });
        phoneText.addTextChangedListener(new AfterTextChangedWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.updatePhone(phoneText.getRawText());
            }
        });

        finishSetup();
        return view;
    }

    @Override
    protected void onFirstVisible() {
        presenter.onCreate();
    }
}
