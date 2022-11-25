package com.example.navigation.model

class QuestionsProvier {
companion object{
    fun getQuestions():QuestionsModel{
        val questionsShuffled= mapOfQuestios.shuffled()
        return questionsShuffled[0]
    }

    private val mapOfQuestios = listOf(
        QuestionsModel("¿Quién gano el mundial del 86?", listOf("Argentina", "México", "Brasil", "Alemania")),
        QuestionsModel("¿En que año fue el Maracanazo?", listOf("1950","1990", "1958", "1974")),
        QuestionsModel("¿Quién es el máximo goleador de la historia de los mundiales ?", listOf("Miroslav Klose","Diego Maradona", "Luis Figo", "Ronaldo Nazario")),
        QuestionsModel("¿Cómo se llama la mascota del mundial del 82?", listOf("Naranjito","Fuleco", "Zakumi", "Laebb")),
        QuestionsModel("¿Quién marcó el primer gol en la historia de los mundiales ?'", listOf("Lucien Laurient","Guillermo Stábile", "Obdulio Varela", "Bigode")),
    )
}
}