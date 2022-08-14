package com.example.mybaseproject2.ui.fragments.home

import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.example.mybaseproject2.R
import com.example.mybaseproject2.data.UserPreferences
import com.example.mybaseproject2.data.network.Resource
import com.example.mybaseproject2.data.responses.User
import com.example.mybaseproject2.databinding.FragmentHomeBinding
import com.example.mybaseproject2.handleApiError
import com.example.mybaseproject2.logout
import com.example.mybaseproject2.visible
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home) {

    private lateinit var binding: FragmentHomeBinding
    private val viewModel by viewModels<HomeViewModel>()
    private lateinit var userPreferences : UserPreferences

    override fun onCreate(@Nullable savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // This callback will only be called when MyFragment is at least Started.
        val callback: OnBackPressedCallback =
            object : OnBackPressedCallback(true /* enabled by default */) {
                override fun handleOnBackPressed() {
                 /*   val builder = AlertDialog.Builder(requireContext())
                    builder.setTitle("Choose an occupation")

                    //val animals = arrayOf("horse", "cow", "camel", "sheep", "goat","horse", "cow", "camel", "sheep", "goat","horse", "cow", "camel", "sheep", "goat","horse", "cow", "camel", "sheep", "goat","horse", "cow", "camel", "sheep", "goat")
                    var checkedItem = 1 // cow
                    builder.setTitle("Exit")
                    builder.setTitle("Are You Sure Want To Exit?")
                    builder.setPositiveButton("Yes"
                    ) { _, _ ->
                        if(binding.d){

                        }
                        requireActivity().finish()
                    }
                    builder.setNegativeButton("No"
                    ) { dialog, _ -> dialog?.dismiss() }

                    val dialog : AlertDialog = builder.create()
                    dialog.show()*/
                }
            }
        requireActivity().onBackPressedDispatcher.addCallback(this, callback)

        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        userPreferences = UserPreferences(requireContext())
        binding = FragmentHomeBinding.bind(view)
        binding.progressbar.visible(false)

        //viewModel.getUser()
        updateUserProfile()

        viewModel.user.observe(viewLifecycleOwner) {
            when (it) {
                is Resource.Success -> {
                    binding.progressbar.visible(false)
                    updateUI(User("",
                        "",
                        "",
                        it.value[0].email ?: "",
                        "",
                        "",
                        "",
                        it.value[0].name,
                        ""))
                }
                is Resource.Loading -> {
                    binding.progressbar.visible(true)
                }
                is Resource.Failure -> {
                    handleApiError(it)
                }
            }
        }

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