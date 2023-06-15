package com.example.peron

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.peron.database.user.User
import com.example.peron.viewmodels.UserViewModel
import com.example.peron.viewmodels.UserViewModelFactory
import androidx.navigation.fragment.findNavController

class AddUserFragment : Fragment() {

    private val viewModel: UserViewModel by activityViewModels {
        UserViewModelFactory(
            (activity?.application as PeronApplication).userDatabase
                .userDao()
        )
    }

    lateinit var user: User

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    private fun isEntryValid(): Boolean {
        return viewModel.isEntryValid(
            binding.userName.text.toString(),
            binding.password.text.toString(),
            binding.confirmPassword.text.toString(),
        )
    }

    private fun addNewUser() {
        if(isEntryValid()) {
            viewModel.addNewItem(
                binding.userName.text.toString(),
                binding.password.text.toString(),
                binding.confirmPassword.text.toString()
            )
        }

        val action = AddItemFragmentDirections.actionAddItemFragmentToItemListFragment()
        findNavController().navigate(action)
    }
}