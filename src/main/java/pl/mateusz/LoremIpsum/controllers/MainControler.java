package pl.mateusz.LoremIpsum.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.mateusz.utils.Util;


import java.util.Random;

@Controller
public class MainControler {

    @GetMapping("/")
    public String indexGet(Model model){
        model.addAttribute("loremIpsum","Lorem ipsum – tekst składający się z łacińskich i quasi-łacińskich wyrazów, " +
                "mający korzenie w klasycznej łacinie, wzorowany na fragmencie traktatu Cycerona „O granicach dobra i zła” " +
                "(De finibus bonorum et malorum) napisanego w 45 r. p.n.e. Tekst jest stosowany do demonstracji krojów pisma " +
                "(czcionek, fontów), kompozycji kolumny itp. Po raz pierwszy został użyty przez nieznanego drukarza w XVI w.");

        return "index";
    }

    @PostMapping("/")
    public String indexPost(@RequestParam("quantityWord") String quantityWord,
                            @RequestParam("quantityParagraph") String quantityParagrapg,
                            Model model){
        model.addAttribute("paragraph", Util.sentence(quantityWord,quantityParagrapg));
        model.addAttribute("word",quantityWord);
        return "index";
    }
}
