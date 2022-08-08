package com.example.mybaseproject2.data.repository

import com.example.mybaseproject2.body.LoginBodyModel
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.data.network.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val api: AuthApi,
    private val preferences: UserPreferences
) : BaseRepository(api) {

    suspend fun login(
        phone: String,
        password: String
    ) = safeApiCall {
        api.login(LoginBodyModel(phone,password))
    }

    suspend fun saveUserDetails(accessToken: String, refreshToken: String,name: String,phone:String){
        preferences.saveUserDetails(accessToken,refreshToken,name,phone)
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        preferences.saveAccessTokens(accessToken, refreshToken)
    }

}