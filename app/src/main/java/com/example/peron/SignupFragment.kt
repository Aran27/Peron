package com.example.peron

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.peron.database.user.User
import com.example.peron.databinding.FragmentSignupBinding
import com.example.peron.viewmodels.UserViewModel
import com.example.peron.viewmodels.UserViewModelFactory

class SignupFragment : Fragment() {

    var user: User? = null

    private val viewModel: UserViewModel by activityViewModels {
        UserViewModelFactory(
            (activity?.application as PeronApplication).userDatabase
                .userDao()
        )
    }

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        return  binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signUpButton.setOnClickListener {
            addNewUser()
        }
    }

    private fun isEntryValid(): Int {
        return viewModel.isEntryValid(
            binding.usernameBox.text.toString(),
            binding.passwordBox.text.toString(),
            binding.confirmPassword.text.toString(),
        )
    }

    private fun addNewUser() {
        if(isEntryValid() == 1) {
            Toast.makeText(activity, "Something is Blank", Toast.LENGTH_SHORT).show()
        } else if(isEntryValid() == 2) {
            Toast.makeText(activity, "Password Mismatch", Toast.LENGTH_SHORT).show()
        } else{
            viewModel.addNewUser(
                binding.usernameBox.text.toString(),
                binding.passwordBox.text.toString()
            )
            findNavController().popBackStack()
            Toast.makeText(activity, "User Registered", Toast.LENGTH_SHORT).show()
        }
    }
}
