package com.example.barberappsecproject.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.barberappsecproject.databinding.ViewHolderBarberBinding
import com.example.barberappsecproject.model.remote.response.Barber
import com.example.barberappsecproject.ui.viewholder.BarberViewHolder

class SelectBarberAdapter(val list:List<Barber>):RecyclerView.Adapter<BarberViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BarberViewHolder {
        val binding=ViewHolderBarberBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return BarberViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BarberViewHolder, position: Int) {
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

    private lateinit var itemSelectedListener: (Barber, Int) -> Unit

    fun setOnItemSelectedListener(listener: (Barber, Int) -> Unit) {
        itemSelectedListener = listener
    }
}