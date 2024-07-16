import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import java.lang.NullPointerException
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers
import java.util.Scanner


fun main() {
    val sc = Scanner(System.`in`)

    println("Digite um codigo de jogo para buscar: ")
    val codigoJogo = sc.nextLine()

    val url = "https://www.cheapshark.com/api/1.0/games?id=$codigoJogo"

    val client: HttpClient = HttpClient.newHttpClient()
    val request = HttpRequest.newBuilder(
    ).uri(
        URI.create(url)
    ).build()

    val response = client.send(
        request, BodyHandlers.ofString()
    )

    val json = response.body()

    try {
        val gson = Gson()
        val infoAPIShark = gson.fromJson(json, InfoAPIShark::class.java)

        val meuJogo = Jogo(
            infoAPIShark.info.title,
            infoAPIShark.info.thumb
        )

        print(meuJogo)
    }
    catch (ex: JsonSyntaxException) {
        println("Erro ao lidar com o json! Id: $codigoJogo\nExceção gerada: ${ex.message}.")
    }
}