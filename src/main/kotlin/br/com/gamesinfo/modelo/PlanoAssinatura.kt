package br.com.gamesinfo.modelo

class PlanoAssinatura(
    tipo: String,
    val mensalidade: Double,
    val jogosIncluidos: Int
): Plano(tipo) {

}
