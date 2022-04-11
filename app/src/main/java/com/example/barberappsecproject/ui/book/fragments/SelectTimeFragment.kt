package com.example.barberappsecproject.ui.book.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.barberappsecproject.R
import com.example.barberappsecproject.databinding.FragmentSelectTimeBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.book.BookViewModel
import com.example.barberappsecproject.ui.book.BookViewModelFactory

class SelectTimeFragment : Fragment() {
    lateinit var binding: FragmentSelectTimeBinding
    lateinit var viewModel:BookViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initViewModel()
        initObserver()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_select_time, container, false)
    }

    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= BookViewModelFactory(repository)
        viewModel= ViewModelProvider(requireActivity(),factory).get(BookViewModel::class.java)
        viewModel.loadTimeSlots()
    }

    private fun initObserver(){
        viewModel.timeSlots.observe(requireActivity()){
            Log.d("tag","first day time slot is ${it[0]}")
        }
    }


}