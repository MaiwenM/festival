package fr.simplon.festival.dao.impl;

import fr.simplon.festival.dao.FestivalDao;
import fr.simplon.festival.dao.FestivalRepository;
import fr.simplon.festival.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

public class FestivalDaoImpl implements FestivalDao {

    @Autowired
    private FestivalRepository festivalRepository;

    @Override
    public void saveFestival(String nom, String url, Date debut, Date fin, String ville, int cp, String lieu, double lat, double lon) {
        Festival festival = new Festival();
        festival.setNom(nom);
        festival.setUrl(url);
        festival.setDebut(debut);
        festival.setFin(fin);
        festival.setVille(ville);
        festival.setCp(cp);
        festival.setLieu(lieu);
        festival.setLat(lat);
        festival.setLon(lon);
        festivalRepository.save(festival);
    }

    @Override
    public List<Festival> getAllFestivals() {
        return festivalRepository.findAll();
    }
}
