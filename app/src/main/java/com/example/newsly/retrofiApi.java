package com.example.newsly;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Url;

public interface retrofiApi {
    @GET
    Call<NewsModel> getAllnews(@Url String url);
    @GET
    Call<NewsModel>getNewsByCategory(@Url String url);
    @GET
    Call<NewsModel>getsearchnews(@Url String url);
}
