package com.example.mybaseproject2.ui.activities

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.mybaseproject2.data.network.Resource
import com.example.mybaseproject2.data.repository.AuthRepository
import com.example.mybaseproject2.data.responses.LoginResponse
import com.example.mybaseproject2.base.BaseViewModel
import com.example.mybaseproject2.data.repository.UserRepository
import com.example.mybaseproject2.data.responses.User
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository,
) : BaseViewModel(authRepository) {
    private val _loginResponse: MutableLiveData<Resource<LoginResponse>> = MutableLiveData()
    val loginResponse: LiveData<Resource<LoginResponse>>
        get() = _loginResponse

    fun login(
        email: String,
        password: String
    ) = viewModelScope.launch {
        _loginResponse.value = Resource.Loading
        _loginResponse.value = authRepository.login(email, password)
    }

    suspend fun saveUserDetails(accessToken: String, refreshToken: String,name: String,phone:String){
        authRepository.saveUserDetails(accessToken,refreshToken,name,phone)
    }

    suspend fun saveUserDetailsSQL(user: User){
        userRepository.saveUserDetailsInSQL(user)
    }

    suspend fun saveAccessTokens(accessToken: String, refreshToken: String) {
        authRepository.saveAccessTokens(accessToken, refreshToken)
    }


    private val _user: MutableLiveData<Resource<MutableList<User>>> = MutableLiveData()
    val user: LiveData<Resource<MutableList<User>>>
        get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = Resource.Loading
        _user.value = userRepository.getUser()
    }
}