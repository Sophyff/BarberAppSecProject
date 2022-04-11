package com.example.barberappsecproject.model.remote

import androidx.lifecycle.MutableLiveData
import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.data.Signup
import com.example.barberappsecproject.model.remote.response.LoginResponse

class Repository(val apiService: ApiService) {
   // val loginResponse= MutableLiveData<LoginResponse>()

    fun login(login: Login)=apiService.login(login)
    fun signup(signup: Signup)=apiService.signup(signup)
    suspend fun loadBarbers(apiToken:String)=apiService.getBarbers(apiToken)
    fun loadService()=apiService.getServices()

    suspend fun loadBarberService(apiToken:String,barberId:String,)=apiService.getBarberServices(apiToken,barberId,"1")
    suspend fun loadTimeSlot(apiToken:String,barberId:String,)=apiService.getTimeSlot(apiToken,barberId)
}