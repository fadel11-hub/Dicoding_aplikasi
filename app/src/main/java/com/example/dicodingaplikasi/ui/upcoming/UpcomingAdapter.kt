package com.example.dicodingaplikasi.ui.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingaplikasi.data.response.ListEventsItem
import com.example.dicodingaplikasi.databinding.ItemEventListBinding

class UpcomingAdapter(private val onItemClick: (ListEventsItem) -> Unit) : ListAdapter<ListEventsItem, UpcomingAdapter.MyViewHolder>(DIFF_CALLBACK) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListEventsItem>() {
            override fun areItemsTheSame(oldItem: ListEventsItem, newItem: ListEventsItem): Boolean {
                // Perbandingan apakah item sama berdasarkan ID atau atribut unik lainnya
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListEventsItem, newItem: ListEventsItem): Boolean {
                // Perbandingan apakah konten item sama
                return oldItem == newItem
            }
        }
    }

    // ViewHolder class to hold item views
    class MyViewHolder(private val binding: ItemEventListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListEventsItem, onItemClick: (ListEventsItem) -> Unit) {
            // Binding data ke tampilan
            binding.tvName.text = item.name
            binding.tvOwner.text = item.ownerName
            binding.tvLocation.text = item.cityName
            Glide.with(binding.root.context).load(item.imageLogo).into(binding.ivThumbnail)

            // Tambahkan tindakan klik untuk membuka detail event
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Inflate layout untuk setiap item
        val binding = ItemEventListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Bind data ke tampilan item
        val event = getItem(position)
        holder.bind(event, onItemClick)
    }
}
