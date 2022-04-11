package com.example.barberappsecproject.ui.book.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barberappsecproject.databinding.FragmentSelectBarberBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.book.BookViewModel
import com.example.barberappsecproject.ui.adapter.SelectBarberAdapter
import com.example.barberappsecproject.ui.book.BookViewModelFactory

class SelectBarberFragment : Fragment() {
    lateinit var binding: FragmentSelectBarberBinding
    lateinit var viewModel:BookViewModel
    lateinit var adapter:SelectBarberAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentSelectBarberBinding.inflate(layoutInflater)
       initViewModel()
        binding.rvBarbers.layoutManager=LinearLayoutManager(binding.root.context)
        initViewModelObserver()

        return binding.root
    }

    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= BookViewModelFactory(repository)
        viewModel= ViewModelProvider(requireActivity(),factory).get(BookViewModel::class.java)  //??? no sure this will work.
        viewModel.loadBarber()
    }

    private fun initViewModelObserver(){
        viewModel.list.observe(requireActivity()){ list ->
           // Log.d("tag", "barber list in observer")
            adapter= SelectBarberAdapter(list)
            binding.rvBarbers.adapter=adapter

            adapter.setOnItemSelectedListener { barber, i ->
                viewModel.selectedBarber.postValue(barber)
                Log.d("tag","selected barber is $barber")
            }
        }
    }

}