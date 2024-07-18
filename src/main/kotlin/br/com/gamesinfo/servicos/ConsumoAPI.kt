package br.com.gamesinfo.servicos

import br.com.gamesinfo.modelo.InfoGamerJson
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
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

    fun buscaGamers(): List<InfoGamerJson> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder(
        ).uri(
            URI.create(url)
        ).build()

        val response = client.send(
            request, HttpResponse.BodyHandlers.ofString()
        )

        val json = response.body()

        val gson = Gson()
        // aqui dizemos o tipo de dado que queremos retornar
        // de uma conversao
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type

        return gson.fromJson(json, meuGamerTipo)
    }
}