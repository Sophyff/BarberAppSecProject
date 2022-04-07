package com.example.barberappsecproject.ui.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.barberappsecproject.databinding.ActivityOurServicesBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.login.LoginViewModel
import com.example.barberappsecproject.ui.login.LoginViewModelFactory

class OurServicesActivity : AppCompatActivity() {
    lateinit var binding:ActivityOurServicesBinding
    lateinit var viewModel:OurServicesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOurServicesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

    }
    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= OurServicesViewModelFactory(repository)
        viewModel= ViewModelProvider(this, factory)[OurServicesViewModel::class.java]
        viewModel.loadServices()
    }
}