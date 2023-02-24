package com.learn.dogs.dogs

import com.fasterxml.jackson.annotation.JsonProperty
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Table("DOG_BREED_TYPE")
data class DogBreedType (
    @Id
    @JsonProperty("id") val id: Long,

    @JsonProperty("name")
    val name: String,

    var breed: Long? = null


)