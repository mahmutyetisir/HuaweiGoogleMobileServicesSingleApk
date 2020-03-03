package com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.factory;

import android.content.Context;
import android.os.Bundle;
import android.view.View;

import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapMarkerClickListener;
import com.dtsedemo.huaweigoogleservicessingleapk.customview.mapview.listener.OnMapReadyListener;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class GoogleMapsImpl extends BaseMaps implements OnMapReadyCallback {

    private MapView mapView;
    private GoogleMap map;
    private OnMapReadyListener myOnMapAsyncListener;

    GoogleMapsImpl(Context context) {
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
        this.myOnMapAsyncListener = onMapReadyListener;
        mapView.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        this.myOnMapAsyncListener.onMapReady();
    }

    @Override
    public void addMarker(String title, String snippet, Float latitude, Float longitude) {
        super.addMarker(title, snippet, latitude, longitude);
        LatLng nyGoogle = new LatLng(latitude, longitude);
        MarkerOptions markerOptionsGoogle = new MarkerOptions().position(nyGoogle);
        if (title != null && !title.isEmpty()) markerOptionsGoogle.title(title);
        if (snippet != null && !snippet.isEmpty()) markerOptionsGoogle.snippet(snippet);
        map.addMarker(markerOptionsGoogle);
    }

    @Override
    public void setOnInfoWindowClickListener(final OnMapMarkerClickListener onMapMarkerClickListener) {
        map.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                onMapMarkerClickListener.onMarkerClick(marker.getTitle(), marker.getSnippet());
            }
        });
    }

    @Override
    public void moveCamera(Float latitude, Float longitude, Float zoomRatio) {
        super.moveCamera(latitude, longitude, zoomRatio);
        LatLng nyGoogle = new LatLng(latitude, longitude);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(nyGoogle, zoomRatio));
    }

    @Override
    public void animateCamera(Float latitude, Float longitude, Float zoomRatio) {
        super.animateCamera(latitude, longitude, zoomRatio);
        LatLng nyGoogle = new LatLng(latitude, longitude);
        map.animateCamera(CameraUpdateFactory.newLatLngZoom(nyGoogle, zoomRatio));
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
