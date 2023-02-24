package com.learn.dogs.dogs

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.Transient

@Table("DOG_BREED")
data class DogBreed (

    @Id @JsonProperty("id") val id: Long,
    @JsonProperty("name") val name: String,
    @JsonProperty("dog_breed_type") @Transient val dogBreedTypes:List<DogBreedType>? = null
        )

