package com.example.barberappsecproject.ui.login

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.response.LoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class LoginViewModel(val remote: Repository): ViewModel() {
    val loginResponse=MutableLiveData<LoginResponse>()
    val error=MutableLiveData<String>()
    val mobileNo=MutableLiveData<String>()
    val password= MutableLiveData<String>()

    var disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun login(){
        val userName = mobileNo.value?:""
        val pass=password.value?:""
        Log.d("tag","name is $userName, password is $pass")

        val login= Login(userName,pass)
        disposable.add(
            remote.login(login)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { t ->
                        loginResponse.postValue(t)},
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