package com.example.mybaseproject2.ui.fragments.dashboard

import androidx.lifecycle.ViewModel
import com.example.mybaseproject2.base.BaseViewModel
import com.example.mybaseproject2.data.repository.AuthRepository
import com.example.mybaseproject2.data.repository.UserRepository
import javax.inject.Inject

class DashBoardViewModel @Inject constructor(userRepository : UserRepository) : BaseViewModel(userRepository) {
    // TODO: Implement the ViewModel
}