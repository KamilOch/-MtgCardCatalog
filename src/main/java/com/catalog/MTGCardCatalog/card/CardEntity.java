package com.catalog.MTGCardCatalog.card;

import javax.persistence.*;

@Entity
@Table(name = "card")
@SequenceGenerator(name = "CARD_SEQ", sequenceName = "card_id_seq", allocationSize = 1)
public class CardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_SEQ")
    @Column(name = "id")
    private long id;

    @Column( name = "name")
    private String name;


}
