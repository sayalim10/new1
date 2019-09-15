package com.devn.delivery.http;

import com.devn.delivery.http.utils.Auth;
import com.devn.delivery.http.utils.RegisterRequest;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import static com.devn.delivery.http.Api.REGISTER;

public interface IHttpInterface {

    //@POST(REGISTER + "{username}/{password}/")
    //Call<Auth> authenticateUser(@Path("username") String username, @Path("password") String password);
//    @POST(REGISTER)
//    Call<Auth> registerUser(@QueryMap Map<String, String> query);
    @POST(REGISTER)
    Call<Auth> registerUser(@Body RegisterRequest request);

}
