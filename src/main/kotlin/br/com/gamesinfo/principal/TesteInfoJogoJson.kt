package br.com.gamesinfo.principal

import br.com.gamesinfo.servicos.ConsumoAPI

fun main() {
    val consumo = ConsumoAPI()
    val gamers = consumo.buscaGamers()
    val jogos = consumo.buscaJogos()

    val gamerBruno = gamers[4]
    val jogoRd2 = jogos[3]

    println(gamerBruno)
    println(jogoRd2)

    val aluguel = gamerBruno.alugaJogo(jogoRd2)

    println(aluguel)
}