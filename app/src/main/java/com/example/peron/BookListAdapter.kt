package com.example.peron

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

import com.example.peron.database.book.Book
import com.example.peron.databinding.BookListBinding

import android.content.Context
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter

class BookListAdapter(private val onItemClicked: (Book) -> Unit) :
    ListAdapter<Book, BookListAdapter.BookViewHolder>(DiffCallback) {

    class BookViewHolder(private var binding: BookListBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(book: Book) {
            binding.bookTitle.text = book.bookTitle
        }
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
//        val current = getBooks(position)
//        holder.itemView.setOnClickListener {
//            onItemClicked(current)
//        }
//        holder.bind(current)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        return BookViewHolder(
            BookListBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    companion object {
        private val DiffCallback = object : DiffUtil.ItemCallback<Book>() {
            override fun areItemsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem === newItem
            }

            override fun areContentsTheSame(oldItem: Book, newItem: Book): Boolean {
                return oldItem.bookTitle == newItem.bookTitle
            }
        }
    }
}