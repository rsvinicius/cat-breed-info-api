package com.example.cat_breed_info_api.client

import com.example.cat_breed_info_api.model.dto.BreedImageDto
import com.example.cat_breed_info_api.model.entity.Breed
import mu.KotlinLogging
import org.springframework.core.ParameterizedTypeReference
import org.springframework.stereotype.Component
import org.springframework.web.client.RestClient
import org.springframework.web.client.RestClientException

@Component
class TheCatApiClient(
    private val restClient: RestClient,
) {
    private val logger = KotlinLogging.logger {}

    fun fetchBreeds(): List<Breed> {
        return try {
            restClient.get()
                .uri("/v1/breeds/")
                .retrieve()
                .body(object : ParameterizedTypeReference<List<Breed>>() {})!!
        } catch (ex: RestClientException) {
            logger.warn {
                "fetchBreeds: Failed fetching breeds data from TheCatApi, " +
                        "message=${ex.message}"
            }
            throw ex
        } catch (ex: Exception) {
            logger.error(ex) {
                "fetchBreeds: Error fetching breeds data from TheCatApi, " +
                        "message=${ex.message}"
            }
            throw ex
        }
    }

    fun fetchBreedImages(id: String, limit: Int): List<BreedImageDto> {
        return try {
            restClient.get()
                .uri("v1/images/search?limit=${limit}&breed_ids=${id}")
                .retrieve()
                .body(object : ParameterizedTypeReference<List<BreedImageDto>>() {})!!
        } catch (ex: RestClientException) {
            logger.warn {
                "fetchBreedImages: Failed fetching breed images from TheCatApi, " +
                        "message=${ex.message}"
            }
            throw ex
        } catch (ex: Exception) {
            logger.error(ex) {
                "fetchBreedImages: Error fetching breed images from TheCatApi, " +
                        "message=${ex.message}"
            }
            throw ex
        }
    }
}
