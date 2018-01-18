
package com.example.api.api.model.response.weather;

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
