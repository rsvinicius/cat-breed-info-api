package com.example.cat_breed_info_api.controller

import com.example.cat_breed_info_api.model.entity.Breed
import com.example.cat_breed_info_api.service.CatBreedService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/breeds")
class CatBreedController(private val catBreedService: CatBreedService) {
    @GetMapping
    fun getAllBreeds(
        @RequestParam(required = false) temperament: String?,
        @RequestParam(required = false) origin: String?
    ): List<Breed> {
        return catBreedService.getAllBreeds(temperament, origin)
    }

    @GetMapping("/{id}")
    fun getBreedById(@PathVariable id: String): Breed {
        return catBreedService.getBreedById(id)
    }
}