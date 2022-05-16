package project.dsprojectwebapp.mvc;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.dsprojectwebapp.service.CardService;

@RequestMapping("view")
@Controller
public class ViewController {

    private final CardService cardService;

    @Autowired
    public ViewController(CardService cardService) {
        this.cardService = cardService;
    }

    @GetMapping("/submitTag")
    public String submitTag(@RequestParam String str, Model model) {
        return "redirect:getCard/" + str.trim();
    }

    @GetMapping(path = "/getCard/{tag}")
    public String getCardByTag(@PathVariable String tag, Model model) {
        String path = cardService.getImagePathByTag(tag);
        model.addAttribute("path", path);
        return "image";
    }
}
