package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.dados.dao.GamerDAO
import br.com.gamesinfo.dados.dao.JogoDAO
import br.com.gamesinfo.modelo.Gamer
import br.com.gamesinfo.modelo.Jogo

fun main() {
    val manager = Banco.getEntityManager()
    val jogoDAO = JogoDAO(manager)

    val listaJogos = jogoDAO.getJogos()
    println(listaJogos)

    val gamerDAO = GamerDAO(manager)

    val gamer = Gamer("Teste", "teste.teste@gmail.com", "11/11/2011", "testeTeste")
    gamerDAO.adicionaGamer(gamer)

    val gamers = gamerDAO.getGamers()
    println(gamers)

    manager?.close()
}