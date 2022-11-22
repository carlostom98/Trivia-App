package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
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
            it.findNavController().navigate(GameFragmentDirections.actionGameFragmentToPhoneFragment("Message correctly send"))
        }
        val helloFragment:GameFragmentArgs by navArgs()
        Toast.makeText(this.context, helloFragment.saludoFragment, Toast.LENGTH_LONG ).show()
        return binding.root
    }

}