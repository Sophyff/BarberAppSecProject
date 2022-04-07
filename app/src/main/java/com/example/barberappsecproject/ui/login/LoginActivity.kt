package com.example.barberappsecproject.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import com.example.barberappsecproject.databinding.ActivityLoginBinding
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.dashboard.DashboardActivity
import com.example.barberappsecproject.ui.register.RegisterActivity

class LoginActivity : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViewModel()
        initObserver()

        binding.tvSkip.setOnClickListener {
            startActivity(Intent(baseContext, DashboardActivity::class.java))
            finish()
        }

        binding.tvForgetPassword.setOnClickListener {
            forgetPassword()
        }

        binding.tvNoAccount.setOnClickListener {
            startActivity(Intent(baseContext, RegisterActivity::class.java))
            finish()
        }

    }

    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory=LoginViewModelFactory(repository)
        viewModel= ViewModelProvider(this, factory)[LoginViewModel::class.java]
        binding.viewModel=viewModel

        binding.btnSignIn.setOnClickListener {
            viewModel.login()
        }
      //  viewModel.mobileNo.postValue(binding.etMobileNo.text.toString())
    }

    private fun initObserver(){
        viewModel.mobileNo.observe(this){
            Log.d("tag",it)
        }

        viewModel.loginResponse.observe(this){
            val pref = getSharedPreferences("User", MODE_PRIVATE)
            val editor = pref.edit()

            editor.putString("name", it.fullName)
            editor.putString("mobile_no", it.mobileNo)
            editor.putString("user_id",it.userId)
            editor.commit()

            startActivity(Intent(baseContext, DashboardActivity::class.java))
            finish()
        }


    }

    private fun forgetPassword(){
        //todo
    }


}