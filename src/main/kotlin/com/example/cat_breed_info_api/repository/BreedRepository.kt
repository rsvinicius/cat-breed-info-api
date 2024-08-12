package com.example.cat_breed_info_api.repository

import com.example.cat_breed_info_api.model.entity.Breed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository

@Repository
interface BreedRepository : JpaRepository<Breed, String>, JpaSpecificationExecutor<Breed>
