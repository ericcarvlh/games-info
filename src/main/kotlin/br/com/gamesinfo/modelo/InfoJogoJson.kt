package br.com.gamesinfo.modelo

import com.google.gson.annotations.Expose

data class InfoJogoJson(
    @Expose val titulo: String,
    @Expose val capa: String,
    val preco: Double,
    val descricao: String,
): Recomendavel {
    private var listaNotas = mutableListOf<Int>()

    override val mediaNotas: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (listaNotas.isNullOrEmpty())
            listaNotas = mutableListOf()

        listaNotas.add(nota)
    }
}
