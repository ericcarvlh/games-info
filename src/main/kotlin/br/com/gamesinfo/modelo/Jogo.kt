package br.com.gamesinfo.modelo// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

data class Jogo(
    var titulo: String,
    var capa: String,
    var preco: Double,
    var descricao: String
) {
    private var id:Int? = null

    override fun toString(): String {
        return "\nid: $id\ntitulo: $titulo\ncapa: $capa\npreço: $preco\ndescricao: $descricao\n"
    }

    constructor(
        titulo: String,
        capa: String,
        preco: Double,
        descricao: String,
        id: Int
    ) : this(titulo, capa, preco, descricao) {
        this.descricao = descricao
        this.capa = capa
        this.preco = preco
        this.id = id
    }
}