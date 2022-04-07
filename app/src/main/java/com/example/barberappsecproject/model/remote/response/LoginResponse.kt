package com.example.barberappsecproject.model.remote.response

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("apiToken")
    val apiToken: String,
    @SerializedName("createdOn")
    val createdOn: String,
    @SerializedName("dateOfBirth")
    val dateOfBirth: String,
    @SerializedName("deletedOn")
    val deletedOn: String,
    @SerializedName("emailId")
    val emailId: String,
    @SerializedName("emailVerificationCode")
    val emailVerificationCode: String,
    @SerializedName("evcExpiresOn")
    val evcExpiresOn: String,
    @SerializedName("fcmToken")
    val fcmToken: String,
    @SerializedName("fullName")
    val fullName: String="Customer",
    @SerializedName("gender")
    val gender: String,
    @SerializedName("ipAddresse")
    val ipAddresse: String,
    @SerializedName("isActive")
    val isActive: String,
    @SerializedName("isDeleted")
    val isDeleted: String,
    @SerializedName("isEmailVerified")
    val isEmailVerified: String,
    @SerializedName("isMobileVerified")
    val isMobileVerified: String,
    @SerializedName("message")
    val message: String,
    @SerializedName("mobileNo")
    val mobileNo: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("profilePic")
    val profilePic: String,
    @SerializedName("status")
    val status: Int,
    @SerializedName("tokenValidUpto")
    val tokenValidUpto: String,
    @SerializedName("updatedOn")
    val updatedOn: String,
    @SerializedName("userId")
    val userId: String
)