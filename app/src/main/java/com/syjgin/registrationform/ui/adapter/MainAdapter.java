package com.syjgin.registrationform.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public class MainAdapter extends FragmentPagerAdapter {

    public interface AdapterDelegate {
        Fragment getItem(int position);
        int getCount();
    }

    private AdapterDelegate delegate;

    public MainAdapter(FragmentManager fm, AdapterDelegate delegate) {
        super(fm);
        this.delegate = delegate;
    }

    @Override
    public Fragment getItem(int position) {
        return delegate.getItem(position);
    }

    @Override
    public int getCount() {
        return delegate.getCount();
    }
}
