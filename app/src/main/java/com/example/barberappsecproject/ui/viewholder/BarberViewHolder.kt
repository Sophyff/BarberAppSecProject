package com.example.barberappsecproject.ui.viewholder

import androidx.recyclerview.widget.RecyclerView
import com.example.barberappsecproject.databinding.ViewHolderBarberBinding
import com.example.barberappsecproject.model.remote.Constants
import com.example.barberappsecproject.model.remote.response.Barber
import com.squareup.picasso.Picasso

class BarberViewHolder(val binding: ViewHolderBarberBinding) :RecyclerView.ViewHolder(binding.root){
    fun bind(barber: Barber){
        binding.tvBarberName.text=barber.barberName
        binding.rating.rating=barber.userRating.toFloat()

        val imgEndPoint=barber.profilePic
        val url="${Constants.BASE_IMG_URL}$imgEndPoint"
        Picasso.get().load(url).into(binding.ivBarberImg)
    }
}