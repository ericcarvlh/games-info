package br.com.gamesinfo.dados.dao

import br.com.gamesinfo.dados.entity.JogoEntity
import br.com.gamesinfo.modelo.Jogo
import jakarta.persistence.EntityManager

class JogoDAO(private val manager: EntityManager?) {
    fun getJogos() : List<Jogo>? {
        val query = manager?.createQuery("FROM JogoEntity", JogoEntity::class.java)

        /* mapeia do entity para o jogo */
        return query?.resultList?.map { entity ->
            Jogo(
                entity.titulo,
                entity.capa,
                entity.preco,
                entity?.descricao,
                entity.id
            )
        }
    }

    fun adicionarJogo(jogo: Jogo) {
        val entity = JogoEntity(jogo.titulo, jogo.capa, jogo.preco, jogo.descricao)

        manager?.transaction?.begin()
        manager?.persist(entity)
        manager?.transaction?.commit()
    }
}