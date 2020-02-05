package com.catalog.MTGCardCatalog.card;

import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Optional;

@RepositoryRestResource(path = "cards", collectionResourceRel = "cards")
public interface CardEntityRepository extends PagingAndSortingRepository<CardEntity, Long>, QuerydslPredicateExecutor<CardEntity> {

    Optional<CardEntity> findById(long id);
}
