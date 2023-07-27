package dev.mariag.billz2.repository

import dev.mariag.billz2.api.ApiClient
import dev.mariag.billz2.api.ApiInterface
import dev.mariag.billz2.model.LoginRequest
import dev.mariag.billz2.model.LoginResponse
import dev.mariag.billz2.model.RegisterRequest
import dev.mariag.billz2.model.RegisterResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

class UserRepository {
    val apiClient = ApiClient.buildApiClient(ApiInterface::class.java)

    suspend fun register(registerRequest: RegisterRequest):
            Response<RegisterResponse> {
        return withContext(Dispatchers.IO){
            apiClient.registerUser((registerRequest))
        }

    }
    suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> {
        return withContext(Dispatchers.IO) {
            apiClient.loginUser(loginRequest)
        }
    }






}