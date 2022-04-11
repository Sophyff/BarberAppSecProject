package com.example.barberappsecproject.model.remote.response

import com.google.gson.annotations.SerializedName

data class ResponseInfo(
    @SerializedName("status")
    val status: Int,
    @SerializedName("message")
    val message: String
)
