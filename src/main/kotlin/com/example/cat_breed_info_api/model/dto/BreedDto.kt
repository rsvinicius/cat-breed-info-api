package com.example.cat_breed_info_api.model.dto

import com.example.cat_breed_info_api.model.entity.Breed

data class BreedDto(
    val id: String,
    val name: String,
    val origin: String?,
    val temperament: String?,
    val description: String?,
    val images: List<String>?
) {
    companion object {
        fun fromBreed(breed: Breed): BreedDto {
            return BreedDto(
                id = breed.id,
                name = breed.name,
                origin = breed.origin,
                temperament = breed.temperament,
                description = breed.description,
                images = null
            )
        }

        fun fromBreedAndBreedImages(breed: Breed, images: List<String>): BreedDto {
            return BreedDto(
                id = breed.id,
                name = breed.name,
                origin = breed.origin,
                temperament = breed.temperament,
                description = breed.description,
                images = images
            )
        }
    }
}