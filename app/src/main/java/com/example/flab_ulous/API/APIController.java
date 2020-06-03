package com.example.flab_ulous.API;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIController {
    @FormUrlEncoded
    @POST("oauth/token?grant_type=password")
    Call<Oauth> login(@Header("Authorization") String authorization ,
                      @Field("username") String username,
                      @Field("password") String password);



    @GET("/rest/report/{id}")
    Call<ReportResponseModel> getReport(@Path("id") int id);

    @GET("/rest/diet/{id}")
    Call<DietPlanResponseModel> getDietPlan(@Path("id") int id);



}

