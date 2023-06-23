package com.example.peron.fragments

import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.peron.R
import com.example.peron.data.book.BookViewModel
import com.example.peron.data.user.User
import com.example.peron.data.user.UserViewModel
import com.example.peron.databinding.FragmentSignupBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SignupFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SignupFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    private var _binding: FragmentSignupBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentSignupBinding.inflate(inflater, container, false)
        //inflater.inflate(R.layout.fragment_signup, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.signUpButton.setOnClickListener {
            insertDataToDatabase()
        }

        return binding.root
    }

    private fun insertDataToDatabase() {
        val username = binding.usernameBox.text.toString()
        val password = binding.passwordBox.text.toString()
        val confirmPassword = binding.confirmPassword.text.toString()

        if(inputCheck(username, password, confirmPassword)){
            if (password == confirmPassword){
                val user = User(0, username, password)
                mUserViewModel.addUser(user)
                Toast.makeText(requireContext(), "User Registered", Toast.LENGTH_LONG).show()
                findNavController().navigateUp()
            } else{
                Toast.makeText(requireContext(), "Password Incorrect", Toast.LENGTH_LONG).show()
            }
        }else{
            Toast.makeText(requireContext(), "Fill the Blank", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(username: String, password: String, confirmPassword: String): Boolean {
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(password) && TextUtils.isEmpty(confirmPassword))
    }

}