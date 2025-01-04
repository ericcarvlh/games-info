package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.modelo.Jogo

fun main() {
    val listaJogos: List<Jogo> = Banco.getJogos()
    println(listaJogos)

    val Jogo = Jogo("Teste Inclusao", "Teste Inclusao", 2.7, "Teste")
}