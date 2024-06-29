// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

class Jogo(val titulo:String, val capa: String) {
    var descricao = ""

    override fun toString(): String {
        return "\ntitulo: $titulo\ncapa: $capa\ndescricao: $descricao\n"
    }
}