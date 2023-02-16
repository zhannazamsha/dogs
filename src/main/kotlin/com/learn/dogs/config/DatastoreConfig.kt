package com.learn.dogs.config

import io.r2dbc.h2.H2ConnectionConfiguration
import io.r2dbc.h2.H2ConnectionFactory
import io.r2dbc.spi.ConnectionFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@Configuration
@EnableR2dbcRepositories
class DatastoreConfig : AbstractR2dbcConfiguration() {
    @Value("\${spring.r2dbc.name}")
    private val userName: String = ""

    @Value("\${spring.r2dbc.password}")
    private val password: String = ""

    @Value("\${spring.r2dbc.url}")
    private val dbName: String = ""

    @Bean
    override fun connectionFactory(): ConnectionFactory {
        return H2ConnectionFactory(
            H2ConnectionConfiguration.builder()
            .inMemory(dbName)
            .username(userName)
            .password(password)
            .build())
    }
}