package com.example.cat_breed_info_api.repository

import com.example.cat_breed_info_api.model.entity.BreedImage
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BreedImageRepository : JpaRepository<BreedImage, Long>