package com.example.mybaseproject2.data.network

import com.example.mybaseproject2.body.LoginBodyModel
import com.example.mybaseproject2.data.responses.LoginResponse
import retrofit2.http.*

interface AuthApi : BaseApi {

    @Headers("P-Auth-Token:P4t13nt4idu53r")
    @POST("api/v1/login")
    suspend fun login(
        @Body loginBodyModel: LoginBodyModel
    ): LoginResponse
}