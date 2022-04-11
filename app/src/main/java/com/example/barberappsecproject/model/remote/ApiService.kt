package com.example.barberappsecproject.model.remote

import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.data.Signup
import com.example.barberappsecproject.model.remote.response.*

import io.reactivex.*
import retrofit2.Call
import retrofit2.Response
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
    ): Observable<ResponseInfo>

    @GET("Barber/getBarbers")
    suspend fun getBarbers(
        @Header("ps_auth_token") apiToken:String
    ): Response<getBarberResponse>


    @POST("BarberServices/getBarberServices")
    suspend fun getBarberServices(
        @Header("ps_auth_token") apiToken:String,
        @Query("barberId") barberId:String,
        @Query("hasDefaultServices") default:String="1"
    ): Response<getServicesResponse>

    @GET("Appointment/currentAppointments/{barberId}")
    suspend fun getTimeSlot(
        @Header("ps_auth_token") apiToken:String,
        @Path("barberId") barberId:String
    ): Response<getTimeSlotResponse>


    @GET("Service/getServices")
    fun getServices(
    ): Observable<getServicesResponse>


    companion object{
        fun getInstance()=ApiClient.retrofit.create(ApiService::class.java)
    }
}