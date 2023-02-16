package com.learn.dogs.dogs

import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.reactive.function.client.WebClient

@RestController
class DogsController {
    @Autowired
    lateinit var webClient: WebClient

    @Autowired
    lateinit var dogRepository: DogRepositoryCoroutines

    @GetMapping("/{id}")
    suspend fun findOne(@PathVariable id: Int): Dog? {
        return dogRepository.getDogById(id)
    }

    @FlowPreview
    @GetMapping("/")
    fun findAll(): Flow<Dog> {
        return dogRepository.getAllDogs()
    }
}