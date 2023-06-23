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
import com.example.peron.data.book.Book
import com.example.peron.data.book.BookViewModel
import com.example.peron.data.user.User
import com.example.peron.data.user.UserRepository
import com.example.peron.data.user.UserViewModel
import com.example.peron.databinding.FragmentLoginBinding
import com.example.peron.databinding.FragmentSignupBinding

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel
    private lateinit var verifyUser: User

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        //inflater.inflate(R.layout.fragment_signup, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        binding.textView4.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_signupFragment)
        }

        binding.login.setOnClickListener {
            //login()
            findNavController().navigate(R.id.action_loginFragment_to_homepageFragment)
        }

        return binding.root
    }

    private fun login(){
        val username = binding.usernameBox.text.toString()
        val password = binding.passwordBox.text.toString()

        if(inputCheck(username, password)){

//            mUserViewModel.readData(username, password).observe(viewLifecycleOwner, Observer { user ->
//                this.setData(user)
//            })

            if (verifyUser != null){
                Toast.makeText(requireContext(),"Welcome ${verifyUser!!.username}",Toast.LENGTH_LONG).show()
                findNavController().navigate(R.id.action_loginFragment_to_homepageFragment)
            }
            else{
                Toast.makeText(requireContext(), "Username or Password is Incorrect", Toast.LENGTH_LONG).show()
            }
        } else{
            Toast.makeText(requireContext(), "Fill the Blank", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(username: String, password: String): Boolean {
        return !(TextUtils.isEmpty(username) && TextUtils.isEmpty(password))
    }

}