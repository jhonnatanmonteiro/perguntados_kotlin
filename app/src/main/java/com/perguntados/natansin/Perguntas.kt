package com.perguntados.natansin

class Perguntas (
    val questionText: String,
    val options: List<String>,
    val correctAnswerIndex: Int
)





//Perguntas e resposta
val ListaPergunta = listOf(
    Perguntas("Qual é a capital da França?", listOf("Londres", "Paris", "Madri", "Barcelona"), 1),
    Perguntas("Qual é a cor do céu em um dia claro?", listOf("Azul", "Vermelho", "Verde", "Roxo"), 0),
    Perguntas("Quem escreveu a peça 'Romeu e Julieta'?", listOf("William Shakespeare", "Charles Dickens", "Jane Austen", "F. Scott Fitzgerald"), 0),
    Perguntas("Qual é o maior planeta do sistema solar?", listOf("Terra", "Júpiter", "Marte", "Vênus"), 1),
    Perguntas("Qual é o símbolo químico para o ouro?", listOf("Au", "Ag", "Fe", "Cu"), 0),
    Perguntas("Qual é o maior animal terrestre?", listOf("Elefante", "Rinoceronte", "Girafa", "Hipopótamo"), 0),
    Perguntas("Qual é o maior oceano do mundo?", listOf("Oceano Atlântico", "Oceano Índico", "Oceano Ártico", "Oceano Pacífico"), 3),
    Perguntas("Qual é o segundo planeta do sistema solar?", listOf("Terra", "Vênus", "Marte", "Júpiter"), 1),
    Perguntas("Qual é a montanha mais alta do mundo?", listOf("Monte Everest", "Monte Kilimanjaro", "Monte McKinley", "Monte Fuji"), 0),
    Perguntas("Qual é a unidade básica de medida de tempo no sistema internacional?", listOf("Segundo", "Minuto", "Hora", "Dia"), 0)
)







