package br.com.gamesinfo.modelo

open class Plano(val tipo: String) {
    fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogoJson.preco * aluguel.periodo.emDias
    }
}