package br.com.gamesinfo.modelo// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

data class Jogo(
    val titulo: String,
    val capa: String,
    val preco: Double,
    var descricao: String,
    val id: Int
) {
    override fun toString(): String {
        return "\ntitulo: $titulo\ncapa: $capa\ndescricao: $descricao\n"
    }
}