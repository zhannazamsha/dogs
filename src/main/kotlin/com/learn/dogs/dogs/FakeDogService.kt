package com.learn.dogs.dogs


import org.springframework.stereotype.Service
import kotlin.random.Random

@Service
class FakeDogService : DogBreedService {

    val dogs: Map<String, DogBreed> = mapOf(
        "Shakespeare"  to DogBreed(1,"Shakespeare",  mutableListOf(DogBreedType(1,"test" ))),
        "RickAndMorty" to DogBreed(2,"RickAndMorty",  mutableListOf(DogBreedType(2,"test" ))),
        "Yoda"         to DogBreed(3, "Yoda",  mutableListOf(DogBreedType(3,"test" )))
    )



    override suspend fun findAll(): List<DogBreed> {
        val count = Random.nextInt(1, 15)
        return (0..count).map {
            val dog = dogs.values.random()
            DogBreed(1, dog.name,dog.dogBreedTypes)
        }.toList()
    }

    override suspend fun findById(dogId: Long): DogBreed {
        return findAll().get(dogId.toInt() - 1)
    }

    override suspend fun post(dogBreed: Map<String, Array<String>>) {
        TODO("Not yet implemented")
    }

}