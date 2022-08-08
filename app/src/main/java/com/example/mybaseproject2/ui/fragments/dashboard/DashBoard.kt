package com.example.mybaseproject2.ui.fragments.dashboard

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.mybaseproject2.R
import com.example.mybaseproject2.base.BaseFragment
import com.example.mybaseproject2.base.BaseViewModel
import com.example.mybaseproject2.databinding.FragmentDashBoardBinding

class DashBoard : BaseFragment<FragmentDashBoardBinding>(FragmentDashBoardBinding::inflate) {
    private val viewModel by viewModels<DashBoardViewModel>()
}