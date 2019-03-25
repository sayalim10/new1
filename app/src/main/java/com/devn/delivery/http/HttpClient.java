package com.devn.delivery.http;

import com.devn.delivery.BuildConfig;
import com.devn.delivery.http.utils.Auth;
import com.devn.delivery.http.utils.RegisterRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpClient {
    private static HttpClient httpClient = null;
    private Retrofit mRetrofit = null;
    private IHttpInterface httpInterface = null;

    private HttpClient() {
        httpInterface = getRetrofit().create(IHttpInterface.class);
    }

    public static HttpClient INSTANCE() {
        if (httpClient == null)
            httpClient = new HttpClient();
        return httpClient;
    }

    private Retrofit getRetrofit() {
        if (mRetrofit == null) {
            Interceptor interceptor = new Interceptor() {
                @Override
                public Response intercept(Chain chain) throws IOException {
                    Request request = chain.request();
                    List<String> customAnnotation = request.headers().values("@");
                    boolean setAuth = true;
                    if (customAnnotation.size() > 0) {
                        for (String annotations : customAnnotation) {
                            if (annotations.equals("NO_AUTH")) {
                                setAuth = false;
                            }
                        }
                    }

                    if (setAuth) {
                        Request.Builder requestBuilder = request.newBuilder();
//                        requestBuilder.addHeader("Authorization", "******");
                        request = requestBuilder.build();
                    }

                    return chain.proceed(request);
                }
            };

            OkHttpClient.Builder okhttpClient = new OkHttpClient.Builder();
            okhttpClient.readTimeout(180, TimeUnit.SECONDS).connectTimeout(180, TimeUnit.SECONDS);
            okhttpClient.addInterceptor(interceptor);

            if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor mHttpLoggingInterceptor = new HttpLoggingInterceptor();
                mHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
                okhttpClient.addInterceptor(mHttpLoggingInterceptor);
            }
            Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
            Retrofit.Builder retroBuilder = new Retrofit.Builder().baseUrl(BuildConfig.HOST).client(okhttpClient.build()).addConverterFactory(GsonConverterFactory.create(gson));
            mRetrofit = retroBuilder.build();


            /**
             * Add for new HOST configuration
             *
             *             Gson newHostGson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
             *             Retrofit.Builder newRetroBuilder = new Retrofit.Builder().baseUrl(BuildConfig.HOST).client(okhttpClient.build()).addConverterFactory(GsonConverterFactory.create(newGson));
             *             newRetrofit = newRretroBuilder.build();
             */


        }
        return mRetrofit;
    }

    public void registerUser(String username, String password, String email, Callback<Auth> authCallback) {
        RegisterRequest request = new RegisterRequest(username, email, password);
        httpInterface.registerUser(request).enqueue(authCallback);
    }
}
