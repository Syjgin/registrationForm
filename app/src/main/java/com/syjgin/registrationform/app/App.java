package com.syjgin.registrationform.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by maksimovoleg on 13/10/2017.
 */

public class App extends Application {

    private static App appInstance;
    public static App instance() {
        return appInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appInstance = this;
    }

    public Context getContext() { return appInstance.getApplicationContext(); }
}
