import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.dicodingaplikasi.data.response.ListEventsItem
import com.example.dicodingaplikasi.databinding.ItemEventListBinding

class FinishedAdapter : ListAdapter<ListEventsItem, FinishedAdapter.MyViewHolder>(DIFF_CALLBACK) {

    companion object {
        // DiffUtil untuk membandingkan item dan konten
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<ListEventsItem>() {
            override fun areItemsTheSame(oldItem: ListEventsItem, newItem: ListEventsItem): Boolean {
                // Perbandingan apakah item sama berdasarkan ID
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: ListEventsItem, newItem: ListEventsItem): Boolean {
                // Perbandingan apakah konten item sama
                return oldItem == newItem
            }
        }
    }

    // ViewHolder untuk menahan referensi tampilan item
    class MyViewHolder(private val binding: ItemEventListBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ListEventsItem) {
            // Binding data ke UI
            binding.tvName.text = item.name
            binding.tvOwner.text = item.ownerName
            binding.tvLocation.text = item.cityName
            // Menggunakan Glide untuk memuat gambar
            Glide.with(binding.root.context).load(item.imageLogo).into(binding.ivThumbnail)
        }
    }

    // Meng-inflate item layout dan membuat ViewHolder
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemEventListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    // Mengikat data ke ViewHolder
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val event = getItem(position)
        holder.bind(event)
    }
}
