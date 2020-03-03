package com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.dtsedemo.huaweigoogleservicessingleapk.R;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory.MapFactory;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory.Maps;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapAsyncListener;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapMarkerClickListener;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapReadyListener;
import com.dtsedemo.huaweigoogleservicessingleapk.util.CheckServicesAvailable;

public class HuaweiGoogleMapView extends RelativeLayout implements OnMapReadyListener {

    Context context;
    Maps myMap;

    OnMapAsyncListener onMapAsyncListener;

    public HuaweiGoogleMapView(Context context) {
        super(context);
        this.context = context;
        inflateLayout();
    }

    public HuaweiGoogleMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        inflateLayout();
    }

    private void inflateLayout() {
        inflate(context, R.layout.huawei_google_map_view, this);
        RelativeLayout rootView = findViewById(R.id.rl_root_huawei_google_map_view);

        myMap = MapFactory.createAndGetMap(getContext(), CheckServicesAvailable.getAvailableService(context));
        myMap.getMapView().setLayoutParams(new LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT));
        rootView.addView(myMap.getMapView());
    }

    public void onCreate(Bundle bundle) {
        myMap.onCreate(bundle);
    }

    public void getMapAsync(OnMapAsyncListener onMapAsyncListener) {
        this.onMapAsyncListener = onMapAsyncListener;
        myMap.getMapAsync(this);
    }

    public void addMarker(String title, String snippet, Float latitude, Float longitude) {
        myMap.addMarker(title, snippet, latitude, longitude);
    }

    public void setOnInfoWindowClickListener(OnMapMarkerClickListener onMapMarkerClickListener) {
        myMap.setOnInfoWindowClickListener(onMapMarkerClickListener);
    }

    public void moveCamera(Float latitude, Float longitude, Float zoomRatio) {
        myMap.moveCamera(latitude, longitude, zoomRatio);
    }

    public void animateCamera(Float latitude, Float longitude, Float zoomRatio) {
        myMap.animateCamera(latitude, longitude, zoomRatio);
    }

    public void setMyLocationEnabled(Boolean myLocationEnabled) {
        myMap.setMyLocationEnabled(myLocationEnabled);
    }

    public void clear() {
        myMap.clear();
    }

    public Parcelable onSaveInstanceState(Bundle bundle) {
        myMap.onSaveInstanceState(bundle);
        return super.onSaveInstanceState();
    }

    public void onStart() {
        myMap.onStart();
    }

    public void onStop() {
        myMap.onStop();
    }


    public void onPause() {
        myMap.onPause();
    }

    public void onResume() {
        myMap.onResume();
    }

    public void onDestroy() {
        myMap.onDestroy();
    }

    public void onLowMemory() {
        myMap.onLowMemory();
    }

    @Override
    public void onMapReady() {
        onMapAsyncListener.onMapReady(this);
    }
}
