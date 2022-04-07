package com.example.barberappsecproject.model.remote.response

data class getBarberResponse(
    val barbers: List<Barber>,
    val status: Int
)

data class Barber(
    val barberId: String,
    val barberName: String,
    val breakTimeFrom: String,
    val breakTimeTo: String,
    val gender: String,
    val hasDefualtServices: String,
    val holiday: String,
    val isAdmin: String,
    val isBarber: String,
    val mobileNo: String,
    val password: String,
    val profilePic: String,
    val userRating: String
)