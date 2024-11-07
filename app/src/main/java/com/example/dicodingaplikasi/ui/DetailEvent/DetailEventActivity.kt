package com.example.dicodingaplikasi.ui.DetailEvent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Spanned
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.text.HtmlCompat
import com.bumptech.glide.Glide
import com.example.dicodingaplikasi.databinding.ActivityDetailEventBinding


class DetailEventActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailEventBinding
    companion object{
        const val EXTRA_PHOTO = "extra_photo"
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_OWNER = "extra_owner"
        const val EXTRA_LOCATION = "extra_location"
        const val EXTRA_DESCRIPTION = "extra_description"
        const val EXTRA_REGISTRANTS = "extra_registrants"
        const val EXTRA_QUOTA = "extra_quota"
        const val EXTRA_BEGIN_TIME = "extra_begin_time"
        const val EXTRA_SUMMARY = "extra_summary"
        const val EXTRA_LINK = "extra_link"
    }

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         binding = ActivityDetailEventBinding.inflate(layoutInflater)
         setContentView(binding.root)

         val photo = intent.getStringExtra(EXTRA_PHOTO)
         val name = intent.getStringExtra(EXTRA_NAME)
         val owner = intent.getStringExtra(EXTRA_OWNER)
         val location = intent.getStringExtra(EXTRA_LOCATION)
         val description = intent.getStringExtra(EXTRA_DESCRIPTION)
         val registrants = intent.getStringExtra(EXTRA_REGISTRANTS)?.toIntOrNull() ?: 0
         val quota = intent.getStringExtra(EXTRA_QUOTA)?.toIntOrNull() ?: 0
         val beginTime = intent.getStringExtra(EXTRA_BEGIN_TIME)
         val summary = intent.getStringExtra(EXTRA_SUMMARY)
         val link = intent.getStringExtra(EXTRA_LINK)

//        Menghitung sisa kuota dengan memeriksan null
         val sisaKuota = quota - registrants


         binding.tvEventDetail.text = name
         binding.tvOwner.text = owner
         binding.tvLocation.text = location
         binding.tvBegin.text = beginTime
         binding.tvQuota.text = sisaKuota.toString()


         Glide.with(this).load(photo).into(binding.tvEventImage)

         binding.description.text = fromHtml(description ?: "")
         binding.btnRegister.setOnClickListener {
            link?.let{
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
                startActivity(intent)
            } ?: run {
                Toast.makeText(this, "Link tidak tersedia", Toast.LENGTH_SHORT).show()
            }

         }

     }

    private fun fromHtml(html: String): Spanned {
        return HtmlCompat.fromHtml(html, HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}