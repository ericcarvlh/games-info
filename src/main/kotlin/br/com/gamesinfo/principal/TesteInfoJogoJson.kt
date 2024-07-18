package br.com.gamesinfo.principal

import br.com.gamesinfo.servicos.ConsumoAPI

fun main() {
    val consumo = ConsumoAPI()
    val jogos = consumo.buscaJogos()

    println(jogos)
}