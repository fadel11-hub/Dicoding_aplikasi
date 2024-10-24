package com.example.dicodingaplikasi.ui.upcoming

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingaplikasi.R
import com.example.dicodingaplikasi.databinding.ActivityMainBinding
import com.example.dicodingaplikasi.databinding.FragmentUpcomingBinding
import com.example.dicodingaplikasi.databinding.ItemEventListBinding


class UpcomingFragment : Fragment() {

    private var _binding = FragmentUpcomingBinding? = null
    private val binding get() = _binding!!

    private val upcomingViewModel by viewModels<UpcomingViewModel>()
    private lateinit var adapter: UpcomingAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUpcomingBinding.inflate(inflater, container, false)

        adapter = UpcomingAdapter()
        binding.rv_event.adapter = adapter
        binding.rv_event.layoutManager = LinearLayoutManager(requireContext())

        upcomingViewModel.isLoading.observe(viewLifecycleOwner) { events ->
            showLoading(events)
        }


        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_upcoming, container, false)
    }

    private fun showLoading(isLoading: Boolean) {
        binding.progressBar.visibility = if (isLoading) View.VISIBLE else View.GONE

    }


}