package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.dados.dao.JogoDAO
import br.com.gamesinfo.modelo.Jogo

fun main() {
    val manager = Banco.getEntityManager()
    val dao = JogoDAO(manager)

    val jogo = Jogo("Teste Hibernate", "Teste Hibernate", 2.87, "Teste Hibernate")
    dao.adicionarJogo(jogo)

    val listaJogos = dao.getJogos()
    println(listaJogos)

    manager?.close()
}