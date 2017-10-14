package com.syjgin.registrationform.repository;

import android.net.TrafficStats;

import com.google.gson.GsonBuilder;

import java.io.IOException;

import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user1 on 13.10.17.
 */

public class Repository {
    private static DaDataApi api;
    public static DaDataApi getRepository() {
        if(api == null) {
            api = new Retrofit
                    .Builder().baseUrl("https://suggestions.dadata.ru/")
                    .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().create()))
                    .client(new OkHttpClient.Builder()
                            .addInterceptor(new Interceptor() {
                                @Override
                                public Response intercept(Chain chain) throws IOException {
                                    Request original = chain.request();
                                    Request.Builder builder = original.newBuilder();
                                    builder.addHeader("Content-Type", "application/json");
                                    builder.addHeader("Accept", "application/json");
                                    builder.addHeader("Authorization", "Token 9dd6d7b3a20b409da53ff45a87f56f7fe4c2545c");
                                    Request changed = builder.build();
                                    TrafficStats.setThreadStatsTag(0xF00D);
                                    return chain.proceed(changed);
                                }
                            }).build())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build().create(DaDataApi.class);
        }
        return api;
    }
}
