package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.modelo.Jogo

fun main() {
    val listaJogos: List<Jogo> = Banco.getJogos()
    println(listaJogos)
}