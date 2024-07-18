package br.com.gamesinfo.servicos

import br.com.gamesinfo.modelo.Gamer
import br.com.gamesinfo.modelo.InfoGamerJson
import br.com.gamesinfo.modelo.InfoJogoJson
import br.com.gamesinfo.utilitarios.criaGamer
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse

class ConsumoAPI {

    private fun consumoBase(url: String): String {
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

    fun buscaJogo(id: String): String {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        return consumoBase(url)
    }

    fun buscaGamers(): List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = consumoBase(url)

        val gson = Gson()
        // aqui dizemos o tipo de dado que queremos retornar
        // de uma conversao
        val meuGamerTipo = object : TypeToken<List<InfoGamerJson>>() {}.type
        val listaInfoGamerJson: List<InfoGamerJson> = gson.fromJson(json, meuGamerTipo)

        val listaGamer =  listaInfoGamerJson.map {
            infoGamerJson -> infoGamerJson.criaGamer()
        }

        return listaGamer
    }

    fun buscaJogos(): List<InfoJogoJson> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"

        val json = consumoBase(url)

        val gson = Gson()
        // aqui dizemos o tipo de dado que queremos retornar
        // de uma conversao
        val meuJogoTipo = object : TypeToken<List<InfoJogoJson>>() {}.type
        val listaInfoJogoJson: List<InfoJogoJson> = gson.fromJson(json, meuJogoTipo)

        return listaInfoJogoJson
    }

}