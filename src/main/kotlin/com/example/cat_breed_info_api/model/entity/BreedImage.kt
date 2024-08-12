package com.example.cat_breed_info_api.model.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id

@Entity
data class BreedImage(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) val id: Long = 0,
    val breedId: String,
    val imageUrl: String
)