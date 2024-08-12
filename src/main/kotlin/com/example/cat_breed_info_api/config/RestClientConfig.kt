package com.example.cat_breed_info_api.config

import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.web.client.RestClient

@Configuration
class RestClientConfig(
    @Value("\${api-key.the-cat-api}")
    private val theCatApiKey: String
) {
    @Bean
    fun restClient(): RestClient {
        return RestClient.builder()
            .baseUrl("https://api.thecatapi.com/")
            .defaultHeaders { httpHeaders: HttpHeaders ->
                httpHeaders["x-api-key"] = theCatApiKey
            }
            .build()
    }
}