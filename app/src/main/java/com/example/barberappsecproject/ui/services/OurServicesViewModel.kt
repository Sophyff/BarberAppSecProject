package com.example.barberappsecproject.ui.services

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.data.ServiceCategory
import com.example.barberappsecproject.model.remote.response.LoginResponse
import com.example.barberappsecproject.model.remote.response.Services
import com.example.barberappsecproject.model.remote.response.getServicesResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class OurServicesViewModel(val remote: Repository): ViewModel() {
  //  val response=MutableLiveData<getServicesResponse>()
    val error=MutableLiveData<String>()
    val services=MutableLiveData<Services>()
    val categoryOfService=MutableLiveData<List<ServiceCategory>>()
    var disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun loadServices(){
        disposable.add(
            remote.loadService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { t ->
                        val servicesInfo=t.services
                        services.postValue(servicesInfo)
                        getServiceInfo(servicesInfo)  //to get the service category

                    },
                    {t:Throwable? ->
                        error.postValue(t?.message)
                        Log.i("tag",t?.message?:"error") })
        )
    }

    private fun getServiceInfo(services:Services){
        var categoryList= listOf<ServiceCategory>(
            ServiceCategory("Haircuts",services.Haircuts[0].servicePic,"Haircuts"),
            ServiceCategory("Shaves",services.Shaves[0].servicePic,"Shaves"),
            ServiceCategory("facial",services.facial[1].servicePic,"facial"),
            ServiceCategory("Head Massage",services.HeadMassage[0].servicePic,"HeadMassage"),
            ServiceCategory("Massage & Spa",services.MassagesSpa[0].servicePic,"MassagesSpa"),
            ServiceCategory("Official looks",services.Official_looks[0].servicePic,"Official_looks"),
            ServiceCategory("Hair colors",services.Haircolors[0].servicePic,"Haircolors"),
            ServiceCategory("Beard Styles",services.Beardstyles[0].servicePic,"Beardstyles"),
            ServiceCategory("Combo Offers",services.ComboOffers[0].servicePic,"ComboOffers")
        )
        categoryOfService.postValue(categoryList)

    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}