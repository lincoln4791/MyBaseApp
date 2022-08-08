package com.example.mybaseproject2.ui.fragments.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import com.example.mybaseproject2.data.network.Resource
import com.example.mybaseproject2.data.repository.UserRepository
import com.example.mybaseproject2.data.responses.LoginResponse
import com.example.mybaseproject2.base.BaseViewModel
import com.example.mybaseproject2.data.responses.User
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: UserRepository
) : BaseViewModel(repository) {

    private val _user: MutableLiveData<Resource<MutableList<User>>> = MutableLiveData()
    val user: LiveData<Resource<MutableList<User>>>
        get() = _user

    fun getUser() = viewModelScope.launch {
        _user.value = Resource.Loading
        _user.value = repository.getUser()
    }



}