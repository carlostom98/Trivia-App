package com.example.navigation.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigation.model.QuestionsModel
import com.example.navigation.model.QuestionsProvier

class QuestionsViewModel:ViewModel() {
    var question=MutableLiveData<QuestionsModel>()

fun setQuestion(){
    question.postValue(QuestionsProvier.getQuestions())
}
}