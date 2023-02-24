package com.learn.dogs

import com.learn.dogs.dogs.DogBreed
import com.learn.dogs.dogs.DogBreedRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.core.ParameterizedTypeReference
import org.springframework.http.HttpMethod
import org.springframework.http.RequestEntity
import java.net.URI
import java.time.Instant

@SpringBootTest(
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
    properties = [
        "spring.datasource.url=jdbc:h2:mem:testdb"
    ]
)
class DogsApplicationTests {

    @Autowired
    lateinit var client: TestRestTemplate

    @Autowired
    lateinit var dogBreedRepository: DogBreedRepository

    val now: Instant = Instant.now()

    @BeforeEach
    fun setUp() {
        val secondBeforeNow = now.minusSeconds(1)
        val twoSecondBeforeNow = now.minusSeconds(2)
        val savedMessages = dogBreedRepository.saveAll(listOf(
            DogBreed(
                1,
                "affenpinscher"
            ),
            DogBreed(
                2,
                "african"
            ),
            DogBreed(
                3,
                "akita"
            )
        ))
        val dogId = 1
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `test that gods API returns dog by id`(withDogId: Boolean) {
        val dogBreed: DogBreed? = client.exchange(
            RequestEntity<Any>(
                HttpMethod.GET,
                URI("/api/v1/messages?lastMessageId=${if (withDogId) 1 else null}")
            ),
            object : ParameterizedTypeReference<DogBreed>() {}).body

        if (!withDogId) {
            assertThat(dogBreed)
                .isEqualTo(null
                )
        }


    }


    @Test
    fun `test that dog posted to the API is stored`() {

      /*  client.postForEntity<Any>(
            /* url = */ URI("/api/v1/dog"),
            /* request = */ Dog(
                4,
                "appenzeller"
            ),
            /* responseType = */ Dog::class
        )



        dogRepository.findAll()
            .first { it.name.contains("appenzeller") }
            .apply {
                assertThat(this)
                    .isEqualTo(Dog(
                        4,
                        "appenzeller"
                    ))
            }*/
    }

    @AfterEach
    fun tearDown() {
       // dogBreedRepository.deleteAll()
    }

}
