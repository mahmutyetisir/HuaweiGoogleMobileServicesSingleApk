package com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory;

import android.content.Context;

import com.dtsedemo.huaweigoogleservicessingleapk.util.DistributeType;

public class MapFactory {

    public static Maps createAndGetMap(Context context, DistributeType type) {
        if (DistributeType.HUAWEI_SERVICES == type) {
            return new HuaweiMapsImpl(context);
        } else {
            return new GoogleMapsImpl(context);
        }
    }
}
