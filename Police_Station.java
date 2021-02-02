/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 24.07.2020
 * @author Finn W.
 */

public class Police_Station extends Building {

    public Police_Station (){

        mindestEinwohner = 0;
        baupreis = 3500;
        level = -3;
        umweltverschmutzung = 1;
        zufriedenheitsboni = 2;
        builtImage = policeStation;
        einkommen=-1500;
        typ="Polizeiwache";
        gebaeudeTyp="Polizeiwache";
        sicherheit=8;
    }
    public void lvlUp() {

        if (level >= 5) {
            einkommen=einkommen+(level / 4) * einkommen;
            sicherheit=sicherheit+10;
            zufriedenheitsboni+=4;
        } else {
            einkommen=einkommen+(level / 2) * einkommen;
            zufriedenheitsboni+=2;
            sicherheit= sicherheit+5;
        }
    }


} // end of class
