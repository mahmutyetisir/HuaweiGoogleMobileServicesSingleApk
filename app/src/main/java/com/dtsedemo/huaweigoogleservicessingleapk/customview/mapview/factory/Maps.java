package com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory;

import android.os.Bundle;
import android.view.View;

import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapMarkerClickListener;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapReadyListener;

public interface Maps {
    View getMapView();
    void onCreate(Bundle bundle);
    void getMapAsync(OnMapReadyListener onMapReadyListener);
    void addMarker(String title, String snippet, Float latitude, Float longitude);
    void setOnInfoWindowClickListener(final OnMapMarkerClickListener onMapMarkerClickListener);
    void moveCamera(Float latitude, Float longitude, Float zoomRatio);
    void animateCamera(Float latitude, Float longitude, Float zoomRatio);
    void setMyLocationEnabled(Boolean myLocationEnabled);
    void clear();
    void onSaveInstanceState(Bundle bundle);
    void onStart();
    void onResume();
    void onPause();
    void onStop();
    void onDestroy();
    void onLowMemory();
}
