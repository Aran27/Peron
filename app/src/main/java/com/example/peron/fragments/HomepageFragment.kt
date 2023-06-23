package com.example.peron.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.peron.R
import com.example.peron.data.book.BookViewModel
import com.example.peron.data.user.UserViewModel
import com.example.peron.databinding.FragmentHomepageBinding
import com.example.peron.databinding.FragmentLoginBinding

/**
 * A simple [Fragment] subclass.
 * Use the [HomepageFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomepageFragment : Fragment(), SearchView.OnQueryTextListener {

    private lateinit var mBookViewModel: BookViewModel

    private var _binding: FragmentHomepageBinding? = null
    private val binding get() = _binding!!
    val adapter = BookListAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomepageBinding.inflate(inflater, container, false)
        //val view = inflater.inflate(R.layout.fragment_homepage, container, false)

        val recyclerView = binding.recyclerViewHome
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        mBookViewModel = ViewModelProvider(this).get(BookViewModel::class.java)
        mBookViewModel.readAllData.observe(viewLifecycleOwner, Observer { book ->
            adapter.setData(book)
        })

        val search = binding.searchView.setOnQueryTextListener(this)

        return binding.root
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if(query != null) {
            searchDatabase(query)
        }
        return true
    }

    override fun onQueryTextChange(query: String?): Boolean {
        if(query != null) {
            searchDatabase(query)
        }
        return true
    }

    private fun searchDatabase(query: String){
        val searchQuery = "%$query%"

        mBookViewModel.searchDatabase(searchQuery).observe(this, {list ->
            list.let {
                adapter.setData(it)
            }
        })
    }

}