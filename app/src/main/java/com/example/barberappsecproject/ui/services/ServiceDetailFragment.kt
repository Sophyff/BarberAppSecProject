package com.example.barberappsecproject.ui.services

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barberappsecproject.databinding.ServiceDetailFragmentBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.ServiceDetail
import com.example.barberappsecproject.ui.adapter.ServiceDetailAdapter

class ServiceDetailFragment : Fragment() {
    lateinit var binding: ServiceDetailFragmentBinding
    private lateinit var viewModel: OurServicesViewModel
    lateinit var adapter:ServiceDetailAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= ServiceDetailFragmentBinding.inflate(layoutInflater)
        binding.rvServiceDetail.layoutManager=LinearLayoutManager(binding.root.context)
        initViewModel()
        initObserver()

        return binding.root
    }

    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= OurServicesViewModelFactory(repository)
        viewModel= ViewModelProvider(requireActivity(),factory).get(OurServicesViewModel::class.java)
    }

    private fun initObserver() {
        viewModel.services.observe(requireActivity()) {

            val list = it.Haircuts.map {  ServiceDetail(it.cost,it.duration,it.serviceId,it.serviceName,it.servicePic) }
            adapter = ServiceDetailAdapter(list)
            binding.rvServiceDetail.adapter = adapter

            adapter.setOnItemSelectedListener { serviceCategory, i ->
                //todo send services name, and list of this category to next activity or fragment
            }
        }
    }

}