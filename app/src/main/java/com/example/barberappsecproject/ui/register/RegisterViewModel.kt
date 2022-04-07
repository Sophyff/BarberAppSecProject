package com.example.barberappsecproject.ui.register

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.data.Signup
import com.example.barberappsecproject.model.remote.response.LoginResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class RegisterViewModel(val remote: Repository): ViewModel() {
    val status=MutableLiveData<Int>()
    val error=MutableLiveData<String>()
    val mobileNo=MutableLiveData<String>()
    val password= MutableLiveData<String>()

    var disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun signup(){
        val mobile = mobileNo.value?:""
        val pass=password.value?:""
        Log.d("tag","name is $mobile, password is $pass")

        val signup= Signup(mobile,pass)
        disposable.add(
            remote.signup(signup)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { t ->
                        status.postValue(t.status)},
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