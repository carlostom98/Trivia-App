package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.example.navigation.databinding.FragmentSecondAnswerBinding

class SecondAnswerFragment : Fragment() {

    private var _binding:FragmentSecondAnswerBinding?=null
    private val binding get() = _binding!!

    private lateinit var activity:MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        this.activity= getActivity() as MainActivity
        _binding=FragmentSecondAnswerBinding.inflate(inflater,container, false)
        return binding.root
    }
}