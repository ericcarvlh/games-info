package br.com.gamesinfo.modelo

data class InfoAPIShark(
   val info: InfoGameAPIShark
) {
    override fun toString(): String {
        return info.toString()
    }
}