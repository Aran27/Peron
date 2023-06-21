package com.example.peron

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import com.example.peron.database.user.User
import com.example.peron.viewmodels.UserViewModel
import com.example.peron.viewmodels.UserViewModelFactory
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peron.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {
    private val viewModel: UserViewModel by activityViewModels {
        UserViewModelFactory(
            (activity?.application as PeronApplication).userDatabase.userDao()
        )
    }

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.textView4.setOnClickListener {
            val action = LoginFragmentDirections.actionLoginFragmentToSignupFragment2()
            this.findNavController().navigate(action)
        }

        binding.login.setOnClickListener {
            login()
        }
    }

    private fun isEntryValid(): Int {
        return viewModel.isEntryValid2(
            binding.usernameBox.text.toString(),
            binding.passwordBox.text.toString()
        )
    }

    private fun login() {
        if(isEntryValid() == 1) {
            Toast.makeText(activity, "Fill the Blank", Toast.LENGTH_SHORT).show()
        }
//        else if (){
//            Toast.makeText(activity, "Username or Password is Incorrect", Toast.LENGTH_SHORT).show()
//        }
        else
        {
            Toast.makeText(activity, "Login Success", Toast.LENGTH_SHORT).show()
            val action = LoginFragmentDirections.actionLoginFragmentToHomepageFragment4()
            this.findNavController().navigate(action)
        }
    }
}