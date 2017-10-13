package com.syjgin.registrationform.ui.fragment.name;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.arellomobile.mvp.MvpAppCompatFragment;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.presentation.presenter.name.NamePresenter;
import com.syjgin.registrationform.presentation.view.name.NameView;
import com.syjgin.registrationform.utils.AfterTextChangedWatcher;

public class NameFragment extends MvpAppCompatFragment implements NameView {
    @InjectPresenter
    NamePresenter presenter;

    private EditText nameField;
    private EditText surnameField;
    private EditText fathernameField;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container,
                             final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_name, container, false);
        nameField = view.findViewById(R.id.nameField);
        surnameField = view.findViewById(R.id.surnameField);
        fathernameField = view.findViewById(R.id.fathernameField);
        presenter.onCreate();
        return view;
    }

    @Override
    public void setup(String name, String surname, String fathername) {
        nameField.setText(name);
        surnameField.setText(surname);
        fathernameField.setText(fathername);
        nameField.addTextChangedListener(new AfterTextChangedWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.updateName(editable.toString());
            }
        });
        surnameField.addTextChangedListener(new AfterTextChangedWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.updateSurname(editable.toString());
            }
        });
        fathernameField.addTextChangedListener(new AfterTextChangedWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                presenter.updateFathername(editable.toString());
            }
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
