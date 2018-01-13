
package com.example.hasanpc.weatherapp.listener;

import com.example.hasanpc.weatherapp.data.LocationResult;

public interface GeocodingServiceListener {
    void geocodeSuccess(LocationResult location);

    void geocodeFailure(Exception exception);
}
