package com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory;

import android.content.Context;
import android.os.Bundle;

abstract class BaseMaps implements Maps {
    private Context context;

    BaseMaps(Context context) {
        this.context = context;
    }

    @Override
    public void moveCamera(Float latitude, Float longitude, Float zoomRatio) {
        if (latitude == null || longitude == null || zoomRatio == null) throw new NullPointerException("Params can not be Null object reference at moveCamera()");
    }

    @Override
    public void animateCamera(Float latitude, Float longitude, Float zoomRatio) {
        if (latitude == null || longitude == null || zoomRatio == null) throw new NullPointerException("Params can not be Null object reference at animateCamera()");
    }

    @Override
    public void addMarker(String title, String snippet, Float latitude, Float longitude) {
        if (latitude == null || longitude == null) throw new NullPointerException("Latitude, Longitude can not be Null object reference at addMarker()");
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        if (bundle==null) throw new NullPointerException("Bundle can not be Null object reference at onSaveInstanceState()");
    }
}
