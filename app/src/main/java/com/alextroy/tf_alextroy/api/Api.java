package com.alextroy.tf_alextroy.api;

import com.alextroy.tf_alextroy.model.JSONResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {
    @GET("api/latest")
    Call<JSONResponse> loadCurrency(@Query("access_key") String key);
}
