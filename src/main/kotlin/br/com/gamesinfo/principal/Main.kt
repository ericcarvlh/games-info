package br.com.gamesinfo.principal

import br.com.gamesinfo.modelo.InfoAPIShark
import br.com.gamesinfo.modelo.Jogo
import br.com.gamesinfo.servicos.ConsumoAPI
import com.google.gson.Gson
import java.util.*

fun main() {
    val sc = Scanner(System.`in`)

    println("Digite um codigo de jogo para buscar: ")
    val codigoJogo = sc.nextLine()

    val buscaAPI = ConsumoAPI()

    var meuJogo: Jogo? = null
    val resultado = runCatching {
        val gson = Gson()
        val infoAPIShark = gson.fromJson(buscaAPI.buscaJogo(codigoJogo), InfoAPIShark::class.java)

        meuJogo = Jogo(
            infoAPIShark.info.title,
            infoAPIShark.info.thumb
        )
    }

    resultado.onFailure {
        println("Erro ao instanciar o jogo. Erro: ${resultado.exceptionOrNull()?.message}")
    }

    resultado.onSuccess {
        println("Deseja inserir uma descrição personalizada? S/N")
        val opcao = sc.nextLine()
        if (opcao.equals("S", true)) {
            println("Insira a descrição personalizada: ")
            val descricaoPersonalizada = sc.nextLine()
            meuJogo?.descricao = descricaoPersonalizada
        } else {
            meuJogo?.descricao = meuJogo?.titulo
        }

        print(meuJogo)
    }
}