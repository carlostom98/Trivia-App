package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.example.navigation.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private var _binding:FragmentGameBinding?=null
    private val binding get() = _binding!!

    private lateinit var activity:MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.activity = getActivity() as MainActivity
        _binding= FragmentGameBinding.inflate(inflater,container,false)
        binding.continueButton.setOnClickListener {
            it.findNavController().navigate(R.id.action_gameFragment_to_phoneFragment)
        }
        return binding.root
    }

}