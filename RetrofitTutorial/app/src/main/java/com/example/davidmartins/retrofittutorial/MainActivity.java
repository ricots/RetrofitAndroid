package com.example.davidmartins.retrofittutorial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.davidmartins.retrofittutorial.adapter.UdacityAdapter;
import com.example.davidmartins.retrofittutorial.api.UdacityService;
import com.example.davidmartins.retrofittutorial.models.Catalog;
import com.example.davidmartins.retrofittutorial.models.Course;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static final String URL = "https://www.udacity.com/public-api/v0/";
    public List<Course> courseList = new ArrayList<>();
    public UdacityAdapter courseAdapter;
    public RecyclerView courseRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courseRecyclerView = (RecyclerView) findViewById(R.id.courseRecyclerView);
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        UdacityService service = retrofit.create(UdacityService.class);
        Call<Catalog> request = service.getCourses();

        request.enqueue(new Callback<Catalog>() {
            @Override
            public void onResponse(Call<Catalog> call, Response<Catalog> response) {
                if (response.isSuccessful())
                {
                    //TODO Populate recyclerview
                    Catalog catalog = response.body();

                    for (Course c : catalog.courses) {
                        courseList.add(c);
                    }
                    courseAdapter = new UdacityAdapter(courseList);
                    courseRecyclerView.setAdapter(courseAdapter);
                } else {
                    Log.e(TAG, "Error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<Catalog> call, Throwable t) {
                Log.e(TAG, "ERROR: " + t.getMessage());
            }
        });


    }
}
