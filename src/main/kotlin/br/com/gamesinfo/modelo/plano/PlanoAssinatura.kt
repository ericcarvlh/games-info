package br.com.gamesinfo.modelo.plano

import br.com.gamesinfo.modelo.Aluguel

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int,
    val percentualDescontoReputcacao: Double
): Plano(tipo) {
    override fun obterValor(aluguel: Aluguel): Double {
        val totalJogosNoMes = aluguel.gamer.jogosDoMes(aluguel.periodo.dataInicial.monthValue).size + 1 // +1 pois o utlimo add nao eh levado em consideracao

        return if (totalJogosNoMes > jogosIncluidos) {
            var valorOriginal = super.obterValor(aluguel)
            if (aluguel.gamer.mediaNotas > 8)
                valorOriginal -= (valorOriginal * percentualDescontoReputcacao)
            valorOriginal
        }
        else
            0.0
    }
}
