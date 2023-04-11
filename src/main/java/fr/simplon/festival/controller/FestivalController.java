package fr.simplon.festival.controller;

import fr.simplon.festival.dao.FestivalDao;
import fr.simplon.festival.dao.impl.FestivalDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FestivalController {

    @Autowired
    private FestivalDao festivalDao;

    @Autowired
    private FestivalDaoImpl festivalDaoImpl;

}
