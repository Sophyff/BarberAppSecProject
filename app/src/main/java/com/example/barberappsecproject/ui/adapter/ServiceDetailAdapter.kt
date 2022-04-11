package com.example.barberappsecproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barberappsecproject.databinding.ViewHolderBarberBinding
import com.example.barberappsecproject.databinding.ViewHolderServiceDetailBinding
import com.example.barberappsecproject.model.remote.data.ServiceDetail
import com.example.barberappsecproject.model.remote.response.Barber
import com.example.barberappsecproject.ui.viewholder.BarberViewHolder
import com.example.barberappsecproject.ui.viewholder.ServiceDetailViewHolder

class ServiceDetailAdapter(val list:List<Any>):RecyclerView.Adapter<ServiceDetailViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceDetailViewHolder {
        val binding=ViewHolderServiceDetailBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ServiceDetailViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ServiceDetailViewHolder, position: Int) {
        val serviceDetail=list[position] as ServiceDetail
        holder.bind(serviceDetail)

        holder.itemView.setOnClickListener {
            if(this::itemSelectedListener.isInitialized){
                itemSelectedListener(serviceDetail,position)
            }
        }
    }

    override fun getItemCount(): Int {
       return list.size
    }

    private lateinit var itemSelectedListener: (ServiceDetail, Int) -> Unit

    fun setOnItemSelectedListener(listener: (ServiceDetail, Int) -> Unit) {
        itemSelectedListener = listener
    }
}