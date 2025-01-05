package br.com.gamesinfo.dados.dao

import br.com.gamesinfo.dados.entity.GamerEntity
import br.com.gamesinfo.dados.entity.JogoEntity
import br.com.gamesinfo.modelo.Gamer
import jakarta.persistence.EntityManager

class GamerDAO(private val manager: EntityManager?) {
    fun getGamers(): List<Gamer>? {
        val query = manager?.createQuery("FROM GamerEntity", GamerEntity::class.java)

        return query?.resultList?.map {  entity ->
            Gamer(
                entity.nome,
                entity.email,
                entity?.dataNascimento,
                entity?.usuario,
                entity.idInterno
            )
        }
    }

    fun adicionaGamer(gamer: Gamer) {
        val entity = GamerEntity(gamer.nome, gamer.email, gamer.dataNascimento, gamer.usuario, gamer.idInterno)

        manager?.transaction?.begin()
        manager?.persist(entity)
        manager?.transaction?.commit()
    }
}