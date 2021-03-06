package com.example.barberappsecproject.ui.book

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.barberappsecproject.databinding.ActivityBookAppointmentBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.adapter.BookAppointmentViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class BookAppointmentActivity : AppCompatActivity() {
    lateinit var binding: ActivityBookAppointmentBinding
    lateinit var viewModel: BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityBookAppointmentBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.vpBookAppointment.adapter=BookAppointmentViewPagerAdapter(this)

        TabLayoutMediator(binding.tabHeader,binding.vpBookAppointment){
                tab, position -> if(position==0){
            tab.text="Choose Barber"
        }
        else if(position==1){
            tab.text="Service"
        }else if(position==2){
            tab.text="Pick Time"
        }else{
            tab.text="Summary"
        }
        }.attach()

        initViewModel()
        initEvent()
    }

    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= BookViewModelFactory(repository)
        viewModel= ViewModelProvider(this, factory)[BookViewModel::class.java]
    }

    private fun initEvent(){
        val pref=getSharedPreferences("User", MODE_PRIVATE)
        val userId=pref.getString("user_id","")
        val apiToken=pref.getString("apiToken","")
        Log.d("tag","the user inof is userId:$userId, apiToken is $apiToken" )
        if(userId!=""){
            viewModel.userId.postValue(userId)
            viewModel.apiToken.postValue(apiToken)
        }
    }
}