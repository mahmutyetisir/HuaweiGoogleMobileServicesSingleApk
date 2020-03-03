package com.dtsedemo.huaweigoogleservicessingleapk.manager.location.factory;

import android.app.Activity;
import android.location.Location;
import android.os.Looper;

import com.dtsedemo.huaweigoogleservicessingleapk.manager.location.listener.LocationListener;
import com.huawei.hmf.tasks.OnFailureListener;
import com.huawei.hmf.tasks.OnSuccessListener;
import com.huawei.hms.location.FusedLocationProviderClient;
import com.huawei.hms.location.LocationCallback;
import com.huawei.hms.location.LocationRequest;
import com.huawei.hms.location.LocationResult;
import com.huawei.hms.location.LocationServices;

public class HuaweiLocationServiceImpl extends BaseLocations {
    private FusedLocationProviderClient fusedLocationProviderClient;
    private LocationCallback mLocationCallback;

    HuaweiLocationServiceImpl(Activity activity) {
        super(activity, "HuaweiLocationServiceImpl");
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
    }

    @Override
    public void subscribewLocationUpdates(final LocationListener locationListener) {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(100000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);

        if (this.mLocationCallback == null) {

            this.mLocationCallback = new LocationCallback() {
                @Override
                public void onLocationResult(LocationResult locationResult) {
                    if (locationResult != null) {
                        Location location = new Location("HuaweiLocation");
                        location.setLatitude(locationResult.getLastLocation().getLatitude());
                        location.setLongitude(locationResult.getLastLocation().getLongitude());
                        locationListener.onLocationUpdate(location);
                    }
                }
            };

            fusedLocationProviderClient
                    .requestLocationUpdates(mLocationRequest, this.mLocationCallback, Looper.getMainLooper())
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            log("Subscribed location updates with Huawei Services");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            logError("Subscribe process is fail with Huawei Services " + e.getMessage());
                        }
                    });
        } else {
            logError("You are already subscribed location updates");
        }
    }

    @Override
    public void unsubscribeLocationUpdates() {
        if (this.mLocationCallback == null) return;
        else {
            fusedLocationProviderClient.removeLocationUpdates(this.mLocationCallback)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            log("Unsubscribed location updates with Huawei Services");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(Exception e) {
                            logError("Unsubscribe process is fail with Huawei Services " + e.getMessage());
                        }
                    });
        }
    }

    @Override
    public void getLastKnownLocation(final LocationListener locationListener) {
        fusedLocationProviderClient.getLastLocation()
                .addOnSuccessListener(new OnSuccessListener<android.location.Location>() {
                    @Override
                    public void onSuccess(android.location.Location location) {
                        Location locationTemp = new Location("HuaweiLocation");
                        locationTemp.setLatitude(location.getLatitude());
                        locationTemp.setLongitude(location.getLongitude());
                        locationListener.onLocationUpdate(location);
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(Exception e) {
                        logError("getLastKnownLocation process is fail with Huawei Services " + e.getMessage());
                    }
                });
    }
}
