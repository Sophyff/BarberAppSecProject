package com.example.barberappsecproject.ui.book

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.ServiceDetail
import com.example.barberappsecproject.model.remote.response.Barber
import com.example.barberappsecproject.model.remote.response.Services
import com.example.barberappsecproject.model.remote.response.Slot
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class BookViewModel(val remote: Repository): ViewModel() {
    val services=MutableLiveData<Services>()
    val userId=MutableLiveData<String>()
    val apiToken=MutableLiveData<String>()

    val error=MutableLiveData<String>()
    val list=MutableLiveData<List<Barber>>()
    val selectedBarber=MutableLiveData<Barber>()
    val selectedService=MutableLiveData<ServiceDetail>()
    val timeSlots=MutableLiveData<List<Slot>>()



    fun loadBarber(){
      //  Log.d("tag","entry point to load barbers")
        viewModelScope.launch(Dispatchers.IO){
            try{
              //  Log.d("tag","entry point of view model coroutine")
                val response=remote.loadBarbers(apiToken.value!!)
           //     Log.d("tag","response of loadBarbers. ${response.code()}")
                if(!response.isSuccessful){
                    error.postValue("Something is wrong, please retry! ${response.code()}")
                    return@launch
                }
                val result=response.body()
                if(result ==null){
                    error.postValue("No response from server, please retry!")
                    return@launch
                }
              //  Log.d("tag","response body of get barbers ${result.toString()}")
                list.postValue(response.body()?.barbers)

            }catch(t:Exception){
                error.postValue(t?.message)
            }
        }
    }


    fun loadBarberServices(barberId:String){
        Log.d("tag","load barber service entry point")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //now it is hard code the barberId
                val response=remote.loadBarberService(apiToken.value!!, barberId)
                if(!response.isSuccessful){
                    // error.postValue("Error code is ${response.code()}")
                    error.postValue("Something is wrong, please retry!")
                    return@launch
                }
                val result=response.body()
                if(result==null){
                    error.postValue("No response from server, please retry!")
                    return@launch
                }
              //  Log.d("tag","result of load barber services $services")
                services.postValue(result.services)

            }catch (t: Exception){
                t.printStackTrace()
                error.postValue("error is $t")
            }
        }
    }

    fun loadTimeSlots(){
        Log.d("tag","entry point to load time slots in view model")
        viewModelScope.launch(Dispatchers.IO) {
            try {
                //now it is hard code the barberId
                val response=remote.loadTimeSlot(apiToken.value!!, selectedBarber.value?.barberId!!)

                if(!response.isSuccessful){
                    Log.d("tag","load time slot failed, code is ${response.code()} ")
                    // error.postValue("Error code is ${response.code()}")
                    error.postValue("Something is wrong, please retry!")
                    return@launch
                }
                val result=response.body()
                if(result==null){
                    error.postValue("No response from server, please retry!")
                    return@launch
                }
                 Log.d("tag","result of load time slot $result")
                timeSlots.postValue(result.slots)

            }catch (t: Exception){
                t.printStackTrace()
                error.postValue("error is $t")
            }
        }
    }


}