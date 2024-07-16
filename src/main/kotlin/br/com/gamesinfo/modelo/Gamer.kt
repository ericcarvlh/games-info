package br.com.gamesinfo.modelo

import kotlin.random.Random
import kotlin.random.nextInt

data class Gamer(
    var nome: String,
    var email: String,
) {
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank())
                criarIdInterno()
        }
    var idInterno:String? = null
        private set

    constructor(
        nome: String,
        email: String,
        dataNascimento: String,
        usuario: String
    ): this(nome, email) {
        this.dataNascimento = dataNascimento
        this.usuario = usuario
        criarIdInterno()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    private fun criarIdInterno() {
        val numeroAleatorio = Random.nextInt(100000)
        val tag = String.format("%04d", numeroAleatorio)

        idInterno = "$usuario#$tag"
    }
}
