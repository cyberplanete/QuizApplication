package net.courrielprivate.quizapplication

object Constante {

    fun getQuestions(): ArrayList<Question> {
        val questionsList = ArrayList<Question>()
        val que1 = Question(
            1,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_argentina,
            "Argentine",
            "Belgique",
            "Roumanie",
            "Italie",1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_australia,
            "Bresil",
            "Angleterre",
            "Australie",
            "Italie",3
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_belgium,
            "Afrique du sud",
            "Belgique",
            "Roumanie",
            "Maroc",2
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_brazil,
            "Argentine",
            "Cuba",
            "Canada",
            "Brésil",4
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_germany,
            "Mexique",
            "Malaisie",
            "Allemagne",
            "Lybie",3
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_india,
            "Autriche",
            "Kenya",
            "India",
            "Israël",3
        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_kuwait,
            "Laos",
            "Malte",
            "Koweït",
            "Liban",3
        )
        questionsList.add(que7)

        val que8 = Question(
            8,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_new_zealand,
            "Nigeria",
            "Nouvelle-Zélande",
            "Pérou",
            "Pologne",2
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_denmark,
            "Danemark",
            "Estonie",
            "Finlande",
            "Géorgie",1
        )
        questionsList.add(que9)

        val que10 = Question(
            10,
            "Quel est le nom du pays correspondant à cet drapeau",
            R.drawable.ic_flag_of_fiji,
            "Slovénie",
            "Tunisie",
            "Zimbabwe",
            "Fiji",4
        )
        questionsList.add(que10)
        return questionsList
    }

}