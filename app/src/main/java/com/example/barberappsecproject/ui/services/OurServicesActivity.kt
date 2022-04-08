package com.example.barberappsecproject.ui.services

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.example.barberappsecproject.R
import com.example.barberappsecproject.databinding.ActivityOurServicesBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.adapter.ServiceCategoryAdapter
import com.example.barberappsecproject.ui.login.LoginViewModel
import com.example.barberappsecproject.ui.login.LoginViewModelFactory

class OurServicesActivity : AppCompatActivity() {
    lateinit var binding:ActivityOurServicesBinding
    lateinit var viewModel:OurServicesViewModel
    lateinit var adapter:ServiceCategoryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityOurServicesBinding.inflate(layoutInflater)
        binding.rvServices.layoutManager=GridLayoutManager(baseContext,2)
        setContentView(binding.root)
        initViewModel()
        initObserver()
    }
    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= OurServicesViewModelFactory(repository)
        viewModel= ViewModelProvider(this, factory)[OurServicesViewModel::class.java]
        viewModel.loadServices()
    }

    private fun initObserver(){
        viewModel.categoryOfService.observe(this){
            adapter= ServiceCategoryAdapter(it)
            binding.rvServices.adapter=adapter

            adapter.setOnItemSelectedListener { serviceCategory, i ->
                //todo should send the service category's id into the viewmodel.
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ServiceDetailFragment()).commit()
            }
        }
    }
}