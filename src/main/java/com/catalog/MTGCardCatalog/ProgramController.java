package com.catalog.MTGCardCatalog;

import com.catalog.MTGCardCatalog.card.CardService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProgramController {

    private final CardService cardService;

    public ProgramController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public String startPage() {
        return "startPage";
    }
}
