package com.example.barberappsecproject.ui.book.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barberappsecproject.databinding.FragmentSelectServiceBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.model.remote.data.ServiceDetail
import com.example.barberappsecproject.model.remote.response.Barber
import com.example.barberappsecproject.ui.adapter.ServiceDetailAdapter
import com.example.barberappsecproject.ui.book.BookViewModel
import com.example.barberappsecproject.ui.book.BookViewModelFactory

class SelectServiceFragment : Fragment() {
    lateinit var binding:FragmentSelectServiceBinding
    lateinit var viewModel:BookViewModel
    lateinit var selectedBarber:Barber
    lateinit var adapter:ServiceDetailAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSelectServiceBinding.inflate(layoutInflater)
        binding.rvServices.layoutManager=LinearLayoutManager(binding.root.context)

        initViewModel()
        initObserver()
        return binding.root
    }
    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= BookViewModelFactory(repository)
        viewModel= ViewModelProvider(requireActivity(),factory).get(BookViewModel::class.java)

        viewModel.selectedBarber.observe(requireActivity()){
            selectedBarber=it
            Log.d("tag", "the selected barber is $it")
        }
        if(this::selectedBarber.isInitialized){
            viewModel.loadBarberServices(selectedBarber.barberId)
        }
    }

    private fun initObserver(){
        viewModel.services.observe(requireActivity()){
            Log.d("tag", "observer in barber services")
            Log.d("tag","list of Haircuts ${it.Haircuts}")

//            val temp:ServiceDetail=it.Haircuts[1] as ServiceDetail
//            Log.d("tag","Haircut to serviceDetail $temp")

            val list=it.Haircuts.map { ServiceDetail(it.cost,it.duration,it.serviceId,it.serviceName,it.servicePic) }
            adapter=ServiceDetailAdapter(list)
            binding.rvServices.adapter=adapter

            adapter.setOnItemSelectedListener { serviceDetail, i ->
                viewModel.selectedService.postValue(serviceDetail)
            }
        }
    }

}