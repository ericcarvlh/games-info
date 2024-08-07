package br.com.gamesinfo.modelo

interface Recomendavel {
    val mediaNotas: Double

    fun recomendar(nota: Int)
}