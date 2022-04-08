package com.example.barberappsecproject.ui.services

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.barberappsecproject.model.remote.Repository

class OurServicesViewModelFactory(val repository: Repository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return OurServicesViewModel(repository) as T
    }
}