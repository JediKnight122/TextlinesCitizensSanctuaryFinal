/**
 * Beschreibung
 *
 * @author Finn W.
 * @version 1.0 vom 27.05.2020
 */

public class Industrial_Building extends Building {
    public Industrial_Building() {


        einkommen=1000;
        mindestEinwohner=0;
        baupreis=5000;
        level=-3;
        umweltverschmutzung=7;
        zufriedenheitsboni=0;
        builtImage=industry;
        typ="Industrie";
        gebaeudeTyp="Industriegeb\u00e4ude";
    }

    public void lvlUp() {


        if (level >= 5) {
            einkommen=einkommen+(level / 4) * einkommen;
            zufriedenheitsboni+=1;
            builtImage=industry3;
            umweltverschmutzung=umweltverschmutzung+level;
        } else if (level >= 3) {
            einkommen=einkommen+(level / 4) * einkommen;
            zufriedenheitsboni+=1;
            builtImage=industry2;
            umweltverschmutzung=umweltverschmutzung+level;
        } else {
            einkommen=einkommen+(level / 2) * einkommen;
            zufriedenheitsboni+=1;
        }
    }

} // end of class Industrial_Building

