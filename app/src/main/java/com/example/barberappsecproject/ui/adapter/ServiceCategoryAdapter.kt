package com.example.barberappsecproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barberappsecproject.databinding.ViewHolderBarberBinding
import com.example.barberappsecproject.databinding.ViewHolderServiceCategoryBinding
import com.example.barberappsecproject.model.remote.data.ServiceCategory
import com.example.barberappsecproject.model.remote.response.Barber
import com.example.barberappsecproject.ui.viewholder.BarberViewHolder
import com.example.barberappsecproject.ui.viewholder.ServiceCategoryViewHolder

class ServiceCategoryAdapter(val list:List<ServiceCategory>):RecyclerView.Adapter<ServiceCategoryViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceCategoryViewHolder {
        val binding=ViewHolderServiceCategoryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ServiceCategoryViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceCategoryViewHolder, position: Int) {
        holder.bind(list[position])

        holder.itemView.setOnClickListener {
            if(this::itemSelectedListener.isInitialized){
                itemSelectedListener(list[position],position)
            }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    private lateinit var itemSelectedListener: (ServiceCategory, Int) -> Unit

    fun setOnItemSelectedListener(listener: (ServiceCategory, Int) -> Unit) {
        itemSelectedListener = listener
    }
}