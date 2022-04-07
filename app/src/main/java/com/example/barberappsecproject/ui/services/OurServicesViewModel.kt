package com.example.barberappsecproject.ui.services

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.Login
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

    var disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun loadServices(){
        disposable.add(
            remote.loadService()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { t ->
                        services.postValue(t.services)
                        Log.d("tag","services are: $services")
                    },
                    {t:Throwable? ->
                        error.postValue(t?.message)
                        Log.i("tag",t?.message?:"error") })
        )
    }

    override fun onCleared() {
        super.onCleared()
        disposable.dispose()
    }

}