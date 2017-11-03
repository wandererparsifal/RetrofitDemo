package com.parsifal.retrofitdemo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by yangming on 17-11-3.
 */
public interface IGetRequest {

    @GET("geocoding/")
    Call<LatLon> getLatLon(@Query("a") String city);
}
