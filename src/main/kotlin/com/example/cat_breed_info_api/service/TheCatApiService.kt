package com.example.cat_breed_info_api.service

import com.example.cat_breed_info_api.client.TheCatApiClient
import com.example.cat_breed_info_api.model.entity.BreedImage
import com.example.cat_breed_info_api.repository.BreedImageRepository
import com.example.cat_breed_info_api.repository.BreedRepository
import org.springframework.stereotype.Service

private const val BREED_IMAGES_LIMIT = 3

@Service
class TheCatApiService(
    private val theCatApiClient: TheCatApiClient,
    private val breedRepository: BreedRepository,
    private val breedImageRepository: BreedImageRepository
) {
    fun initializeData() {
        if (breedRepository.count() == 0L) {
            saveBreeds()
        }
    }

    private fun saveBreeds() {
        val breeds = theCatApiClient.fetchBreeds()

        breedRepository.saveAll(breeds)

        breeds.forEach { saveBreedsImages(it.id) }
    }

    private fun saveBreedsImages(breedId: String) {
        val fetchBreedImages = theCatApiClient.fetchBreedImages(breedId, BREED_IMAGES_LIMIT)
        breedImageRepository.saveAll(
            fetchBreedImages.map { BreedImage(0, breedId, it.url) }
        )
    }
}