/**
 * Beschreibung
 *
 * @Finn W.
 * @version 1.0 vom 27.05.2020
 */

public class Residential_Building extends Building {
    public Residential_Building() {

        baupreis=1000;
        level=-1;
        umweltverschmutzung=3;
        zufriedenheitsboni=0;
        wohnraum=10;
        builtImage=residential;
        einkommen=-250;
        typ="Wohnhaus";
        gebaeudeTyp="Wohngeb\u00e4ude";
    }
    public void lvlUp() {

        if (level >= 3) {
            einkommen=einkommen+(level / 4) * einkommen;
            wohnraum=wohnraum * 2;
            builtImage=residential2;
        } else {
            einkommen=einkommen+(level / 2) * einkommen;
            wohnraum=wohnraum * 2;
        }
    }


} // end of class Residential_Building

