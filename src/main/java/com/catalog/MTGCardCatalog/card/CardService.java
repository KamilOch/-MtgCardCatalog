package com.catalog.MTGCardCatalog.card;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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
        //TODO
      //  return cardEntityRepository.findAll().stream().map(it -> new CardEntity(it.getId(),it.getName())).collect(Collectors.toList());

        List<CardEntity> testList = new ArrayList<>();
        testList.add(CardEntity.builder().name("testCard1").build());
        testList.add(CardEntity.builder().name("testCard2").build());
        testList.add(CardEntity.builder().name("testCard3").build());

        cardEntityRepository.saveAll(testList);
        return testList;
    }
}
