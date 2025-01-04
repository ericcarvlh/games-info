package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.dados.dao.JogoDAO
import br.com.gamesinfo.modelo.Jogo

fun main() {
    val dao = JogoDAO()

    val listaJogos = dao.getJogos()
    println(listaJogos)
}