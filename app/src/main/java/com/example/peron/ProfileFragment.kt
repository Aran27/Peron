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