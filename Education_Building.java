/**
 *
 * Beschreibung
 *
 * @version 1.0 vom 27.05.2020
 * @author Finn W.
 */

public class Education_Building extends Building {
  public Education_Building (){
    
    produktivitaetsboni= 0.1;
    mindestEinwohner = 0;
    baupreis = 3000;
    level = -3;
    umweltverschmutzung = 2;
    zufriedenheitsboni = 4;
    builtImage = education;
    einkommen=-1000;
    typ="Bildung";
    gebaeudeTyp="Bildungsgeb\u00e4ude";
  }
  public void lvlUp() {

    if (level >= 5) {
      einkommen=einkommen+(level / 4) * einkommen;
      wohnraum=wohnraum * 2;
      builtImage=education2;
    } else {
      einkommen=einkommen+(level / 2) * einkommen;
      wohnraum=wohnraum * 2;
      produktivitaetsboni+=0.2;
      zufriedenheitsboni+=1;
    }
  }

  
} // end of class Education_Building

