package br.com.gamesinfo.dados

import jakarta.persistence.EntityManagerFactory
import jakarta.persistence.Persistence

// diz que so temos um objeto na classe banco -> mais conhecido como singleton
object Banco {
    fun getEntityManager(): EntityManagerFactory? {
        return try {
            return Persistence.createEntityManagerFactory(
                "db_alugames"
            )
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
    }
}