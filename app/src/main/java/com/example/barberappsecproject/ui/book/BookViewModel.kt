package com.example.barberappsecproject.ui.book

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.Login
import com.example.barberappsecproject.model.remote.response.Barber
import com.example.barberappsecproject.model.remote.response.LoginResponse
import com.example.barberappsecproject.model.remote.response.getBarberResponse
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class BookViewModel(val remote: Repository): ViewModel() {
    val error=MutableLiveData<String>()
    val list=MutableLiveData<List<Barber>>()

    var disposable = CompositeDisposable()

    @SuppressLint("CheckResult")
    fun loadBarber(){
        disposable.add(
            remote.loadBarbers( )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(
                    { t ->
                        if(t.status==0){
                            list.postValue(t.barbers)
                            Log.d("tag","${t.barbers}")
                        }else{
                            error.postValue("Something is wrong, error status: ${t.status}")
                        }

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