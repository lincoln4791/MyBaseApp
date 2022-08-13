package com.example.mybaseproject2.ui.fragments.notifications

import androidx.fragment.app.viewModels
import com.example.mybaseproject2.base.BaseFragment
import com.example.mybaseproject2.databinding.FragmentNotificationsBinding

class Notifications : BaseFragment<FragmentNotificationsBinding>(FragmentNotificationsBinding::inflate) {
    private val viewModel by viewModels<NotificationsViewModel>()

}