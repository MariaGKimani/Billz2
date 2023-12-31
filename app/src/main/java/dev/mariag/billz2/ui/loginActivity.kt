package dev.mariag.billz2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.mariag.billz2.R
import dev.mariag.billz2.databinding.ActivityLoginBinding
import dev.mariag.billz2.model.LoginRequest
import dev.mariag.billz2.viewmodel.UserViewModel

class Login : AppCompatActivity() {
    lateinit var binding: ActivityLoginBinding
    private val userViewModel: UserViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btLogInn.setOnClickListener {
            logInUser()
        }
     binding.btLogInn.setOnClickListener {
         startActivity(Intent(this,HomeActivity::class.java))
     }

    }

    fun logInUser() {
        val email = binding.etemail.text.toString()
        val password = binding.etpassword.text.toString()
        var error = false

        if (email.isBlank()) {
            binding.tilemail.error = "Name cannot be empty"
            error = true
        } else {
            binding.tilemail.error = null
        }

        if (password.isBlank()) {
            binding.tilpassword.error = "Password cannot be empty"
            error = true
        }
        else {
            binding.tilpassword.error = null
        }

        if (!error) {

            val logInUser = LoginRequest(
                email =email,
                password = password
            )
            userViewModel.loginUser(logInUser)
        }
    }
}




