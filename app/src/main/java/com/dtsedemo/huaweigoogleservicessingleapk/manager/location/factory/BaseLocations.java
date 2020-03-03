package com.dtsedemo.huaweigoogleservicessingleapk.manager.location.factory;

import android.app.Activity;
import android.util.Log;

abstract class BaseLocations implements Locations {
    private Activity activity;
    private String tag;

    BaseLocations(Activity activity, String tag) {
        this.activity = activity;
        this.tag = tag;
    }

    void log(String message) {
        Log.d(tag, message);
    }

    void logError(String message) {
        Log.e(tag, message);
    }
}
