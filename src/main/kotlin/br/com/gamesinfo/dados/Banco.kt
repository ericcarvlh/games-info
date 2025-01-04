package br.com.gamesinfo.dados

import jakarta.persistence.EntityManager
import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

// diz que so temos um objeto na classe banco -> mais conhecido como singleton
object Banco {
    fun getEntityManager(): EntityManager? {
        return try {
            return Persistence.createEntityManagerFactory(
                "alugames"
            ).createEntityManager()
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}