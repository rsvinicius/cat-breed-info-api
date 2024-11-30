package com.example.cat_breed_info_api.service

import com.example.cat_breed_info_api.model.dto.BreedDto
import com.example.cat_breed_info_api.repository.BreedImageRepository
import com.example.cat_breed_info_api.repository.BreedRepository
import com.example.cat_breed_info_api.repository.specification.BreedSpecifications
import mu.KotlinLogging
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException
import org.springframework.stereotype.Service

@Service
class CatBreedService(
    private val breedRepository: BreedRepository,
    private val breedImageRepository: BreedImageRepository
) {
    private val logger = KotlinLogging.logger {}

    fun getAllBreeds(specifications: BreedSpecifications): List<BreedDto> {
        val breeds = breedRepository.findAll(specifications)
        return breeds.map { BreedDto.fromBreed(it) }
    }

    fun getBreedById(id: String): BreedDto {
        val breed = breedRepository.findById(id).orElseThrow {
            logger.error { "getBreedById: breed not found, id=$id" }
            throw NotFoundException()
        }
        val images = breedImageRepository.findAllByBreedId(id).map { it.imageUrl }
        return BreedDto.fromBreedAndBreedImages(breed, images)
    }
}