package com.syjgin.registrationform.ui.view;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public class UnscrollableViewPager extends ViewPager {

    public UnscrollableViewPager(Context context) {
        super(context);
    }

    public UnscrollableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }


}
