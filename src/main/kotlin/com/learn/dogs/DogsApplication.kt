package com.learn.dogs


import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication



@SpringBootApplication
class DogsApplication

fun main(args: Array<String>) {
    runApplication<DogsApplication>(*args)
}

