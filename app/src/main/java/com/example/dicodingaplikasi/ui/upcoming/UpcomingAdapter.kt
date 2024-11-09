package com.example.dicodingaplikasi.ui.upcoming

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingaplikasi.data.response.ListEventsItem
import com.example.dicodingaplikasi.databinding.ItemEventListBinding

/**
 * Adapter untuk menampilkan daftar event yang akan datang.
 * Menggunakan `ListAdapter` untuk mengelola daftar item dan membandingkan perubahan data menggunakan `DiffUtil`.
 *
 * @property onItemClick Fungsi yang dipanggil ketika item dalam daftar diklik.
 */
class UpcomingAdapter(private val onItemClick: (ListEventsItem) -> Unit) : ListAdapter<ListEventsItem, UpcomingAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        /**
         * Callback untuk menentukan perbedaan antara dua objek `ListEventsItem` dalam daftar.
         * Digunakan oleh `ListAdapter` untuk optimalisasi performa.
         */
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListEventsItem>() {
            override fun areItemsTheSame(oldItem: ListEventsItem, newItem: ListEventsItem): Boolean {
                // Memeriksa apakah dua item adalah objek yang sama berdasarkan ID atau atribut unik lainnya.
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListEventsItem, newItem: ListEventsItem): Boolean {
                // Memeriksa apakah konten dua item sama
                return oldItem == newItem
            }
        }
    }

    /**
     * ViewHolder untuk item dalam daftar upcoming events.
     * Menyediakan fungsi untuk mengikat data ke tampilan item.
     *
     * @param binding Objek binding untuk layout item (`ItemEventListBinding`).
     */
    class MyViewHolder(private val binding: ItemEventListBinding) : RecyclerView.ViewHolder(binding.root) {

        /**
         * Mengikat data `ListEventsItem` ke tampilan dalam layout item.
         *
         * @param item Objek `ListEventsItem` yang berisi data event.
         * @param onItemClick Fungsi yang dipanggil ketika item diklik.
         */
        fun bind(item: ListEventsItem, onItemClick: (ListEventsItem) -> Unit) {
            // Menampilkan data event pada tampilan
            binding.tvName.text = item.name
            binding.tvOwner.text = item.ownerName
            binding.tvLocation.text = item.cityName
            Glide.with(binding.root.context).load(item.imageLogo).into(binding.ivThumbnail)

            // Menambahkan tindakan klik pada root layout item untuk membuka detail event
            binding.root.setOnClickListener {
                onItemClick(item)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        // Menginflate layout item `ItemEventListBinding` dan menginisialisasi ViewHolder
        val binding = ItemEventListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Mengikat data event ke ViewHolder pada posisi tertentu
        val event = getItem(position)
        holder.bind(event, onItemClick)
    }
}
