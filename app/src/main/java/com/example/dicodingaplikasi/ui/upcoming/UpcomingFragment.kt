package com.example.dicodingaplikasi.ui.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingaplikasi.R
import com.example.dicodingaplikasi.databinding.ActivityMainBinding
import com.example.dicodingaplikasi.databinding.FragmentUpcomingBinding
import com.example.dicodingaplikasi.databinding.ItemEventListBinding

// TODO: Rename parameter arguments, choose names that match

class UpcomingFragment : Fragment() {
    companion object {
        private val TAG = UpcomingFragment::class.java.simpleName
    }

    private lateinit var binding: FragmentUpcomingBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }


}