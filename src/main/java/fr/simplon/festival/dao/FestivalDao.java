package fr.simplon.festival.dao;

import fr.simplon.festival.entity.Festival;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface FestivalDao {

    void saveFestival(String nom, String url, LocalDate debut, LocalDate fin, String ville, int cp, String lieu, double lat, double lon);

    List<Festival> getAllFestivals();
}
