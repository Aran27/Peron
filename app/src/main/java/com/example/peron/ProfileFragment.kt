package com.example.peron

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.peron.databinding.FragmentHistoryBinding
import com.example.peron.databinding.FragmentProfileBinding
import com.example.peron.viewmodels.BookViewModel
import com.example.peron.viewmodels.BookViewModelFactory
import com.example.peron.viewmodels.UserViewModel
import com.example.peron.viewmodels.UserViewModelFactory

class ProfileFragment : Fragment() {
//    private lateinit var back_arrow: AppCompatImageView
//    private lateinit var logout: AppCompatImageView
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_profile)
//
//
//        logout = findViewById(R.id.logout)
//
//        logout.setOnClickListener {
//            val intent = Intent(this@ProfileFragment, MainActivity::class.java)
//            startActivity(intent)
//        }
//
//        back_arrow = findViewById(R.id.arrow_back)
//
//        back_arrow.setOnClickListener {
//            val intent2 = Intent(this@ProfileFragment, HomepageFragment::class.java)
//            startActivity(intent2)
//        }
//    }

    private val viewModel: UserViewModel by activityViewModels {
        UserViewModelFactory(
            (activity?.application as PeronApplication).userDatabase.userDao()
        )
    }

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.arrowBack.setOnClickListener {
            this.findNavController().navigateUp()
        }

        binding.logout.setOnClickListener {
            val action = ProfileFragmentDirections.actionProfileFragment4ToLoginFragment()
            this.findNavController().navigate(action)
        }
    }
}