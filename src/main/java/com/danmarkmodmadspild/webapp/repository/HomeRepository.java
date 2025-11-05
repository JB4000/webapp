package com.danmarkmodmadspild.webapp.repository;


import com.danmarkmodmadspild.webapp.model.HomeInfoDto;
import org.springframework.stereotype.Repository;

@Repository
public class HomeRepository {

    public HomeInfoDto getHomeSectionText() {

        HomeInfoDto dto = new HomeInfoDto();

        dto.setProblemText("""
                <h2>Madens lange rejse ender i skraldespanden...</h2>
                                <p>
                
                                    Dem som du køber din mad af spilder 227.000 ton mad per år.<br>
                                    Når maden når til hjemmet spildes yderligere 261.000 ton per år.<br><br>
                                    <b>Det er en enorm mængde fødevarer som ikke når i mål!</b><br><br>
                                    Konsekvensen er en enorm belastning af miljø og økonomi
                                    samt spild af rigtig mange menneskers arbejdsindsats.<br><br>
                                    <br>
                                </p>""");

        dto.setSolutionText("""
                <h2>Lad os sammen få maden i mål!</h2>
                                <p>
                                    Vi har virksomheder i det lokalområde som ønsker at du kommer og henter overskudsmad.
                                    Men vi ved også at det kan være svært at bruge store mængder ens fødevarer.
                                    Derfor formidler Danmark mod madspild sociale madevents i dit nærområde,
                                    hvor du kan kombinere din afhentning med andres komplementerende fødevarer
                                    og gøre madlavning og forebyggelse af madspild til en social oplevelse.
                                    Sådan starten rejsen mod en fremtid med mindre spild via nydelse og fællesskab.<br>
                                    <b>Lad os lave en fælles løsning på et fælles problem</b><br>
                                </p>""");

        return dto;

    }
}
