package fr.simplon.festival.controller;

import fr.simplon.festival.dao.FestivalDao;
import fr.simplon.festival.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class FestivalController {

    @Autowired
    private FestivalDao festivalDao;

    @GetMapping("/")
    public String afficherFestivals(Model model){
        List<Festival> festivals = festivalDao.getAllFestivals();
        model.addAttribute("festivals", festivals);
        return "index";
    }

    @GetMapping("/formulaire_ajout")
    public String ajouterFestival(Model model){
        model.addAttribute("festival", new Festival());
        return "/formulaire_ajout";
    }

    @PostMapping("/ajoutFestival")
    public String enregistrerFestival(@ModelAttribute("festival") Festival festival) {
        festivalDao.saveFestival(festival);
        return "redirect:/";
    }

    @GetMapping("/formulaire_edit/{id}")
    public String afficherFormulaireEdition(@PathVariable("id") Long id, Model model) {
        Festival festival = festivalDao.getFestivalById(id);
        model.addAttribute("festival", festival);
        return "formulaire_edit";
    }

    @PostMapping("/enregistrerModifFestival")
    public String modifierFestival(@ModelAttribute("festival") Festival festival){
        festivalDao.saveFestival(festival);
        return "redirect:/";
    }
}

