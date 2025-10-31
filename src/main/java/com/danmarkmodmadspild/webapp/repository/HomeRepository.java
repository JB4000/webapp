package com.danmarkmodmadspild.webapp.repository;


import com.danmarkmodmadspild.webapp.model.HomeInfo;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public class HomeRepository {

    public HomeInfo getProblemText() {

        return new HomeInfo("Lad ikke enden på madens lange rejse være skraldespanden!",
                "Dem som du køber din mad af spilder 227.000 ton mad per år.",
                "Af det som når frem til husholdningerne spildes yderligere 261.000 ton per år.",
                "Det er en enorm mængde fødevarer som ikke når i mål!",
                "Samlet spilder det store mængder resourcer og arbejdstimer,",
                "og konsekvenserne er enorme for miljø og økonomi.");
    }

    public HomeInfo getSolutionText() {

        return new HomeInfo("Lad os få maden i mål i fællesskab!",
                " ",
                "Danmark mod madspild formidler sociale madevents i dit nærområde.",
                "Sammen kan vi i fællesskab bygge nye vaner op og forebygge madspild.",
                "Her starten rejsen mod en fremtid med mindre spild via nydelse og fællesskab.",
                "En fælles løsning på et fælles problem");
    }


}
