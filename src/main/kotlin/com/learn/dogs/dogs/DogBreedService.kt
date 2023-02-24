package com.learn.dogs.dogs

interface DogBreedService {
    suspend fun findAll(): Iterable<DogBreed>?

    suspend fun findById(dogId: Long): DogBreed?

    suspend fun post(dogBreed: Map<String,Array<String>>)
}