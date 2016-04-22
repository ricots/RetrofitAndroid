package com.example.davidmartins.retrofittutorial.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by davidmartins on 22/04/16.
 */

public class Catalog {

    @Expose
    @SerializedName("courses")
    public List<Course> courses;
}
