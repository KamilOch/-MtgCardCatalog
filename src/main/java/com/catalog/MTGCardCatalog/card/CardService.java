package com.catalog.MTGCardCatalog.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CardService {

    private CardEntityRepository cardEntityRepository;

    @Autowired
    public CardService(CardEntityRepository cardEntityRepository) {
        this.cardEntityRepository = cardEntityRepository;
    }

    public void addCard(String name) {
        CardEntity newCard = CardEntity.builder().name(name).build();
        cardEntityRepository.save(newCard);
    }

    public List<CardEntity> getAllCards() {
        return cardEntityRepository.findAll().stream()
                .map(it -> new CardEntity(it.getId(), it.getName())).collect(Collectors.toList());
    }

    public CardEntity findById(long id) {
        return cardEntityRepository.findById(id).orElseThrow(IllegalArgumentException::new);
    }

    public void editCard(long id, String name) {
        CardEntity editedCard = findById(id);
        editedCard.setName(name);
        cardEntityRepository.save(editedCard);
    }

    public void deleteCardById(int id) {
        CardEntity deletedCard = findById(id);
        cardEntityRepository.delete(deletedCard);
    }
}
