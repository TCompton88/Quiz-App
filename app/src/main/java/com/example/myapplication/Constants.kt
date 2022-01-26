package com.example.myapplication

object Constants {
    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Armenia",
            "Austria",
            "Hungary",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_denmark,
            "Jordan",
            "Spain",
            "Denmark",
            "Scotland",
            3
        )
        questionsList.add(que2)

        val que3 = Question(
            3, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_germany,
            "Belgium",
            "Germany",
            "Greenland",
            "Turkey",
            2
        )
        questionsList.add(que3)

        val que4 = Question(
            4, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_fiji,
            "Jamaica",
            "South Korea",
            "Ecuador",
            "Fiji",
            4
        )
        questionsList.add(que4)

        val que5 = Question(
            5, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Peru",
            "Italy",
            "Chad",
            1
        )
        questionsList.add(que5)

        val que6 = Question(
            6, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_new_zealand,
            "North Korea",
            "Japan",
            "New Zealand",
            "Puerto Rico",
            3
        )
        questionsList.add(que6)

        val que7 = Question(
            7, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_india,
            "Greece",
            "China",
            "El Salvador",
            "India",
            4
        )
        questionsList.add(que7)

        val que8 = Question(
            8, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_kuwait,
            "Portugal",
            "Chile",
            "Kuwait",
            "France",
            3
        )
        questionsList.add(que8)

        val que9 = Question(
            9, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_australia,
            "Bolivia",
            "Australia",
            "Ireland",
            "Nigeria",
            2
        )
        questionsList.add(que9)

        val que10 = Question(
            10, "What Country does this flag belong to?",
            R.drawable.ic_flag_of_belgium,
            "Belgium",
            "Cuba",
            "Uruguay",
            "Ghana",
            1
        )
        questionsList.add(que10)

        return questionsList
    }
}