package br.com.gamesinfo.modelo// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

data class Jogo(
    val titulo: String,
    val capa: String
) {
    var descricao:String? = null

    override fun toString(): String {
        return "\ntitulo: $titulo\ncapa: $capa\ndescricao: $descricao\n"
    }
}