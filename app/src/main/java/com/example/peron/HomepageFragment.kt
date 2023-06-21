package com.example.peron

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peron.databinding.FragmentHomepageBinding
import com.example.peron.viewmodels.BookViewModel
import com.example.peron.viewmodels.BookViewModelFactory

class HomepageFragment : Fragment() {

    private val viewModel: BookViewModel by activityViewModels {
        BookViewModelFactory(
            (activity?.application as PeronApplication).bookDatabase.bookDao()
        )
    }

    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!
//
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomepageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = BookListAdapter {
            val action = HomepageFragmentDirections.actionHomepageFragment4ToBookDescFragment()
            this.findNavController().navigate(action)
        }
        binding.recyclerView.layoutManager = LinearLayoutManager(this.context)
        binding.recyclerView.adapter = adapter
        // Attach an observer on the allItems list to update the UI automatically when the data
        // changes.
        viewModel.allBooks.observe(this.viewLifecycleOwner) { books ->
            books.let {
                adapter.submitList(it)
            }
        }

        binding.accountHome.setOnClickListener {
            val action = HomepageFragmentDirections.actionHomepageFragment4ToProfileFragment4()
            this.findNavController().navigate(action)
        }

        binding.menuList.setOnClickListener {
            val action = HomepageFragmentDirections.actionHomepageFragment4ToHistoryFragment5()
            this.findNavController().navigate(action)
        }

        binding.imageView7.setOnClickListener {

        }
    }
}