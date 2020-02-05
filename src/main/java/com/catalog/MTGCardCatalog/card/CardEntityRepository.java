package com.catalog.MTGCardCatalog.card;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(path = "cards", collectionResourceRel = "cards")
public interface CardEntityRepository extends PagingAndSortingRepository<CardEntity, Long> {

    Optional<CardEntity> findById(long id);

    List<CardEntity> findAll();
}
