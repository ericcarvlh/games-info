package br.com.gamesinfo.principal

import br.com.gamesinfo.dados.Banco

fun main() {
    val conexao = Banco.obterConexao()

    println(conexao)
}