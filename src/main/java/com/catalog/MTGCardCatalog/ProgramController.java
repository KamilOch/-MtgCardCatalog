package com.catalog.MTGCardCatalog;

import com.catalog.MTGCardCatalog.card.CardEntity;
import com.catalog.MTGCardCatalog.card.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProgramController {

    private final CardService cardService;

    @Autowired
    public ProgramController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/")
    public String startPage() {
        return "startPage";
    }

    @GetMapping("/cardsList")
    public String cardsList(Model model) {
        model.addAttribute("cards", cardService.getAllCards());
        return "cards";
    }

    @GetMapping("/addCard")
    public String addCard(
            @RequestParam(value = "cardName", required = false) String name
    ) {
        if (name != null) {
            cardService.addCard(name);
        }
        return "addingCard";
    }

    @GetMapping("/editCard/{id}")
    public String editCardById(
            @PathVariable long id,
            Model model
    ) {
        CardEntity editedCard = cardService.findById(id);
        model.addAttribute("editedCard", editedCard);
        return "editingCard";
    }

    @GetMapping("/saveEditedCard")
    public String saveEditedCard(
            @RequestParam(value = "cardId", required = false) long id,
            @RequestParam(value = "cardName", required = false) String name
    ) {
        cardService.editCard(id, name);
        return "redirect:/cardsList";
    }

    @GetMapping("deleteCard/{id}")
    public String deleteCarById(
            @PathVariable Integer id
    ) {
        cardService.deleteCardById(id);
        return "redirect:/cardsList";
    }

}
