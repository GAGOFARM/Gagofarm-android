package com.foo.gagofarm

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.foo.gagofarm.data.SearchViewItem
import com.foo.gagofarm.databinding.SearchRecyclerviewItemBinding


class SearchRecyclerViewAdapter (val context: Context) :
    RecyclerView.Adapter<SearchRecyclerViewAdapter.ViewHolder>(){

    var list = mutableListOf<SearchViewItem>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SearchRecyclerviewItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, positon: Int) {
        val item = list[positon]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    inner class ViewHolder(val binding:SearchRecyclerviewItemBinding)
        : RecyclerView.ViewHolder(binding.root) {

        init{
            binding.farmImageView.setOnClickListener{
                Toast.makeText(context, "image", Toast.LENGTH_SHORT).show()
                val intent = Intent(context, DetailActivity::class.java)
                startActivity(context,intent,null)

            }
            binding.isBookmarked.setOnClickListener{
                Toast.makeText(context, "bookmark", Toast.LENGTH_SHORT).show()
            }
        }

        fun bind(searchViewItem: SearchViewItem) {
            binding.farmImageView.setImageDrawable(null)
            binding.priceTextView.text = searchViewItem.price.toString()
            binding.distanceTextView.text = searchViewItem.distance
            binding.farmTitleTextView.text = searchViewItem.title
            binding.periodTextView.text = searchViewItem.period
            binding.isBookmarked.setImageResource(if(searchViewItem.bookmarked ) R.drawable.ic_bookmarked else R.drawable.ic_bookmark)
        }

    }
}