package com.example.mybaseproject2.ui.fragments.slideshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mybaseproject2.base.BaseViewModel
import com.example.mybaseproject2.data.repository.UserRepository
import javax.inject.Inject

class SlideshowViewModel @Inject constructor(userRepository: UserRepository) : BaseViewModel(userRepository) {

}