package fr.simplon.festival.controller;

import fr.simplon.festival.dao.FestivalDao;
import fr.simplon.festival.dao.impl.FestivalDaoImpl;
import fr.simplon.festival.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class FestivalController {

    @Autowired
    private FestivalDao festivalDao;

    @GetMapping("/formulaireAjout")
    public String afficherLaCarte(Model model) {
        model.addAttribute("festival", new Festival());
        return "accueil";

    }

    @PostMapping("/ajoutFestival")
    public String enregistrerFesitival(@ModelAttribute("festival") Festival festival) {
        festivalDao.saveFestival(festival.getNom(), festival.getUrl(), festival.getDebut(), festival.getFin(), festival.getVille(), festival.getCp(), festival.getLieu(), festival.getLat(), festival.getLon());
        return "redirect:/";
    }

    @GetMapping("/FormulaireEdit/{id}")
    public String afficherFormulaireEdition(@PathVariable("id") Long id, Model model) {
        Festival festival = festivalDao.getFestivalById(id);
        model.addAttribute("festival", festival);
        return "edition";
    }

    @GetMapping("/enregistrerEditionFestival")
    public String enregistrerEditionFestival(@ModelAttribute("festival") Festival festival) {
        festivalDao.updateFestival(festival);
        return "redirect:/";
    }

}






