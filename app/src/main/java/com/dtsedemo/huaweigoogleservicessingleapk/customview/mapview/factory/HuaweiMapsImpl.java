package com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapMarkerClickListener;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapReadyListener;
import com.huawei.hms.maps.HuaweiMap;
import com.huawei.hms.maps.MapView;
import com.huawei.hms.maps.OnMapReadyCallback;
import com.huawei.hms.maps.model.LatLng;
import com.huawei.hms.maps.model.MarkerOptions;

public class HuaweiMapsImpl extends BaseMaps implements OnMapReadyCallback {

    private MapView mapView;
    private HuaweiMap map;
    private OnMapReadyListener onMapReadyListener;

    HuaweiMapsImpl(Context context) {
        super(context);
        mapView = new MapView(context);
    }

    @Override
    public View getMapView() {
        return mapView;
    }

    @Override
    public void onCreate(Bundle bundle) {
        mapView.onCreate(bundle);
    }

    @Override
    public void getMapAsync(OnMapReadyListener onMapReadyListener) {
        this.onMapReadyListener = onMapReadyListener;
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(HuaweiMap huaweiMap) {
        map = huaweiMap;
        this.onMapReadyListener.onMapReady();
    }

    @Override
    public void addMarker(String title, String snippet, Float latitude, Float longitude) {
        super.addMarker(title, snippet, latitude, longitude);
        LatLng nyHuawei = new com.huawei.hms.maps.model.LatLng(latitude, longitude);
        MarkerOptions markerOptionsHuawei = new MarkerOptions().position(nyHuawei);
        if (title != null && !title.isEmpty()) markerOptionsHuawei.title(title);
        if (snippet != null && !snippet.isEmpty()) markerOptionsHuawei.snippet(snippet);
        map.addMarker(markerOptionsHuawei);
    }

    @Override
    public void setOnInfoWindowClickListener(final OnMapMarkerClickListener onMapMarkerClickListener) {
        map.setOnInfoWindowClickListener(new HuaweiMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(com.huawei.hms.maps.model.Marker marker) {
                onMapMarkerClickListener.onMarkerClick(marker.getTitle(), marker.getSnippet());
            }
        });
    }

    @Override
    public void moveCamera(Float latitude, Float longitude, Float zoomRatio) {
        super.moveCamera(latitude, longitude, zoomRatio);
        LatLng nyHuawei = new com.huawei.hms.maps.model.LatLng(latitude, longitude);
        map.moveCamera(com.huawei.hms.maps.CameraUpdateFactory.newLatLngZoom(nyHuawei, zoomRatio));
    }

    @Override
    public void animateCamera(Float latitude, Float longitude, Float zoomRatio) {
        super.animateCamera(latitude, longitude, zoomRatio);
        LatLng nyHuawei = new com.huawei.hms.maps.model.LatLng(latitude, longitude);
        map.animateCamera(com.huawei.hms.maps.CameraUpdateFactory.newLatLngZoom(nyHuawei, zoomRatio));
    }

    @Override
    public void setMyLocationEnabled(Boolean myLocationEnabled) {
        map.setMyLocationEnabled(myLocationEnabled);
    }

    @Override
    public void clear() {
        map.clear();
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        mapView.onSaveInstanceState(bundle);
    }

    @Override
    public void onStart() {
        mapView.onStart();
    }

    @Override
    public void onResume() {
        mapView.onResume();
    }

    @Override
    public void onPause() {
        mapView.onPause();
    }

    @Override
    public void onStop() {
        mapView.onStop();
    }

    @Override
    public void onDestroy() {
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        mapView.onLowMemory();
    }
}
