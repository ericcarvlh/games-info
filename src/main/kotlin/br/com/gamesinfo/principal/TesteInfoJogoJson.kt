package br.com.gamesinfo.principal

import br.com.gamesinfo.modelo.Periodo
import br.com.gamesinfo.servicos.ConsumoAPI
import java.time.LocalDate

fun main() {
    val consumo = ConsumoAPI()
    val gamers = consumo.buscaGamers()
    val jogos = consumo.buscaJogos()

    val gamerBruno = gamers[4]
    val jogoRd2 = jogos[3]

    println(gamerBruno)
    println(jogoRd2)

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))
    val aluguel = gamerBruno.alugaJogo(jogoRd2, periodo)

    println(aluguel)
}