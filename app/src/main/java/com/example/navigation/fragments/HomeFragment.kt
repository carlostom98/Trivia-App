package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.example.navigation.databinding.FragmentHomeBinding
import kotlin.random.Random

class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding?=null
    private val binding get() = _binding!!
    private lateinit var activity:MainActivity

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.activity = getActivity() as MainActivity

        _binding=FragmentHomeBinding.inflate(inflater, container, false)

        binding.buttonPlay.setOnClickListener {
            val randomInt=Random.nextInt(0,2)
            if(randomInt != 1) {
                it.findNavController().navigate(R.id.action_homeFragment_to_phoneFragment)
            }else{
                it.findNavController().navigate(R.id.action_homeFragment_to_secondAnswerFragment)
            }
        }
        return binding.root
    }

}