package br.com.gamesinfo.modelo

data class Aluguel(
    val gamer: Gamer,
    val jogoJson: InfoJogoJson
) {
    override fun toString(): String {
        return "Aluguel do jogo ${jogoJson.titulo} por ${gamer.nome}"
    }
}
