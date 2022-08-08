package com.example.mybaseproject2.ui.fragments.profile

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.mybaseproject2.R
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.data.network.Resource
import com.example.mybaseproject2.data.responses.User
import com.example.mybaseproject2.databinding.FragmentHomeBinding
import com.example.mybaseproject2.databinding.FragmentProfileBinding
import com.example.mybaseproject2.handleApiError
import com.example.mybaseproject2.logout
import com.example.mybaseproject2.ui.fragments.gallery.GalleryViewModel
import com.example.mybaseproject2.ui.fragments.home.HomeViewModel
import com.example.mybaseproject2.visible
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class Profile : Fragment() {
    private lateinit var binding: FragmentProfileBinding
    private val viewModel by viewModels<ProfileViewModel>()
    private lateinit var userPreferences : UserPreferences


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPreferences = UserPreferences(requireContext())
        binding.progressbar.visible(false)

        viewModel.getUser()
        //updateUserProfile()

        Toast.makeText(requireContext(),"profile Fragment",Toast.LENGTH_SHORT).show()


        viewModel.user.observe(viewLifecycleOwner, Observer {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    updateUI(User("","","",it.value[0].email?:"","","","",it.value[0].name,""))
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