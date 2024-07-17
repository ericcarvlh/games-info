package br.com.gamesinfo.modelo

import java.util.Scanner
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
    var jogosBuscados:MutableList<Jogo?> = mutableListOf<Jogo?>()

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

    init {
        this.email = validarEmail()
        this.nome = validaNome()
    }

    override fun toString(): String {
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno)"
    }

    private fun criarIdInterno() {
        val numeroAleatorio = Random.nextInt(100000)
        val tag = String.format("%04d", numeroAleatorio)

        idInterno = "$usuario#$tag"
    }

    private fun validarEmail():String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if(regex.matches(email))
            return email
        else
            throw IllegalArgumentException("Email inválido!")
    }

    private fun validaNome():String {
        if (nome.isBlank())
            throw IllegalArgumentException("Nome em branco!")
        else
            return nome
    }

    companion object {
        fun criarGamer(leitura: Scanner): Gamer {
            println("Boas vindas ao Games Info! Vamos fazer seu cadastro.")
            println("")
            println("Digite seu nome:")
            val nome = leitura.nextLine()
            println("Digite seu e-mail:")
            val email = leitura.nextLine()

            println("Deseja completar seu cadastro com usuário e data de nascimento? (S/N)")
            val opcao = leitura.nextLine()

            if (opcao.equals("S", true)) {
                println("Digite sua data de nascimento(DD/MM/AAAA):")
                val nascimento = leitura.nextLine()
                println("Digite seu nome de usuário:")
                val usuario = leitura.nextLine()

                return Gamer(nome, email, nascimento, usuario)
            }

            return Gamer(nome, email)
        }
    }
}
