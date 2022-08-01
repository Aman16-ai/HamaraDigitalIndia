package com.example.hamaradigitalindia.ui

import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.MediaController
import com.example.hamaradigitalindia.R
import com.example.hamaradigitalindia.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.videoView.apply {
            setVideoURI(Uri.parse("https://hamaradigitalindia.in/Video.mp4"))
            start()
        }


        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}