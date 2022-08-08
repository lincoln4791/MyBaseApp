package com.example.mybaseproject2.ui.fragments.auth

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.lifecycleScope
import com.example.mybaseproject2.databinding.FragmentLoginFragentBinding
import com.example.mybaseproject2.ui.activities.AuthViewModel
import com.example.mybaseproject2.ui.activities.HomeActivity
import com.example.mybaseproject2.base.BaseFragment
import com.example.mybaseproject2.enable
import com.example.mybaseproject2.handleApiError
import com.example.mybaseproject2.startNewActivity
import com.example.mybaseproject2.visible
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import com.example.mybaseproject2.data.network.Resource
import com.example.mybaseproject2.data.responses.User

@AndroidEntryPoint
class LoginFragment: BaseFragment<FragmentLoginFragentBinding>(
    FragmentLoginFragentBinding::inflate
) {

    private val viewModel by viewModels<AuthViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressbar.visible(false)
        binding.buttonLogin.enable(false)

        viewModel.loginResponse.observe(viewLifecycleOwner, Observer {
            binding.progressbar.visible(it is Resource.Loading)
            when (it) {
                is Resource.Success -> {
                    if(it.value.success=="true"){
                        lifecycleScope.launch {
                            /*viewModel.saveAccessTokens(
                                it.value.key,
                                it.value.key
                            )*/
                            viewModel.saveUserDetails(it.value.key,it.value.key,it.value.name,it.value.phone)
                            viewModel.saveUserDetailsSQL(User(it.value.key,it.value.key,"",it.value.email,it.value.phone,""
                                ,it.value.userid.toString(),it.value.name,""))
                            requireActivity().startNewActivity(HomeActivity::class.java)
                        }
                    }
                    else{
                        Toast.makeText(requireContext(),"Invalid Credential", Toast.LENGTH_SHORT).show()
                    }


                }
                is Resource.Failure -> handleApiError(it) { login() }
            }
        })

        binding.editTextTextPassword.addTextChangedListener {
            val email = binding.editTextTextEmailAddress.text.toString().trim()
            binding.buttonLogin.enable(email.isNotEmpty() && it.toString().isNotEmpty())
        }

        binding.buttonLogin.setOnClickListener {
            login()
        }
    }

    private fun login() {
        val email = binding.editTextTextEmailAddress.text.toString().trim()
        val password = binding.editTextTextPassword.text.toString().trim()
        viewModel.login(email, password)
    }
}