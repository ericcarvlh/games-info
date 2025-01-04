package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.dados.dao.JogoDAO
import br.com.gamesinfo.modelo.Jogo

fun main() {
    val dao = JogoDAO()

    val jogo = Jogo("Teste Inclusao", "Teste Inclusao", 2.7, "Teste")
    dao.adicionaJogo(jogo)

    val listaJogos: List<Jogo> = dao.getJogos()
    println(listaJogos)
}