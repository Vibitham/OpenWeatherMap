
package com.example.ottr008.openweathermap.services.model.weatherresponsemodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Rain {

    @SerializedName("3h")
    @Expose
    private Double time;

    public Double get3h() {
        return time;
    }

    public void set3h(Double time) {
        this.time = time;
    }

}
