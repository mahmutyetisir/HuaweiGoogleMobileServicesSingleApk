package com.dtsedemo.huaweigoogleservicessingleapk.manager.location;

import android.app.Activity;

import com.dtsedemo.huaweigoogleservicessingleapk.manager.location.factory.LocationFactory;
import com.dtsedemo.huaweigoogleservicessingleapk.manager.location.factory.Locations;
import com.dtsedemo.huaweigoogleservicessingleapk.manager.location.listener.LocationListener;
import com.dtsedemo.huaweigoogleservicessingleapk.util.CheckServicesAvailable;

public class HuaweiGoogleLocationManager {
    private Activity activity;
    private Locations locationService;

    public HuaweiGoogleLocationManager(Activity activity) {
        this.activity = activity;
        locationService = LocationFactory.getLocationService(activity, CheckServicesAvailable.getAvailableService(activity));
    }

    public void subscribewLocationUpdates(LocationListener locationListener) {
        locationService.subscribewLocationUpdates(locationListener);
    }

    public void unsubscribeLocationUpdates() {
        locationService.unsubscribeLocationUpdates();
    }

    public void getLastKnownLocation(LocationListener locationListener) {
        locationService.getLastKnownLocation(locationListener);
    }
}
