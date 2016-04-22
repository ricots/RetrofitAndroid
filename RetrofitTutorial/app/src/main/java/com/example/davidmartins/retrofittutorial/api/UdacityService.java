package com.example.davidmartins.retrofittutorial.api;

import com.example.davidmartins.retrofittutorial.models.Catalog;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by davidmartins on 22/04/16.
 */
public interface UdacityService {

    @GET("courses")
    Call<Catalog> getCourses();
}
