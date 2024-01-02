package com.usfzy.viewmodellivedata.api

import com.google.gson.annotations.SerializedName

data class Post(
    @SerializedName("id") val id: Long,
    @SerializedName("userId") val userId: Long,
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String
)