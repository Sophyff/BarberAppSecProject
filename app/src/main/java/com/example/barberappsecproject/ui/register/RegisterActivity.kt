package com.example.barberappsecproject.ui.register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.barberappsecproject.databinding.ActivityRegisterBinding
import com.example.barberappsecproject.helper.isValidMobileNumber
import com.example.barberappsecproject.helper.isValidPassword
import com.example.barberappsecproject.model.remote.ApiService
import com.example.barberappsecproject.model.remote.Repository
import com.example.barberappsecproject.ui.login.LoginActivity
import com.example.barberappsecproject.ui.login.LoginViewModel
import com.example.barberappsecproject.ui.login.LoginViewModelFactory

class RegisterActivity : AppCompatActivity() {
    lateinit var binding: ActivityRegisterBinding
    lateinit var viewModel:RegisterViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvAccount.setOnClickListener {
            startActivity(Intent(baseContext, LoginActivity::class.java))
            finish()
        }

        initViewModel()
        initEvents()
        initObserver()
    }

    private fun initViewModel(){
        val repository= Repository(ApiService.getInstance())
        val factory= RegisterViewModelFactory(repository)
        viewModel= ViewModelProvider(this, factory)[RegisterViewModel::class.java]

    }

    private fun initEvents(){
        binding.btnSignUp.setOnClickListener {
            val mobileNo= binding.etMobileNo.text.toString()
            val password=binding.etPassword.text.toString()
            val cpassword=binding.etConfirmPassword.text.toString()

            if(isValidForm()) {
                viewModel.mobileNo.postValue(mobileNo)  //update the viewmodel
                viewModel.password.postValue(password)

                viewModel.signup() //call viewmodel signup fun.
            }
        }
    }

    private fun initObserver(){
        viewModel.status.observe(this){
            if(it==0){
                Toast.makeText(baseContext,"register successfully!!", Toast.LENGTH_LONG).show()
            }
        }
        viewModel.error.observe(this){
            Toast.makeText(baseContext,"register failed!!", Toast.LENGTH_LONG).show()
        }
    }



    private fun isValidForm(): Boolean {
        var isValid = true

        if(binding.etMobileNo.text.toString().isEmpty()) {
            binding.etMobileNo.error = "Please enter mobile number"
            isValid = false
        } else if(!isValidMobileNumber(binding.etMobileNo.text.toString())) {
            binding.etMobileNo.error = "Please enter 10 digit mobile number"
            isValid = false
        }

        val password = binding.etPassword.text.toString()
        val confirmPassword = binding.etConfirmPassword.text.toString()
        if(!isValidPassword(password)) {
            binding.etPassword.error = "Wrong password. It should be alphanumeric with min length 6."
            isValid = false
        } else if(!password.equals(confirmPassword)) {
            binding.etConfirmPassword.error = "Password and confirm password should be same."
            isValid = false
        }
        return isValid
    }
}