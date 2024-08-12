package com.example.cat_breed_info_api.controller

import com.example.cat_breed_info_api.model.entity.Breed
import com.example.cat_breed_info_api.repository.BreedRepository
import com.example.cat_breed_info_api.repository.specification.BreedSpecifications
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/breeds")
class CatBreedController(private val breedRepository: BreedRepository) {
    @GetMapping
    fun getAllBreeds(
        @RequestParam(required = false) temperament: String?,
        @RequestParam(required = false) origin: String?
    ): List<Breed> {
        val filters = BreedSpecifications.withFilters(temperament, origin)
        return breedRepository.findAll(filters)
    }

    @GetMapping("/{id}")
    fun getBreedById(@PathVariable id: String): Breed {
        return breedRepository.findById(id).orElseThrow { throw NotFoundException() }
    }
}