package fr.simplon.festival.dao.impl;

import fr.simplon.festival.dao.FestivalDao;
import fr.simplon.festival.entity.Festival;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Repository
public class FestivalDaoImpl implements FestivalDao {

    @Autowired
    private FestivalRepository festivalRepository;

    @Override
    public void saveFestival(String nom, String url, LocalDate debut, LocalDate fin, String ville, int cp, String lieu, double lat, double lon) {
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

    @Override
    public void festivalEdit(Long id, String nom, String url, LocalDate debut, LocalDate fin, String ville, int cp, String lieu, double lat, double lon) {

        Festival festival = festivalRepository.findById(id).orElse(null);

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
    public void saveFestival(Festival festival) {
        this.festivalRepository.save(festival);
    }

    @Override
    public Festival getFestivalById(Long id) {
        return festivalRepository.findById(id).orElse(null);
    }
}
