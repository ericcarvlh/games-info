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

    var meuJogo:Jogo? = null
    val resultado = runCatching {
        val gson = Gson()
        val infoAPIShark = gson.fromJson(json, InfoAPIShark::class.java)

        meuJogo = Jogo(
            infoAPIShark.info.title,
            infoAPIShark.info.thumb
        )
    }

    resultado.onFailure {
        println("Erro ao instanciar o jogo.")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = sc.nextLine()
        if (opcao.equals("S", true)) {
            println("Insira a descrição personalizada: ")
            val descricaoPersonalizada = sc.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            println("")
            meuJogo?.descricao = meuJogo?.titulo
        }

        print(meuJogo)
    }
}