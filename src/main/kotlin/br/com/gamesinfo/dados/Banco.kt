package br.com.gamesinfo.dados

import br.com.gamesinfo.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

// diz que so temos um objeto na classe banco -> mais conhecido como singleton
object Banco {
    private fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/db_alugames", "root", "")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }

    fun getJogos(): List<Jogo> {
        val listaJogos = mutableListOf<Jogo>()
        val conexao = obterConexao()

        if (conexao != null) {
            try {
                val statement = conexao.createStatement()

                val resultado = statement.executeQuery("select * from tbl_jogos")

                while (resultado.next()) {
                    val id = resultado.getInt("id")
                    val capa = resultado.getString("capa")
                    val descricao = resultado.getString("descricao")
                    val preco = resultado.getDouble("preco")
                    val titulo = resultado.getString("titulo")

                    val jogo = Jogo(titulo, capa, preco, descricao, id)

                    listaJogos.add(jogo)
                }

                statement.close()
            } finally {
                conexao.close()
            }
        }

        return listaJogos
    }
}