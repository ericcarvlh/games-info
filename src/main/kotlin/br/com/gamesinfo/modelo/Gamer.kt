package br.com.gamesinfo.modelo

import br.com.gamesinfo.modelo.plano.Plano
import br.com.gamesinfo.modelo.plano.PlanoAvulso
import java.util.Scanner
import kotlin.random.Random

data class Gamer(
    var nome: String,
    var email: String,
): Recomendavel {
    var dataNascimento:String? = null
    var usuario:String? = null
        set(value) {
            field = value
            if (idInterno.isNullOrBlank())
                criarIdInterno()
        }
    var idInterno:String? = null
        private set
    var plano: Plano = PlanoAvulso("BRONZE")
    var jogosBuscados:MutableList<Jogo?> = mutableListOf<Jogo?>()
    var jogosAlugados = mutableListOf<Aluguel>()
    private val listaNotas = mutableListOf<Int>()

    override val mediaNotas: Double
        get() = listaNotas.average()

    override fun recomendar(nota: Int) {
        if (nota < 1 || nota > 10) {
            val msgNotaInvalida = "A nota inserida é inválida!! Deve estar entre 1 e 10"
            println(msgNotaInvalida)
            throw Exception(msgNotaInvalida)
        }

        listaNotas.add(nota)
    }

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
        return "Gamer(nome='$nome', email='$email', dataNascimento=$dataNascimento, usuario=$usuario, idInterno=$idInterno, Reputação=$mediaNotas)"
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

    fun alugaJogo(jogoJson: InfoJogoJson, periodo: Periodo): Aluguel {
        val aluguel = Aluguel(this, jogoJson, periodo)
        jogosAlugados.add(aluguel)

        return aluguel
    }

    fun jogosDoMes(mesEmQuestao: Int): List<InfoJogoJson> {
        return jogosAlugados.filter {
            aluguel -> aluguel.periodo.dataInicial.monthValue == mesEmQuestao
        }.map {
            aluguel -> aluguel.jogoJson
        }
    }

    // equivalente a static no kotlin
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
