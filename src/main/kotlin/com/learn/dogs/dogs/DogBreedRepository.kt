package com.learn.dogs.dogs

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.kotlin.CoroutineCrudRepository
import org.springframework.data.repository.query.Param

interface DogBreedRepository : CoroutineCrudRepository<DogBreed, String> {

    @Query("""
        SELECT * FROM DOG JOIN DOG_BREED_TYPE ON DOG.id = DOG_BREED_TYPE.breed_id ORDER BY DOG.name
    """)
    suspend fun findAllDogs(): Iterable<DogBreed>?

    @Query("""
        SELECT * FROM DOG JOIN DOG_BREED_TYPE ON DOG.id = DOG_BREED_TYPE.breed_id WHERE DOG.id=:id ORDER BY DOG.name
    """)
    suspend fun findById(@Param("id") id: Long): DogBreed?
}