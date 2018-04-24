
package com.alextroy.tf_alextroy.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Currency {
    List<Items> list;

    public List<Items> getList() {
        return list;
    }

    public static class Items {
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

}
