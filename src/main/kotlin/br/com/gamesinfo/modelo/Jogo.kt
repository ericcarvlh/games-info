package br.com.gamesinfo.modelo

import com.google.gson.annotations.Expose
import jakarta.persistence.*

// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

data class Jogo(
    @Expose val titulo: String,
    @Expose val capa: String,
): Recomendavel {
    private var id:Int? = null
    var preco: Double = 0.0
    var descricao: String? = null

    private var listaNotas = mutableListOf<Int>()

    override val mediaNotas: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (listaNotas.isEmpty())
            listaNotas = mutableListOf()

        listaNotas.add(nota)
    }

    override fun toString(): String {
        return "\nid: $id\ntitulo: $titulo\ncapa: $capa\npreço: $preco\ndescricao: $descricao\n"
    }

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String?,
        id: Int
    ) : this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco
        this.id = id
    }

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String?
    ) : this(titulo, capa) {
        this.descricao = descricao
        this.preco = preco
    }
}