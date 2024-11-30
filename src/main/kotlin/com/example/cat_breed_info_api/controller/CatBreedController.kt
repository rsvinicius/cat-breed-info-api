package com.example.cat_breed_info_api.controller

import com.example.cat_breed_info_api.model.entity.Breed
import com.example.cat_breed_info_api.repository.specification.BreedSpecifications
import com.example.cat_breed_info_api.service.CatBreedService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/breeds")
class CatBreedController(private val catBreedService: CatBreedService) {
    @GetMapping
    fun getAllBreeds(specifications: BreedSpecifications): List<Breed> {
        return catBreedService.getAllBreeds(specifications)
    }

    @GetMapping("/{id}")
    fun getBreedById(@PathVariable id: String): Breed {
        return catBreedService.getBreedById(id)
    }
}