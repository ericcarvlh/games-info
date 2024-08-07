package br.com.gamesinfo.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogoJson: InfoJogoJson,
    val periodo: Periodo
) {
    val vlrAluguel = gamer.plano.obterValor(this)

    override fun toString(): String {
        return "Aluguel do jogo ${jogoJson.titulo} por ${gamer.nome} por um valor de R$ $vlrAluguel"
    }
}
