package com.example.cat_breed_info_api.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class Breed(
    @Id val id: String,
    val name: String,
    val origin: String?,
    val temperament: String?,
    @Column(length = 2000) val description: String?
)