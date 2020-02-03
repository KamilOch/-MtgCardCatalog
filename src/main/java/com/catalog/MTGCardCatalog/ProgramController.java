package com.catalog.MTGCardCatalog;

import com.catalog.MTGCardCatalog.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ProgramController {

    private CardService cardService;

    @Autowired
    public ProgramController(CardService cardService) {
        this.cardService = cardService;
    }




}
