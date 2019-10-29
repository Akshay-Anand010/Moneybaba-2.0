package com.wordpress.techbeatsweb.inern;

import com.google.gson.annotations.SerializedName;

/**
 * Created by DELL on 12-Oct-19.
 */

public class Hero {

    @SerializedName("name")
    private String name;

    @SerializedName("imageurl")
    private String url;

    public Hero(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
}