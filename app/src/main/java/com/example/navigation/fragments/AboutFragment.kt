package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation.MainActivity
import com.example.navigation.databinding.FragmentAboutBinding

class AboutFragment : Fragment() {

    private var _binding:FragmentAboutBinding?=null
    private val binding get() = _binding!!

    private lateinit var activity:MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.activity= getActivity() as MainActivity
        _binding=FragmentAboutBinding.inflate(inflater,container, false)
        return binding.root
    }
}