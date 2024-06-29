import com.google.gson.annotations.SerializedName

// Val -> somente leitura, recebem valore apenas uma vez
// Var -> !val

class Jogo(
    @SerializedName("title") val titulo:String,
    @SerializedName("thumb") val capa: String
) {
    var descricao = ""

    override fun toString(): String {
        return "\ntitulo: $titulo\ncapa: $capa\ndescricao: $descricao\n"
    }
}