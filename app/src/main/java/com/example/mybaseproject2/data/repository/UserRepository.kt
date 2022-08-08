package com.example.mybaseproject2.data.repository

import com.example.mybaseproject2.data.network.UserApi
import com.example.mybaseproject2.data.responses.User
import com.example.mybaseproject2.data.roomdb.dao.UserDao
import javax.inject.Inject

class UserRepository @Inject constructor(
    private val api: UserApi,
    private val dao : UserDao
) : BaseRepository(api) {
    suspend fun getUser() = safeApiCall { dao.getAllUser() }

    suspend fun saveUserDetailsInSQL(user: User) = safeApiCall { dao.insertUser(user) }

    suspend fun removeAllUsersDataFromSQL() = safeApiCall {
        dao.deleteAllUser()
    }



}