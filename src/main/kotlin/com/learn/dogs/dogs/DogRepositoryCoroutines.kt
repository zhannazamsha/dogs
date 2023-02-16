package com.learn.dogs.dogs

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.reactive.asFlow
import kotlinx.coroutines.reactive.awaitFirstOrNull
import org.springframework.data.r2dbc.core.DatabaseClient
import org.springframework.data.r2dbc.core.asType
import org.springframework.stereotype.Repository


@Repository
class DogRepositoryCoroutines(private val client: DatabaseClient) {
    suspend fun getDogById(id: Int): Dog? =
        client.execute("SELECT * FROM dog WHERE id = $1")
            .bind(0, id)
            .asType<Dog>()
            .fetch()
            .one()
            .awaitFirstOrNull()

    suspend fun addNewDog(name: String) =
        client.execute("INSERT INTO dog (name) VALUES($1)")
            .bind(0, name)
            .then()
            .awaitFirstOrNull()

    @FlowPreview
    fun getAllDogs(): Flow<Dog> =
        client.select()
            .from("products")
            .`as`(Dog::class.java)
            .fetch()
            .all()
            .asFlow()
}