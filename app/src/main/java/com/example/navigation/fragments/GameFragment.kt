package com.example.navigation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import com.example.navigation.MainActivity
import com.example.navigation.R
import com.example.navigation.databinding.FragmentGameBinding
import com.example.navigation.viewModel.QuestionsViewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding get() = _binding!!
    private val questionsViewModel: QuestionsViewModel by viewModels()

    private lateinit var activity: MainActivity
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        this.activity = getActivity() as MainActivity
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        questionsViewModel.setQuestion()
        questionsViewModel.question.observe(activity) {
            val shuffledAnswers = it.answers.shuffled()
            with(binding) {
                textView.text = it.question
                questionOne.text = shuffledAnswers[0]
                questionTwo.text = shuffledAnswers[1]
                questionThree.text = shuffledAnswers[2]
                questionFour.text = shuffledAnswers[3]
            }
        }
        val helloFragment: GameFragmentArgs by navArgs()
        Toast.makeText(this.context, helloFragment.saludoFragment, Toast.LENGTH_LONG).show()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.continueButton.setOnClickListener {
            val buttonChecked = binding.radioButtonGroup.checkedRadioButtonId
            when(buttonChecked){
               R.id.questionOne-> {navigateTo("CONGRATS", "YOU DID IT", it)}
               R.id.questionTwo-> {navigateTo("CONGRATS 2", "YOU DID IT 2", it)}
               R.id.questionThree -> {navigateTo(":( NOT EXACTLY", "KEEP IT UP", it)}
               R.id.questionFour-> {navigateTo(":( NOT EXACTLY", "KEEP IT UP", it)}
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun navigateTo(sendOne:String, sendTwo:String, view: View){
        view.findNavController().navigate(GameFragmentDirections.actionGameFragmentToPhoneFragment(sendOne,sendTwo))
    }
}