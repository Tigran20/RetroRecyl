
package com.alextroy.tf_alextroy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Currency {

    @SerializedName("base")
    @Expose
    private String base;

    @SerializedName("date")
    @Expose
    private String date;

    public String getBase() {
        return base;
    }

    public String getDate() {
        return date;
    }


}
