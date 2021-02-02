/**
 *
 * Test
 *
 * @version 1.0 vom 27.05.2020
 * @author: Finn W.
 */

public class Entertainment_Building extends Building {
    public Entertainment_Building() {
        einkommen= 100;
        mindestEinwohner = 0;
        baupreis = 2000;
        level = -2;
        umweltverschmutzung = 4;
        zufriedenheitsboni = 6;
        builtImage = entertainment;
        typ="Unterhaltung";
        gebaeudeTyp="Unterhaltungsgeb\u00e4ude";
    }
    public void lvlUp() {

        if (level >= 5) {
            einkommen=einkommen+(level / 4) * einkommen;
            zufriedenheitsboni+=5;

        } else {
            einkommen=einkommen+(level / 3) * einkommen;
            zufriedenheitsboni+=8;
        }
    }

  

} // end of class Entertainment_Building

