import br.com.gamesinfo.modelo.Gamer

fun main() {
    val gamer1 = Gamer(
        "Pedrinho",
        "pedrinho.pedrinho@gmail.com"
    )
    println(gamer1)

    val gamer2 = Gamer(
        "Alfred",
        "alfred.alfred@gmail.com",
        "21/01/2005",
        "batafred"
    )
    println(gamer2)
 
    gamer1.let {
        it.dataNascimento = "01/01/2001"
        it.usuario = "drinhodripado"
        it.idInterno = "arroz-27292-askjdn"
    }
    println(gamer1)
}