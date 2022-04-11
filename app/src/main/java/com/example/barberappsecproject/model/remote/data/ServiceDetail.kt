package com.example.barberappsecproject.model.remote.data

import com.google.gson.annotations.SerializedName

data class ServiceDetail(
    @SerializedName("cost")
    val cost: String,
    @SerializedName("duration")
    val duration: String,
    @SerializedName("serviceId")
    val serviceId: String,
    @SerializedName("serviceName")
    val serviceName: String,
    @SerializedName("servicePic")
    val servicePic: String
)