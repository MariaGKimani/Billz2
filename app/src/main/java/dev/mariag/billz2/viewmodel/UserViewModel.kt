package dev.mariag.billz2.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.mariag.billz2.model.LoginRequest
import dev.mariag.billz2.model.LoginResponse
import dev.mariag.billz2.model.RegisterRequest
import dev.mariag.billz2.model.RegisterResponse
import dev.mariag.billz2.repository.UserRepository
import kotlinx.coroutines.launch

class UserViewModel:ViewModel() {

    val userRepo = UserRepository()
    val regLiveData = MutableLiveData<RegisterResponse>()
    val loginLiveData = MutableLiveData<LoginResponse>()
    val errLiveData = MutableLiveData<String>()

    fun registerUser(registerRequest: RegisterRequest){
        viewModelScope.launch {
            val response = userRepo.register(registerRequest)
            if (response.isSuccessful){
                regLiveData.postValue(response.body())
            }else{
                errLiveData.postValue(response.errorBody()?.string())
            }

        }

    }
    fun loginUser(loginRequest: LoginRequest) {
        viewModelScope.launch {
            val response = userRepo.login(loginRequest)
            if (response.isSuccessful) {
                loginLiveData.postValue(response.body())
            } else {
                errLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
    }

