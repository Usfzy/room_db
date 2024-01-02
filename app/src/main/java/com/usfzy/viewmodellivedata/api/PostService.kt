package com.usfzy.viewmodellivedata.api

import retrofit2.Call
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    fun getPosts(): Call<List<Post>>
}