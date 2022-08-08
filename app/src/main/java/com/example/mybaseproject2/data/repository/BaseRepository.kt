package com.example.mybaseproject2.data.repository

import com.example.mybaseproject2.data.network.BaseApi
import com.example.mybaseproject2.data.network.SafeApiCall

abstract class BaseRepository(private val api: BaseApi) : SafeApiCall {

    suspend fun logout() = safeApiCall {
        api.logout()
    }
}