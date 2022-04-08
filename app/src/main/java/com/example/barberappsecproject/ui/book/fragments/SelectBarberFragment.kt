package com.example.barberappsecproject.ui.book.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.barberappsecproject.databinding.FragmentSelectBarberBinding
import com.example.barberappsecproject.ui.book.BookViewModel
import com.example.barberappsecproject.ui.adapter.SelectBarberAdapter

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
        viewModel= ViewModelProvider(requireActivity()).get(BookViewModel::class.java)  //??? no sure this will work.
        viewModel.loadBarber()

        binding.rvBarbers.layoutManager=LinearLayoutManager(binding.root.context)
        initViewModel()
        return binding.root
    }

    private fun initViewModel(){
        viewModel.list.observe(this){ list ->
            adapter= SelectBarberAdapter(list)
            binding.rvBarbers.adapter=adapter
        }
    }
}