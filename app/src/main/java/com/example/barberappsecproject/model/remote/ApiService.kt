package com.example.barberappsecproject.model.remote

import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.data.Signup
import com.example.barberappsecproject.model.remote.response.LoginResponse
import com.example.barberappsecproject.model.remote.response.Response
import com.example.barberappsecproject.model.remote.response.getBarberResponse
import com.example.barberappsecproject.model.remote.response.getServicesResponse
import io.reactivex.*
import retrofit2.create
import retrofit2.http.*

interface ApiService {

    @POST("AppUser/login")
    @Headers("Content-type: application/json")
    fun login(
        @Body login:Login
    ): Observable<LoginResponse>


    @POST("AppUser/signup")
    @Headers("Content-type: application/json")
    fun signup(
        @Body signup: Signup
    ): Observable<Response>

    @GET("Barber/getBarbers")
    @Headers("ps_auth_token: hBkclZtTdXR2sEvm5DgSC0Ia6OjpYLx1")
    fun getBarbers(
    ): Observable<getBarberResponse>

    @GET("Service/getServices")
    fun getServices(
    ): Observable<getServicesResponse>


    companion object{
        fun getInstance()=ApiClient.retrofit.create(ApiService::class.java)
    }
}