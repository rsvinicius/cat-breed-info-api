package com.example.cat_breed_info_api.controller

import com.example.cat_breed_info_api.model.dto.BreedDto
import com.example.cat_breed_info_api.repository.specification.BreedSpecifications
import com.example.cat_breed_info_api.service.CatBreedService
import mu.KotlinLogging
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/breeds")
class CatBreedController(private val catBreedService: CatBreedService) {
    private val logger = KotlinLogging.logger {}

    @GetMapping
    fun getAllBreeds(specifications: BreedSpecifications): List<BreedDto> {
        logger.info { "getAllBreeds: getting all breeds info" }
        return catBreedService.getAllBreeds(specifications).also {
            logger.info { "getAllBreeds: all breeds info got successfully" }
        }
    }

    @GetMapping("/{id}")
    fun getBreedById(@PathVariable id: String): BreedDto {
        logger.info { "getBreedById: getting breed info by id=$id" }
        return catBreedService.getBreedById(id).also {
            logger.info { "getBreedById: breed info got successfully, id=$id" }
        }
    }
}