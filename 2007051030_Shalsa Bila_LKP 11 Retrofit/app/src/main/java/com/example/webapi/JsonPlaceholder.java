package com.example.webapi;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceholder {
    @GET("comments")
    Call<List<Comment>> getComment();
}
