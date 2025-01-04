package br.com.gamesinfo.dados

import jakarta.persistence.*

/*
* Objetivo: Classe criada para mapear a entidade jogo do banco de dados
* Para o hibernate podemos deixar valores Nulos, Opcionais ou default
* */

// sinaliza que eh uma entidade do hibernate
@Entity
// sinaliza qual tabela esta sendo referenciada
@Table(name = "tbl_jogos")
class JogoEntity(
    val titulo: String = "Default titulo",
    val capa: String = "Default capa",
    val preco: Double = 0.0,
    val descricao: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {
    /*
        o atributo Id eh a PK
        GeneratedValue value indica que eh gerado automaticamente
    */
}