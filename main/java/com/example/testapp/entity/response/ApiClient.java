package com.example.testapp.entity.response;

import com.example.testapp.entity.LoginResponseUser;
import com.example.testapp.entity.RegisterResponseUser;
import com.example.testapp.entity.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface ApiClient {

    @POST("userService/login")
    Call<LoginResponseUser> login_inUser(@Body User User);

    @POST("userService/registration")
    Call<RegisterResponseUser>register_user(@Body User user );
}
