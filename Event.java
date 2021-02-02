
/**
 * Beschreibung
 *
 * @author Finn W.
 * @version 1.0 vom 27.05.2020
 */


public class Event {

    int fraktion=1;
    int repKosten=0;
    int zufriedenheitsMali=0;
    int tote;


    int eventType=1; //1= Katastrophe, 2=Aussetzen, 3= Gebaeudeschaden, 4 = positiv;
    boolean interaktiv=false;
    String info="Ein normaler Tag ohne besondere Ereignisse";
    String name="keine besonderen Vorkommnisse";


    public void geschehen(int event_Nummer) {
        interaktiv=false;
        eventType=1;

        if (event_Nummer == 1) {
            Musik.musik("Sound/1/Brandausbruch.wav", false, fraktion);
            repKosten=2000;
            zufriedenheitsMali=-2;
            tote=(int) Math.floor(Math.random() * (9-5)+4);
            info="Ein Brand ist ausgebrochen! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den Wiederaufbau werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Brandausbruch!";
            eventType=3;

        } else if (event_Nummer == 2) {

            Musik.musik("Sound/1/Ueberfall.wav", false, fraktion);
            repKosten=500;
            zufriedenheitsMali=-5;
            tote=(int) Math.floor(Math.random() * (3-2)+1);
            info="In der Stadt ist ein Raub begangen worden! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Raub!";
        } else if (event_Nummer == 3) {

            Musik.musik("Sound/1/Erdbeben.wav", false, fraktion);
            repKosten=12000;
            zufriedenheitsMali=-15;
            tote=(int) Math.floor(Math.random() * (29-13)+12);
            info="Es hat ein schweres Erdbeben gegeben! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Erdbeben";
            eventType=3;

        } else if (event_Nummer == 4) {

            Musik.musik("Sound/1/Seuche.wav", false, fraktion);
            repKosten=10000;
            zufriedenheitsMali=-15;
            tote=(int) Math.floor(Math.random() * (35-21)+20);
            info="Eine Seuche hat die Stadt getroffen! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Seuche!";
            eventType=3;
        } else if (event_Nummer == 5) {

            Musik.musik("Sound/1/Tornado.wav", false, fraktion);
            repKosten=15000;
            zufriedenheitsMali=-25;
            tote=(int) Math.floor(Math.random() * (28-9)+8);
            info="Ein Tornado hat die Stadt getroffen! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Tornado!";
            eventType=3;
        } else if (event_Nummer == 6) {

            Musik.musik("Sound/1/Entscheidungs_Event.wav", false, fraktion);
            repKosten=0;
            zufriedenheitsMali=0;
            tote=(int) Math.floor(Math.random() * (28-9)+8);
            info="Aufgrund eines unglaublichen Ereignisses, m\u00fcssen Sie diese Runde aussetzen.";
            name="Aussetzen";
            eventType=2;
        } else if (event_Nummer == 7) {

            Musik.musik("Sound/1/Event_Aussetzen.wav", false, fraktion);
            repKosten=0;
            zufriedenheitsMali=-10;
            tote=(int) Math.floor(Math.random() * (28-9)+8);
            info="Sie haben eine fragw\u00fcrdige Twitternachricht gepostet. Das wird Ihnen "+zufriedenheitsMali+" Zufriedenheit einbringen. ";
            name="Das war nicht klug...";
            eventType=2;
        } else if (event_Nummer == 8) {

            Musik.musik("Sound/1/Event_Aussetzen.wav", false, fraktion);
            repKosten=0;
            zufriedenheitsMali=0;
            tote=0;
            info="Irgendeinen Grund wird es daf\u00fcr geben, dass Sie in diese Runde aussetzen m\u00fcssen.";
            name="Aussetzen";
            eventType=2;
        } else if (event_Nummer == 9) {

            Musik.musik("Sound/1/Event_Aussetzen.wav", false, fraktion);
            repKosten=0;
            zufriedenheitsMali=0;
            tote=0;
            info="Da Sie heute morgen Ihren Wecker verpasst haben, m\u00fcssen Sie diese Runde aussetzen.";
            name="Aussetzen";
            eventType=2;
        } else if (event_Nummer == 10) {

            Musik.musik("Sound/1/Event_Aussetzen.wav", false, fraktion);
            repKosten=0;
            zufriedenheitsMali=0;
            tote=0;
            info="Ihre Internetverbindung ist zusammengebrochen! Sie m\u00fcssen diese Runde aussetzen.";
            name="Internetausfall!";
            eventType=2;
        } else if (event_Nummer == 11) {

            Musik.musik("Sound/1/Entscheidungs_Event.wav", false, fraktion);
            repKosten=500;
            zufriedenheitsMali=0;
            tote=1;
            info="Aufst\u00e4ndische haben Ihren Palast blockiert! Sie m\u00fcssen diese Runde aussetzen.";
            name="Blockade!";
            eventType=2;
        } else if (event_Nummer == 12) {

            Musik.musik("Sound/1/Event_Aussetzen.wav", false, fraktion);
            repKosten=10000;
            zufriedenheitsMali=0;
            tote=0;
            info="Hacker haben "+repKosten+" von unserem Konto gestohlen!";
            name="Hackerangriff!";
            eventType=1;
        } else if (event_Nummer == 13) {

            Musik.musik("Sound/1/Event_Aussetzen.wav", false, fraktion);
            repKosten=15000;
            zufriedenheitsMali=0;
            tote=1;
            info="Ihr zust\u00e4ndiger Systemadministrator hat leider ein kleines Missgeschick gebaut, woraufhin Ihr Computer in Flammen aufgegangen ist. Die Neuanschaffunskosten Ihres Computersystems balaufen sich auf "+repKosten+". Au\u00dferdem m\u00fcssen Sie diese Runde aussetzen.";
            name="Missgeschick!";
            eventType=2;
        } else if (event_Nummer == 14) {

            Musik.musik("Sound/1/Event_Positiv.wav", false, fraktion);
            repKosten=-10000;
            zufriedenheitsMali=0;
            tote=1;
            info="Sir, bei Bauarbeiten haben wir einen alten Schatz gefunden!"+(-1*repKosten)+" wurden unserem Konto gutgeschrieben!";
            name="Ein Schatz!";
            eventType=4;
        } else if (event_Nummer == 15) {

            Musik.musik("Sound/1/Event_Positiv.wav", false, fraktion);
            repKosten=-5000;
            zufriedenheitsMali=0;
            tote=1;
            info="Sie haben ein Geschenk durch einen Unbekannten erhalten! "+(-1*repKosten)+" wurden unserem Konto gutgeschrieben!";
            name="Ein Geschenk";
            eventType=4;
        } else if (event_Nummer == 16) {

            Musik.musik("Sound/1/Event_Positiv.wav", false, fraktion);
            repKosten=-5000;
            zufriedenheitsMali=0;
            tote=1;
            info="Warum auch immer, aber Sie haben soeben "+(-1*repKosten)+" auf das Staatskonto \u00fcberwiesen bekommen!";
            name="Mehr Geld!";
            eventType=4;
        } else if (event_Nummer == 17) {

            Musik.musik("Sound/1/Event_Positiv.wav", false, fraktion);
            repKosten=-5000;
            zufriedenheitsMali=0;
            tote=1;
            info="Als Sie nach dem Aufstehen Ihr Bankkonto gecheckt haben, stellten Sie fest, dass "+(-1*repKosten)+" auf das Konto überwiesen wurden. Woher das Geld stammt wei\u00df niemand, aber man kann ja schlecht nein sagen...";
            name="Mysteri\u00f6se \u00fcberweisung";
            eventType=4;
        }
        else if (event_Nummer == 18) {

            Musik.musik("Sound/1/Event_Positiv.wav", false, fraktion);
            repKosten=-5000;
            zufriedenheitsMali=0;
            tote=1;
            info="Als Sie nach dem Aufstehen Ihr Bankkonto gecheckt haben, stellten Sie fest, dass "+(-1*repKosten)+" auf das Konto überwiesen wurden. Woher das Geld stammt wei\u00df, au\u00dfer Ihnen, niemand..";
            name="Schutzgeld!";
            eventType=4;
        }
        else if (event_Nummer == 19) {

            Musik.musik("Sound/1/Brandausbruch.wav", false, fraktion);
            repKosten=-1000;
            zufriedenheitsMali=-3;
            tote=2;
            info="Ein Geb\u00e4ude wurde vorsetzlich in Brand gesteckt! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Brandstiftung!";
            eventType=3;
        }
        else if (event_Nummer == 20) {

            Musik.musik("Sound/1/Event_Positiv.wav", false, fraktion);
            repKosten=-5000;
            zufriedenheitsMali=0;
            tote=0;
            info="Sie haben eine \u00dcberweisung unbekannter Herkunft erhalten, aber das muss ja niemand wisse... "+(-1*repKosten)+" wurden gutgeschrieben.";
            name="Schutzgeld!";
            eventType=4;
        }else if (event_Nummer == 21) {

            Musik.musik("Sound/1/Brandausbruch.wav", false, fraktion);
            repKosten=-1000;
            zufriedenheitsMali=-3;
            tote=1;
            info="Ein Geb\u00e4ude steht in Flammen, die Ursache ist noch unklar.! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Brandausbruch!";
            eventType=3;
        }
        else if (event_Nummer == 22) {

            Musik.musik("Sound/1/Brandausbruch.wav", false, fraktion);
            repKosten=-1000;
            zufriedenheitsMali=-3;
            tote=3;
            info="Durch einen technischen Defekt an einem elektronischen Ger\u00e4t ist ein Brand ausgebrochen! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Brandausbruch!";
            eventType=3;
        }
        else if (event_Nummer == 23) {

            Musik.musik("Sound/1/Brandausbruch.wav", false, fraktion);
            repKosten=-1000;
            zufriedenheitsMali=-3;
            tote=1;
            info="Durch die Unachtsamkeit eines Einwohners ist ein Brand ausgebrocehn! "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Es brennt!";
            eventType=3;
        }
        else if (event_Nummer == 94) {
            Musik.musik("Sound/Polizeieingriff.wav", false, fraktion);
            repKosten=0;
            tote=0;
            info="Die Polizei hat Ihre Absetzung verhindert, nun sollten Sie aber schleunigst Ma\u00dfnahmen einleiten, um das System zu stabilisieren. Was einmal funktioniert, muss nicht noch einmal funktionieren...";
            name="Polizei verhindert Niederlage!";
        }
        else if (event_Nummer == 95) {
            Musik.musik("Sound/1/Katastrophen_Warnung.wav", false, fraktion);
            repKosten=0;
            tote=0;
            info="Aufgrund unserer exessiven Ausnutzung der Umwelt hat sich das Klima nachhaltig ver\u00e4ndert! Der Wechsel der Jahreszeiten wird zunehmend unregelm\u00e4ßiger, daf\u00fcr werden die Unterschiede noch extremer.";
            name="Das Klima ver\u00e4ndert sich....";
        } else if (event_Nummer == 96) {
            Musik.musik("Sound/Events/Sommer.wav", false, fraktion);
            repKosten=0;
            tote=0;
            info="Die Reduzierung unserer Umweltverschmutzung scheint Wirkung zu zeigen! Der Wechsel der Jahreszeiten wirkt wieder stabil. Wir sollten jedoch dennoch achtsam bleiben!";
            name="Das Klima beginnt sich wieder zu stabilisieren!.";
        } else if (event_Nummer == 97) {
            Musik.musik("Sound/Events/Sommer.wav", false, fraktion);
            repKosten=0;
            tote=0;
            info="Der Sommer beginnt. Die Produktionen laufen wieder normal.";
            name="Sommerbeginn";
        } else if (event_Nummer == 98) {
            Musik.musik("Sound/Events/Winter.wav", false, fraktion);
            repKosten=0;
            tote=0;
            info="Der Winter hat begonnen. Aufgrund der Heizungskosten werden unsere Einnahmen halbiert.";
            name="Winterbeginn";
        } else if (event_Nummer == 99) {
            Musik.musik("Sound/1/Aufstand.wav", false, fraktion);
            repKosten=100000;
            tote=(int) Math.floor(Math.random() * (7-6)+5);
            info="Aufgrund der niedrigen Zufriedenheit ist ein Aufstand im Gange! Die Sicherheitskr\u00e4fte haben ihn gewaltsam aufgelöst. "+tote+" Personen sind dabei gestorben! Die Kosten f\u00fcr die Einsatzkr\u00e4fte und den entstandenen Sachschaden werden sich auf "+repKosten+" belaufen. Au\u00dferdem wird dieses Ereignis die Einwohner verunsichern und uns so "+zufriedenheitsMali+" Zufriedenheit einbringen.";
            name="Aufstand!";
        }
    }

    public String gibInfo() {
        return info;
    }

    public int gibRepKosten() {
        return repKosten;
    }


    public int gibTote() {
        return tote;
    }

    public int gibZufriedenheitsMali() {
        return zufriedenheitsMali;
    }

    public String gibName() {
        return name;
    }

    public boolean gibInteraktiv() {
        return interaktiv;
    }

    public void setFraktion(int fraktion) {
        this.fraktion=fraktion;
    }


    public void geschehen(int tote, String info, String name) {

        Musik.musik("Sound/Events/Sommer.wav", false, fraktion);
        repKosten=0;
        this.tote=tote;
        this.info=info;
        this.name=name;
    }

    public int gibEventType() {
        return eventType;
    }
}// of class Event
  
