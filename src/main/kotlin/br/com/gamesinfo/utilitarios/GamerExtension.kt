package br.com.gamesinfo.utilitarios

import br.com.gamesinfo.modelo.Gamer
import br.com.gamesinfo.modelo.InfoGamerJson

fun InfoGamerJson.criaGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}