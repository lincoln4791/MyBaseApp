package com.example.mybaseproject2.ui.fragments.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.mybaseproject2.base.BaseFragment
import com.example.mybaseproject2.databinding.FragmentSlideshowBinding

class SlideshowFragment : BaseFragment<FragmentSlideshowBinding>(FragmentSlideshowBinding::inflate) {
    private val viewModel by viewModels<SlideshowViewModel>()



}