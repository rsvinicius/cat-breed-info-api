package com.example.cat_breed_info_api.config

import com.example.cat_breed_info_api.service.TheCatApiService
import org.springframework.boot.ApplicationRunner
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DataLoader(private val theCatApiService: TheCatApiService) {

    @Bean
    fun loadData() = ApplicationRunner {
        theCatApiService.initializeData()
    }
}