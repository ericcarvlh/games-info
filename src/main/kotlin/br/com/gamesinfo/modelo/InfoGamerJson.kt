package br.com.gamesinfo.modelo

data class InfoGamerJson(
    val nome: String,
    val email: String,
    val dataNascimento: String,
    val usuario: String
) {
    var idInterno:String? = null

}