package com.example.barberappsecproject.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.barberappsecproject.ui.book.fragments.SelectBarberFragment
import com.example.barberappsecproject.ui.book.fragments.SelectServiceFragment
import com.example.barberappsecproject.ui.book.fragments.SelectTimeFragment
import com.example.barberappsecproject.ui.book.fragments.SummaryFragment

class BookAppointmentViewPagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    var size=4
    override fun getItemCount(): Int {
        return size
    }

    override fun createFragment(position: Int): Fragment {
        if(position ==0){
            return SelectBarberFragment()
        }else if(position==1){
            return SelectServiceFragment()
        }else if(position ==2){
            return SelectTimeFragment()
        }else{
            return SummaryFragment()
        }
    }
}