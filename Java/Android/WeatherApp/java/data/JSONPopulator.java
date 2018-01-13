
package com.example.hasanpc.weatherapp.data;

import org.json.JSONObject;

public interface JSONPopulator {
    void populate(JSONObject data);

    JSONObject toJSON();
}
