package br.com.gamesinfo.dados.entity

import jakarta.persistence.*

@Entity
@Table(name = "tbl_gamers")
class GamerEntity (
    val nome: String = "Nome default",
    val email: String = "Email default",
    val dataNascimento: String? = null,
    val usuario: String? = "Usuario default",
    @Id
    val idInterno: String = "usuario#tag"
) {

}