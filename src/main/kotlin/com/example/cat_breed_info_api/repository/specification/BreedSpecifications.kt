package com.example.cat_breed_info_api.repository.specification

import com.example.cat_breed_info_api.model.entity.Breed
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

data class BreedSpecifications(
    val temperament: String?,
    val origin: String?
) : Specification<Breed> {

    override fun toPredicate(
        root: Root<Breed>,
        query: CriteriaQuery<*>?,
        criteriaBuilder: CriteriaBuilder
    ): Predicate {
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

        return criteriaBuilder.and(*predicates.toTypedArray())
    }
}