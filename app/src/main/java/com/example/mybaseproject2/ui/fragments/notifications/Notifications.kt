package com.example.mybaseproject2.ui.fragments.notifications

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mybaseproject2.R
import com.example.mybaseproject2.base.BaseFragment
import com.example.mybaseproject2.databinding.FragmentGalleryBinding
import com.example.mybaseproject2.databinding.FragmentNotificationsBinding

class Notifications : BaseFragment<FragmentNotificationsBinding>(FragmentNotificationsBinding::inflate) {
    private val viewModel by viewModels<NotificationsViewModel>()

}