/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 24.07.2020
 * @author Finn W.
 */

public class Fire_Station extends Building {

    public Fire_Station (){

        mindestEinwohner = 0;
        baupreis = 4000;
        level = -3;
        umweltverschmutzung = 1;
        zufriedenheitsboni = 2;
        builtImage = fireStation;
        einkommen=-1000;
        typ="Feuerwache";
        gebaeudeTyp="Feuerwache";
        loeschKraft=8;
    }
    public void lvlUp() {

        if (level >= 5) {
            einkommen=einkommen+(level / 4) * einkommen;
            loeschKraft=loeschKraft+10;
            zufriedenheitsboni+=4;
        } else {
            einkommen=einkommen+(level / 2) * einkommen;
            zufriedenheitsboni+=2;
            loeschKraft= loeschKraft+5;
        }
    }


} // end of class
