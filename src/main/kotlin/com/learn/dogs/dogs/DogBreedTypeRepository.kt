package com.learn.dogs.dogs

import org.springframework.data.repository.kotlin.CoroutineCrudRepository

interface DogBreedTypeRepository  : CoroutineCrudRepository<DogBreedType, String> {
}