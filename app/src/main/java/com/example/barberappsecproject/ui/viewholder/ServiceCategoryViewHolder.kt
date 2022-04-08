package com.example.barberappsecproject.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.barberappsecproject.databinding.ViewHolderBarberBinding
import com.example.barberappsecproject.databinding.ViewHolderServiceCategoryBinding
import com.example.barberappsecproject.model.remote.Constants
import com.example.barberappsecproject.model.remote.data.ServiceCategory
import com.example.barberappsecproject.model.remote.response.Barber
import com.squareup.picasso.Picasso

class ServiceCategoryViewHolder(val binding: ViewHolderServiceCategoryBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(category: ServiceCategory){
        binding.tvServiceCategoryName.text=category.name

        val imgEndPoint=category.img
        val url="${Constants.BASE_IMG_URL}$imgEndPoint"
        Picasso.get().load(url).into(binding.ivServiceImg)
    }
}