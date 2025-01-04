package br.com.gamesinfo.dados.dao

import br.com.gamesinfo.dados.Banco
import br.com.gamesinfo.modelo.Jogo

class JogoDAO {

//    fun getJogos(): List<Jogo> {
//        val listaJogos = mutableListOf<Jogo>()
//
//        Banco.obterConexao()?.use { conexao ->
//            val statement = conexao.createStatement()
//
//            val resultado = statement.executeQuery("select * from tbl_jogos")
//
//            while (resultado.next()) {
//                val id = resultado.getInt("id")
//                val capa = resultado.getString("capa")
//                val descricao = resultado.getString("descricao")
//                val preco = resultado.getDouble("preco")
//                val titulo = resultado.getString("titulo")
//
//                val jogo = Jogo(titulo, capa, preco, descricao, id)
//
//                listaJogos.add(jogo)
//            }
//
//            statement.close()
//
//            conexao.close()
//        }
//
//        return listaJogos
//    }
//
//    fun adicionaJogo(jogo: Jogo) {
//        Banco.obterConexao()?.use { conexao ->
//            val insert = "Insert Into tbl_jogos (capa, descricao, preco, titulo) VALUES (?, ?, ?, ?)"
//
//            val statement = conexao.prepareStatement(insert)
//
//            // começa a partir do 1, nao do 0
//            statement.setString(1, jogo.capa)
//            statement.setString(2, jogo.descricao)
//            statement.setDouble(3, jogo.preco)
//            statement.setString(4, jogo.titulo)
//
//            statement.execute()
//
//            statement.close()
//
//            conexao.close()
//        }
//    }

    fun getJogos() : MutableList<Jogo>? {
        val manager = Banco.getEntityManager()

        try {
            val query = manager?.createQuery("FROM Jogo", Jogo::class.java)
            return query?.resultList
        } finally {
            manager?.close()
        }
    }
}