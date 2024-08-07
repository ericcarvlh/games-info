package br.com.gamesinfo.principal

import br.com.gamesinfo.modelo.Periodo
import br.com.gamesinfo.modelo.PlanoAssinatura
import br.com.gamesinfo.servicos.ConsumoAPI
import java.time.LocalDate
import kotlin.math.round

fun main() {
    val consumo = ConsumoAPI()
    val gamers = consumo.buscaGamers()
    val jogos = consumo.buscaJogos()

    val gamerBruno = gamers[4]
    val jogoRd2 = jogos[3]
    val jogoResidentVillage = jogos[10]
    val jogoSpider = jogos[13]
    val jogoTheLastOfUs2 = jogos[2]

    val periodo = Periodo(LocalDate.now(), LocalDate.now().plusDays(5))
    gamerBruno.alugaJogo(jogoRd2, periodo)
    gamerBruno.alugaJogo(jogoResidentVillage, periodo)
    gamerBruno.alugaJogo(jogoSpider, periodo)
    gamerBruno.alugaJogo(jogoTheLastOfUs2, periodo)

    println(gamerBruno.jogosAlugados)

    var vlrTotalAluguel = 0.0
    gamerBruno.jogosAlugados.forEach{
        vlrTotalAluguel += it.vlrAluguel
    }
    println("Valor total do aluguel: R$ ${round(vlrTotalAluguel)}")

    val gamerCamila = gamers.get(5)
    gamerCamila.plano = PlanoAssinatura("PRATA", 9.90, 3)

    gamerCamila.alugaJogo(jogoRd2, periodo)
    gamerCamila.alugaJogo(jogoSpider, periodo)
    gamerCamila.alugaJogo(jogoResidentVillage, periodo)
    gamerCamila.alugaJogo(jogoTheLastOfUs2, periodo)
    println(gamerCamila.jogosAlugados)
}