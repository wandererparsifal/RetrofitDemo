package com.parsifal.retrofitdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://gc.ditu.aliyun.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        IGetRequest getRequest = retrofit.create(IGetRequest.class);
        Call<LatLon> call = getRequest.getLatLon("大连市");
        call.enqueue(new Callback<LatLon>() {
            @Override
            public void onResponse(Call<LatLon> call, Response<LatLon> response) {
                Log.d("test", "response " + response.toString());
                Log.d("test", "string " + response.body().toString());
            }

            @Override
            public void onFailure(Call<LatLon> call, Throwable t) {
                Log.e("test", "onFailure");
            }
        });
    }
}
