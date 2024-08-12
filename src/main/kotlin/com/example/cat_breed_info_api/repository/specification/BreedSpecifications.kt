package com.example.cat_breed_info_api.repository.specification

import com.example.cat_breed_info_api.model.entity.Breed
import jakarta.persistence.criteria.Predicate
import org.springframework.data.jpa.domain.Specification

class BreedSpecifications {

    companion object {
        fun withFilters(
            temperament: String?,
            origin: String?
        ): Specification<Breed> {
            return Specification { root, _, criteriaBuilder ->
                val predicates = mutableListOf<Predicate>()

                temperament?.let {
                    predicates.add(
                        criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("temperament")), "%${it.lowercase()}%"
                        )
                    )
                }

                origin?.let {
                    predicates.add(
                        criteriaBuilder.like(
                            criteriaBuilder.lower(root.get("origin")), "%${it.lowercase()}%"
                        )
                    )
                }

                criteriaBuilder.and(*predicates.toTypedArray())
            }
        }
    }
}