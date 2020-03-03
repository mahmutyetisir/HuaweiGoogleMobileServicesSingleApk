package com.dtsedemo.huaweigoogleservicessingleapk.manager.location.factory;

import android.app.Activity;

import com.dtsedemo.huaweigoogleservicessingleapk.util.DistributeType;

public class LocationFactory {

    public static Locations getLocationService(Activity activity, DistributeType type) {
        if (DistributeType.HUAWEI_SERVICES == type) {
            return new HuaweiLocationServiceImpl(activity);
        } else {
            return new GoogleLocationServiceImpl(activity);
        }
    }
}
