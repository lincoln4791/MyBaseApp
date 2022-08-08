package com.example.mybaseproject2.ui.fragments.notifications

import androidx.lifecycle.ViewModel
import com.example.mybaseproject2.base.BaseViewModel
import com.example.mybaseproject2.data.repository.UserRepository
import javax.inject.Inject

class NotificationsViewModel @Inject constructor(userRepository: UserRepository) : BaseViewModel(userRepository) {

}