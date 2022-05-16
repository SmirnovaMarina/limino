package project.dsprojectwebapp.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import project.dsprojectwebapp.model.Card;
import project.dsprojectwebapp.service.CardService;
import java.util.List;

@RequestMapping("api/cardOperations")
@RestController
public class CardController {

    private final CardService cardService;

    @Autowired
    public CardController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping(path = "/getCard/{tag}")
    public Card getCardByTag(@PathVariable("tag") String tag) {
        return cardService.getCardByTag(tag)
                .orElse(null);
    }

    @GetMapping(path = "/getPath/{tag}")
    public String getImagePathByTag(@PathVariable("tag") String tag) {
        return cardService.getImagePathByTag(tag);
    }
}
