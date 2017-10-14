package com.syjgin.registrationform.ui.activity.main;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.arellomobile.mvp.MvpAppCompatActivity;
import com.arellomobile.mvp.presenter.InjectPresenter;
import com.syjgin.registrationform.R;
import com.syjgin.registrationform.presentation.presenter.main.MainPresenter;
import com.syjgin.registrationform.presentation.view.main.MainView;
import com.syjgin.registrationform.ui.adapter.MainAdapter;
import com.syjgin.registrationform.ui.view.UnscrollableViewPager;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    @InjectPresenter
    MainPresenter presenter;

    private Button nextButton;
    private MainAdapter adapter;
    private UnscrollableViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.onNextButtonClick();
            }
        });

        viewPager = findViewById(R.id.container);

        presenter.onCreate();
    }

    @Override
    public void setButtonText(int text) {
        nextButton.setText(text);
    }

    @Override
    public void setBackButtonVisible(boolean visible) {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(visible);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            presenter.onBackButtonClick();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        presenter.onBackButtonClick();
    }

    @Override
    public void setButtonEnabled(boolean isEnabled) {
        nextButton.setEnabled(isEnabled);
    }

    @Override
    public void setCurrentFragment(int fragment) {
        if(adapter == null) {
            adapter = new MainAdapter(getSupportFragmentManager(), presenter);
            viewPager.setAdapter(adapter);
            //viewPager.setOffscreenPageLimit(presenter.getCount());
        }
        viewPager.setCurrentItem(fragment);
    }
}
