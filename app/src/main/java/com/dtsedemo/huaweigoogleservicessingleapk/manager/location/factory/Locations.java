package com.dtsedemo.huaweigoogleservicessingleapk.manager.location.factory;

import com.dtsedemo.huaweigoogleservicessingleapk.manager.location.listener.LocationListener;

public interface Locations {
    void subscribewLocationUpdates(LocationListener locationListener);
    void unsubscribeLocationUpdates();
    void getLastKnownLocation(LocationListener locationListener);
}
