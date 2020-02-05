package com.catalog.MTGCardCatalog.card;

import lombok.*;

import javax.persistence.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "cards")
@SequenceGenerator(name = "CARD_SEQ", sequenceName = "card_id_seq", allocationSize = 1)
public
class CardEntity {

    @Setter(AccessLevel.NONE)
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CARD_SEQ")
    @Column(name = "id")
    private long id;

    @Column( name = "name")
    private String name;


}
