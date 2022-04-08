package com.example.barberappsecproject.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.barberappsecproject.databinding.ViewHolderServiceDetailBinding
import com.example.barberappsecproject.model.remote.Constants
import com.example.barberappsecproject.model.remote.data.ServiceDetail
import com.squareup.picasso.Picasso

class ServiceDetailViewHolder(val binding: ViewHolderServiceDetailBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(detail: ServiceDetail){
        binding.tvServiceName.text=detail.serviceName
        binding.tvServiceTime.text="${detail.duration} Minutes"
        binding.tvPrice.text="\$ ${detail.cost}"

        val imgEndPoint=detail.servicePic
        val url="${Constants.BASE_IMG_URL}$imgEndPoint"
        Picasso.get().load(url).into(binding.ivServiceImg)
    }
}