package dev.mariag.billz2.api

import dev.mariag.billz2.model.LoginRequest
import dev.mariag.billz2.model.LoginResponse
import dev.mariag.billz2.model.RegisterRequest
import dev.mariag.billz2.model.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {
        @POST("/users/register")
        suspend fun registerUser(@Body registerRequest: RegisterRequest): Response<RegisterResponse>

        @POST("/users/login")
        suspend fun loginUser(@Body loginRequest: LoginRequest):Response<LoginResponse>
}