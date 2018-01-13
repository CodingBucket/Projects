
package com.example.hasanpc.weatherapp.listener;

import com.example.hasanpc.weatherapp.data.Channel;

public interface WeatherServiceListener {
    void serviceSuccess(Channel channel);

    void serviceFailure(Exception exception);
}
