package br.com.gamesinfo.dados

import br.com.gamesinfo.modelo.Jogo
import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

// diz que so temos um objeto na classe banco -> mais conhecido como singleton
object Banco {
    fun obterConexao(): Connection? {
        return try {
            DriverManager.getConnection("jdbc:mysql://localhost:3306/db_alugames", "root", "")
        } catch (e: SQLException) {
            e.printStackTrace()
            null
        }
    }
}