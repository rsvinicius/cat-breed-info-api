package com.example.cat_breed_info_api.service

import com.example.cat_breed_info_api.model.entity.Breed
import com.example.cat_breed_info_api.repository.BreedRepository
import com.example.cat_breed_info_api.repository.specification.BreedSpecifications
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class CatBreedService(private val breedRepository: BreedRepository) {
    fun getAllBreeds(specifications: BreedSpecifications): List<Breed> {
        return breedRepository.findAll(specifications)
    }

    fun getBreedById(id: String): Breed {
        return breedRepository.findById(id).orElseThrow { throw NotFoundException() }
    }
}