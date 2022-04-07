package com.example.barberappsecproject.model.remote.data

import com.google.gson.annotations.SerializedName

data class Signup(
    @SerializedName("mobileNo")
    val mobileNo:String,
    @SerializedName("password")
    val password:String
)
