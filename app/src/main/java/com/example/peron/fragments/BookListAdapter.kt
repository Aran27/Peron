package com.example.peron.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.ListFragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.peron.R
import com.example.peron.data.book.Book

class BookListAdapter: RecyclerView.Adapter<BookListAdapter.ViewHolder>() {

    private var bookList = emptyList<Book>()

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.book_list, parent, false))
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentBook = bookList[position]
        holder.itemView.findViewById<TextView>(R.id.bookTitle).text = currentBook.book_title
        holder.itemView.findViewById<ImageView>(R.id.bookImage).setImageResource(R.drawable.history)
        holder.itemView.findViewById<ConstraintLayout>(R.id.bookLayout).setOnClickListener{
            val action = HomepageFragmentDirections.actionHomepageFragmentToBookFragment(currentBook)
            holder.itemView.findNavController().navigate(action)
        }
    }

    fun setData(book: List<Book>) {
        this.bookList = book
        notifyDataSetChanged()
    }
}