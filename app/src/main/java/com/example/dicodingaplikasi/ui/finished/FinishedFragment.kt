package com.example.dicodingaplikasi.ui.finished

import FinishedAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicodingaplikasi.R
import com.example.dicodingaplikasi.databinding.FragmentFinishedBinding


class FinishedFragment : Fragment() {

    private var _binding : FragmentFinishedBinding? = null
    private val binding get() = _binding

    private val finishedViewModel by viewModels<FinishedViewModel>()
    private lateinit var adapter : FinishedAdapter


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFinishedBinding.inflate(inflater, container, false)

        // Inflate the layout for this fragment
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = FinishedAdapter()
        binding?.rvFinished?.layoutManager = LinearLayoutManager(requireContext())
        binding?.rvFinished?.adapter = adapter

        finishedViewModel.isLoading.observe(viewLifecycleOwner) { events ->
            showLoading(events)
        }
    }

    private fun showLoading(isLoading: Boolean){
        binding?.progressBar?.visibility = if (isLoading) View.VISIBLE else View.GONE

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}