package br.com.gamesinfo.modelo.plano

import br.com.gamesinfo.modelo.Aluguel

sealed class Plano(val tipo: String) {
    open fun obterValor(aluguel: Aluguel): Double {
        return aluguel.jogoJson.preco * aluguel.periodo.emDias
    }
}