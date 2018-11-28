package com.utad.barriforinitework3.Fortnite;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface ForniteAPI {

    @Headers("TRN-Api-Key: 48057d93-96dc-41a1-b740-2a3e605ee4e9")
    @GET("profile/{platform}/{epic-nickname}")
    Observable<UserFortnite> getFortniteInfo(@Path("platform") String platformGame, @Path("epic-nickname") String epic_nickname_user);


    static ForniteAPI Factory(){
        Retrofit conex = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return conex.create(ForniteAPI.class);
    }
}