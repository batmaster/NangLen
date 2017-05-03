package com.nanglen.social.services;

import android.app.Application;

public class NangLenApplication extends Application {

    private HTTPService httpService;
    private Preferences preferences;

    private F

    @Override
    public void onCreate() {
        super.onCreate();

        httpService = new HTTPService(this);
        preferences = new Preferences(this);


    }

    public HTTPService getHttpService() {
        return httpService;
    }

    public Preferences getPreferences() {
        return preferences;
    }
}
