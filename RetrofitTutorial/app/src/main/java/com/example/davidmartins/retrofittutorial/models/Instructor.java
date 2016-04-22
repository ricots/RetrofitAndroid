package com.example.davidmartins.retrofittutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by davidmartins on 22/04/16.
 */
public class Instructor {

    @Expose
    @SerializedName("name")
    public String name;

    @Expose
    @SerializedName("bio")
    public String bio;

}
