package br.com.gamesinfo.modelo

import jakarta.persistence.*

// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

// sinaliza que eh uma entidade do hibernate
@Entity
// sinaliza qual tabela esta sendo referenciada
@Table (name = "tbl_jogos")
class Jogo() {
    /*
        o atributo Id eh a PK
        GeneratedValue value indica que eh gerado automaticamente
    */
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private var id:Int? = null
    var titulo: String? = null
    var capa: String? = null
    var preco: Double? = null
    var descricao: String? = null

    override fun toString(): String {
        return "\nid: $id\ntitulo: $titulo\ncapa: $capa\npreço: $preco\ndescricao: $descricao\n"
    }

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String,
        id: Int
    ) : this() {
        this.titulo = titulo
        this.descricao = descricao
        this.capa = capa
        this.preco = preco
        this.id = id
    }
}