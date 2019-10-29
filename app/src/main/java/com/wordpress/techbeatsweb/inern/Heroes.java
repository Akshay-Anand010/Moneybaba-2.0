package com.wordpress.techbeatsweb.inern;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by DELL on 12-Oct-19.
 */

public class Heroes {


    @SerializedName("heroes")
    private ArrayList<Hero> heros;

    public Heroes(){

    }

    public ArrayList<Hero> getHeros(){
        return heros;
    }
}