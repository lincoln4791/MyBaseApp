package com.example.mybaseproject2.data.network

import com.example.mybaseproject2.data.responses.LoginResponse
import retrofit2.http.GET

interface UserApi : BaseApi {
    @GET("user")
    suspend fun getUser(): LoginResponse
}