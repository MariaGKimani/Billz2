package dev.mariag.billz2.ui

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import dev.mariag.billz2.R
import dev.mariag.billz2.databinding.ActivityMainBinding
import dev.mariag.billz2.model.LoginResponse
import dev.mariag.billz2.model.RegisterRequest
import dev.mariag.billz2.viewmodel.UserViewModel

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    val userViewModel: UserViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        binding.btSignUp.setOnClickListener {
//            signIn()
        }

        binding.btLogin.setOnClickListener { startActivity(Intent(this, Login::class.java)) }

        userViewModel.regLiveData.observe(this, Observer { regResponse ->
            Toast.makeText(this, regResponse.message, Toast.LENGTH_LONG).show()
            binding.pbRegister.visibility = View.GONE

            startActivity(Intent(this, Login::class.java))
        })

        userViewModel.errLiveData.observe(this, Observer { err ->
            Toast.makeText(this, err, Toast.LENGTH_LONG).show()
            binding.pbRegister.visibility = View.GONE
            startActivity(Intent(this,Login::class.java))
        })
    }
    fun persistLogin(loginResponse: LoginResponse){
        val sharedPrefs = getSharedPreferences("BILLZ_PREFS", Context.MODE_PRIVATE)
        val editor = sharedPrefs.edit()
        editor.putString("USER_ID",loginResponse.userId)
        editor.putString("ACCESS_TOKEN",loginResponse.accessToken)
        editor.apply()
    }
}

//    fun signIn() {
//        val firstName = binding.etFirstName.text.toString()
//        val lastName = binding.etLastName.text.toString()
//        val phone = binding.etPhoneNumber.text.toString()
//        val email = binding.etEmailAddress.text.toString()
//        val password = binding.etpassword.text.toString()
//        val confirmPassword = binding.etConfirmPassword.text.toString()
//        var error = false
//
//
//        if (firstName.isBlank()) {
//            binding.tilFirstName.error = "Name cannot be empty"
//            error = true
//        }
//        else {
//            binding.tilFirstName.error = null
//        }
//
//        if (lastName.isBlank()) {
//            binding.tilLastName.error = "Name cannot be empty"
//            error = true
//        }
//        else {
//            binding.tilLastName.error = null
//        }
//
//        if (phone.isBlank()) {
//            binding.tilPhoneNumber.error = "Phone number cannot be empty"
//            error = true
//        }
//        else {
//            binding.tilPhoneNumber.error = null
//        }
//
//        if (email.isBlank()) {
//            binding.tilEmailAddress.error = "Email Address cannot be empty"
//            error = true
//        }
//        else {
//            binding.tilEmailAddress.error = null
//        }
//
//        if (password.isBlank()) {
//            binding.tilpassword.error = "Password cannot be empty"
//            error = true
//        }
//        else {
//            binding.tilpassword.error = null
//        }
//
//        if (password != confirmPassword) {
//            binding.tilConfirmPassword.error = "Passwords do not match"
//            error = true
//        }
//        else {
//            binding.tilConfirmPassword.error = null
//        }
//
//        if (!error) {
//            val registerRequest = RegisterRequest(
//                firstName = firstName,
//                lastName = lastName,
//                phoneNumber = phone,
//                email = email,
//                password = password
//            )
//            binding.pbRegister.visibility = View.VISIBLE
//            userViewModel.registerUser(registerRequest)
//
//        }
//    }
//}