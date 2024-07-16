package br.com.gamesinfo.servicos

import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoAPI {

    fun buscaJogo(id: String): String? {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder(
        ).uri(
            URI.create(url)
        ).build()

        val response = client.send(
            request, HttpResponse.BodyHandlers.ofString()
        )

        return response.body()
    }
}