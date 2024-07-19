package br.com.gamesinfo.modelo

import java.time.LocalDate
import java.time.Period

data class Aluguel(
    val gamer: Gamer,
    val jogoJson: InfoJogoJson,
    val dataInicial: LocalDate,
    val dataFinal: LocalDate
) {
    val vlrAluguel = jogoJson.preco * Period.between(dataInicial, dataFinal).days

    override fun toString(): String {
        return "Aluguel do jogo ${jogoJson.titulo} por ${gamer.nome} por um valor de $vlrAluguel"
    }
}
