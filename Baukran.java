/**
 * Autor: Finn W.
 * Beschreibung: Arbeitet bei Aufruf die übergeben Bauliste ab, welche Objekte der Klasse "Building" enthalten müssen.
 * Bei Fertigstellung werden Gebäude in die gebaeudeListe eingetragen und aus der bauListe entfernt.
 * Die Fertigstellung kommt immer vor dem Bauvorgang, d.h. sobald ein Gebäude fertig ist (also Level 1), muss noch die nächste Runde abgewartet werden, bis es aktiv wird.
 */

import java.util.ArrayList;
import java.util.List;

public class Baukran {
    List<Building> gebauedeListe=new ArrayList<>();
    List<Building> abrissListe=new ArrayList<>();//Liste mit allen Gebäuden, die fertiggestellt wurden.
    int fraktion=1;

    public Baukran() {
        int bauBoni=1;
    }

    public void errichten(List<Building> buildings) {

        for (Building gebaeude : buildings) {   //Wiederholung anhand der Einträge in der Bauliste


            if (gebaeude.gibLevel() == gebaeude.gibmaxLvl()) {
                gebaeude.fertigstellen();
                gebaeude.setzBauarbeitenAktiv(false);
                gebauedeListe.add(gebaeude);
                gebaeude.bauPlatzBild.setImage(gebaeude.builtImage);
                //Gebäude werden erst eine Runde nach Fertigstellung aktiv!
            } else {
                gebaeude.bauen();
                gebaeude.setzBauarbeitenAktiv(true);


            }
        }
        buildings.removeIf(building -> !building.gibBauarbeitenAktiv());//Entfernung eines Gebäudes aus der Liste sobald es fertiggestellt ist (Löschen aus Liste während Itarierung nicht möglich, da erst die gesamte Bauliste abgearbeitet werden muss
    }

    public void abreissen(List<Building> buildings) {
        for (Building gebaeude : buildings) {   //Wiederholung anhand der Einträge in der Bauliste

            gebaeude.setLevel(gebaeude.gibLevel()-1);
            System.out.println("Level: "+gebaeude.gibLevel());
            if (gebaeude.getBrennt()) {
                Musik.addeSound("Sound/1/Building_burning.wav");
            } else {
                Musik.addeSound("Sound/1/Dekonstruktion.wav");
            }
            if (gebaeude.gibLevel() == 0) {
                if (gebaeude.getBrennt()) {
                    Musik.addeSound("Sound/1/Fire_destruction.wav");
                    Musik.entferneSound("Sound/1/Building_burning.wav");
                } else {
                    Musik.addeSound("Sound/1/Abriss_abgeschlossen.wav");
                    Musik.entferneSound("Sound/1/Dekonstruktion.wav");
                }
                gebaeude.entfernen();
                gebaeude.bauPlatzBild.setImage(gebaeude.builtImage);
                gebauedeListe.remove(gebaeude);

            }
        }
            buildings.removeIf(building -> building.gibLevel() == 0);//Entfernung eines Gebäudes aus der Liste sobald es fertiggestellt ist (Löschen aus Liste während Itarierung unschön da erst die gesamte Bauliste abgearbeitet werden muss

        abrissListe=buildings;
    }


    public List gibGebaeudeListe() {
        return gebauedeListe;
    }

    public void setFraktion(int fraktion) {
        this.fraktion=fraktion;
    }

    public void setGebaeudeListe(List<Building> gebauedeListe) {
        this.gebauedeListe=gebauedeListe;
    }

    public List gibAbrissListe(){
        return abrissListe;
    }
}





