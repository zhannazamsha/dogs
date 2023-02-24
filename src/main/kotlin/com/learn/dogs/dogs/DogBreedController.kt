package com.learn.dogs.dogs


import org.springframework.web.bind.annotation.*

@RestController
class DogBreedController (val dogBreedService: DogBreedService){
    @GetMapping("/")
    suspend fun all(): Iterable<DogBreed>? {
        return dogBreedService.findAll()
    }

    @GetMapping("/{id}")
    suspend fun find(@PathVariable id: Long): DogBreed? {
        return dogBreedService.findById(id)
    }

    @PostMapping("/")
    suspend fun post(@RequestBody dogBreed: Map<String,Array<String>>) {
        dogBreedService.post(dogBreed)
        }

    }
