
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


/**
 * Beschreibung
 *
 * @author Finn W.
 *
 * @version 1.0 vom 27.05.2020
 */

public abstract class Building {
    double einkommen = 0;
    int mindestEinwohner = 0;
    int maximalBesetzung = 0;
    int level = 0;
    double levelBoni = 0;
    int baupreis = 0;
    int zufriedenheitsboni = 0;
    int umweltverschmutzung = 0;
    double produktivitaetsboni = 0;
    int wohnraum = 0;
    String gebaeudeTyp;
    int maxLvl = 1;
    String typ;
    int sicherheit;
    int loeschKraft;
    boolean brennt=false;

    public boolean getBrennt() {
        return brennt;
    }

    public void setBrennt(boolean brennt) {
        this.brennt=brennt;
    }



    // boolean aktiv; eventuell später um Gebaeude temporär zu deaktivieren

    private boolean bauarbeitenAktiv=false;
    ImageView bauPlatzBild=new ImageView();
    String bauPlatzID;
    Image builtImage;

    /*------------Image Definition-------------*/
    Image industry=new Image("/texture/industry1.png", true);
    Image education=new Image("/texture/education1.png", true);
    Image entertainment=new Image("/texture/Unterhaltung.png", true);
    Image residential=new Image("/texture/Wohnhaus1.png", true);
    Image industry2=new Image("/texture/industry2.png", true);
    Image education2=new Image("/texture/education2.png", true);
    Image entertainment2=new Image("/texture/Unterhaltung.png", true);
    Image residential2=new Image("/texture/Wohnhaus2.png", true);
    Image industry3=new Image("/texture/industry3.png", true);
    Image fireStation=new Image("/texture/Feuerwache.png", true);
    Image policeStation=new Image("/texture/Polizeiwache.png", true);
    Image ruine=new Image("/texture/Schutt.png", true);
    /*----------------------------------------*/

    public void bauen() {
        this.level++;
        Musik.addeSound("Sound/1/Wird_gebaut.wav");
    }




    public int gibmaxLvl() {
        return this.maxLvl;
    }

    public void setmaxLvl(int lvl) {
        this.maxLvl = lvl;
    }

    public void maxLvlUp() {
        this.maxLvl++;
    }

public void setLevel(int level){
        this.level=level;
}

    public void lvlUp() {

        this.level++;

        if (level>=5){
            einkommen=einkommen+(level / 4) * einkommen;
        }
        else {
            einkommen=einkommen+(level / 2) * einkommen;
        }
    }



    public void fertigstellen() {
            this.level = maxLvl;
            setLevelBoni();

            if (level>1){
                lvlUp(); //Aufwertung fertiggestellt
                Musik.addeSound("Sound/1/aufgewertet.wav");
            }
            else {
                Musik.addeSound("Sound/1/Bau_abgeschlossen.wav"); //Gebaeude wird zum ersten mal fertiggestellt
            }
    }
public void entfernen(){
        this.builtImage=ruine;
}

public void deaktivieren(){
        einkommen=0;
        wohnraum=0;
        zufriedenheitsboni=0;
        produktivitaetsboni=0;
}
    public String gibBauplatzID() {
        return bauPlatzID;
    }

    public String gibGebaeudeTyp() {
        return gebaeudeTyp;
    }

    public String gibtyp() {return typ;}

    public boolean gibBauarbeitenAktiv() {
        return bauarbeitenAktiv;
    }

    public void setzBauarbeitenAktiv(boolean bauarbeitenAktiv) {
        this.bauarbeitenAktiv=bauarbeitenAktiv;
    }

    public int gibWohnraum() {
        return wohnraum;
    }

    public int gibKosten() {
        return this.baupreis;
    }

    public double gibEinkommen() {
        return this.einkommen;
    }

    public int gibBaupreis() {return this.baupreis; }

    public int gibZufriedenheitsBoni() {
        return this.zufriedenheitsboni;
    }

    public int gibUmweltverschmutzung() {
        return this.umweltverschmutzung;
    }
    public void abreissen() {
        this.level=0;
    }

    public double gibProduktivitaetsBoni() {
        return this.produktivitaetsboni;
    }

    public int gibLevel() {
        return this.level;
    }

    public void setLevelBoni() {
        this.levelBoni = 1+(0.2*(this.level-1));
    }

    public double gibLevelBoni() {
        return levelBoni;
    }

    public int gibSicherheit(){
        return sicherheit;
    }

    public int gibloeschKraft(){
        return loeschKraft;
    }
} // end of class Building

