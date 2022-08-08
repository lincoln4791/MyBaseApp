package com.example.mybaseproject2.fragments.home

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.mybaseproject2.R
import com.example.mybaseproject2.databinding.FragmentHomeBinding
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.data.network.Resource
import com.example.mybaseproject2.data.responses.User
import com.example.mybaseproject2.handleApiError
import com.example.mybaseproject2.logout
import com.example.mybaseproject2.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var userPreferences : UserPreferences

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPreferences = UserPreferences(requireContext())
        binding = FragmentHomeBinding.bind(view)
        binding.progressbar.visible(false)

        //viewModel.getUser()
        updateUserProfile()


        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    updateUI(User(it.value.key,it.value.key,"",it.value.email?:"","",it.value.userid,it.value.name,""))
                }
                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        })


        binding.buttonLogout.setOnClickListener {
            logout()
        }
    }

    private fun updateUI(user: User) {
        with(binding) {
            textViewId.text = user.id.toString()
            textViewName.text = user.name
            textViewEmail.text = user.email
            binding.progressbar.visible(false)
        }
    }

    private fun updateUserProfile(){
        userPreferences.name.asLiveData().observe(viewLifecycleOwner) {
            Log.d("tag", "token is -> $it")
            binding.textViewName.text = it
        }

        userPreferences.phone.asLiveData().observe(viewLifecycleOwner) {
            Log.d("tag", "token is -> $it")
            binding.textViewEmail.text = it
        }

    }
}