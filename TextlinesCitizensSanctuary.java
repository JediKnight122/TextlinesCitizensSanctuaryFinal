/**
 * Beschreibung
 *
 * @version 1.0 vom 27.05.2020
 * @Finn W. und Colin B.
 */

import animatefx.animation.*;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class TextlinesCitizensSanctuary implements Initializable {

    //Definitionen
    int fraktion=1;
    int rundenzaehler=0;
    double kontostand=10000;
    double basisEinkommen=500;
    double einnahmen=0;
    int zufriedenheit;
    int grundZufriedenheit=60; //"Prozent" -> von 0 bis 100
    int zufriedenheitsBoni=0;
    int grundZufriedenheitsBoni=0;
    double produktivitaetsboni=1; //Darf niemals 0 oder negativ sein, da es mit den Einnahmen multipliziert wird!
    int bevoelkerung=5;
    int umweltverschmutzung=0;
    int basisUmweltverschmutzung=2;
    int ultimatum=4; //   Letzte Chance vor endgültiger Niederlage
    int wohnraum=0;
    int basisWohnraum=20;
    int eventChance=0;
    int verschieb; //Die Zahl welche Bestimmt um wieviel die Bau und Aufwertungs Panes verschoben werden
    int verschiebFeuer=90; //Bestimmt, um wieviel das Feuer verschoben werden muss um auf das Building zu passen
    int zufallsZahl;
    int derzeitigeEpoche;
    int forschungsPunkte;
    int jahresZeit=0;
    double jahreszeitenFaktor=1;
    int event_ZufriedenheitsFaktor=0;
    boolean umweltschaeden=false;
    int sicherheit=0;
    int basisSicherheit=0;
    int loeschKraft=0;
    int basisUltimatum=4;
    String feuerZerstoerungsWahrscheinlichkeit="Unwahrscheinlich";

    boolean buttonFound=false;

    /*---------Initialisierungen der Bilder---------*/
    ImageView whereAmIIm=new ImageView();

    Image bauarbeiten=new Image("/texture/bauarbeiten.gif", true);
    Image bauPlatzGDI=new Image("/texture/Bauplatz_GDI.png", true);
    Image bauPlatzNOD=new Image("/texture/Bauplatz_NOD.png", true);
    Image schutt=new Image("/texture/Schutt.png", true);
    Image sommer=new Image("/texture/Hintergrund.png", true);
    Image winter=new Image("/texture/Hintergrund_Winter.png", true);
    Image dialogFensterSommer=new Image("/texture/Sommer.jpg", true);
    Image dialogFensterWinter=new Image("/texture/Winter.jpg", true);
    Image dialogFensterKlimawandel=new Image("/texture/Klimawandel.jpg", true);
    Image dialogFensterKlimaschutz=new Image("/texture/Klimaschutz.jpg", true);
    Image dialogFensterPositiv=new Image("/texture/Event_Positiv.jpg", true);
    Image dialogFensterPolizei=new Image("/texture/Polizeieingriff.jpg", true);
    /*----------------------------------------------*/

    List<Building> bauListe=new ArrayList<>();      //Quelle: von Jan; Liste mit allen Gebäuden, die aktuell gebaut werden
    List<Building> abrissListe=new ArrayList<>(); // Liste mit allen Gebäuden, die sich im Abrissvorgang befinden oder brennen
    List<Building> gebauedeListe=new ArrayList<>(); //Liste mit allen Gebäuden, die gebaut wurden

    List<ImageView> ListImage=new ArrayList<>();    //Liste mit allen ImageViews (größtenteils Bauplätze).

    List<Button> ListBauMenueButton=new ArrayList<>();        //Liste mit allen bauMenü Buttons.


    List<Button> ListForschungAllButton=new ArrayList<>(); //Liste mit allen Buttons im forschungsbereich allForschung

    List<Button> ListForschungIndustrieButton=new ArrayList<>(); //Liste mit allen Industrie Buttons im forschungsbereich allForschung
    List<Button> ListForschungWohnButton=new ArrayList<>(); //Liste mit allen Wohngebäude Buttons im forschungsbereich allForschung
    List<Button> ListForschungBildungButton=new ArrayList<>(); //Liste mit allen Bildungs Buttons im forschungsbereich allForschung
    List<Button> ListForschungEntertainmentButton=new ArrayList<>(); //Liste mit allen Entertainment Buttons im forschungsbereich allForschung

    List<Building> ListdefaultBuildings=new ArrayList<>(); //Liste mit den default Gebäuden, für den Vergleich mit echten Gebaeuden

    //Erstellung der Objekte
    Event event=new Event();
    Baukran baukran=new Baukran();

    Building defaultIndustrie=new Industrial_Building();
    Building defaultBildung=new Education_Building();
    Building defaultEntertain=new Entertainment_Building();
    Building defaultWohngebaeude=new Residential_Building();
    Building defaultPolizeiWache=new Police_Station();
    Building defaultFeuerWache=new Fire_Station();

    //Grafische Oberflächen Zeugs
    @FXML
    private Label labelEinwohner;
    @FXML
    private Label labelGeld;
    @FXML
    private Label labelBilanz;
    @FXML
    private Label labelBetten;
    @FXML
    private Label labelBeliebtheit;
    @FXML
    private GridPane fraktionsWahl;
    @FXML
    private Pane bauUndInfoPane;
    @FXML
    private Pane mainPane;
    @FXML
    private ImageView bauplatz1;
    @FXML
    private ImageView bauplatz2;
    @FXML
    private ImageView bauplatz3;
    @FXML
    private ImageView bauplatz4;
    @FXML
    private ImageView bauplatz5;
    @FXML
    private ImageView bauplatz6;
    @FXML
    private ImageView bauplatz7;
    @FXML
    private ImageView bauplatz8;
    @FXML
    private ImageView bauplatz9;
    @FXML
    private ImageView bauplatz10;
    @FXML
    private ImageView bauplatz11;
    @FXML
    private ImageView bauplatz12;
    @FXML
    private Pane bauMenuAuswahlPane;
    @FXML
    private Pane bauMenuAuswahlPane2;
    @FXML
    private Button bauMenuBildungsBauButton;
    @FXML
    private Button bauMenuWohnhausBauButton;
    @FXML
    private Button bauMenuIndustrieBauButton;
    @FXML
    private Button bauUndInfoPaneBauButton;
    @FXML
    private Button dialogButtonStandard;
    @FXML
    private Button dialogButtonInteraktiv;
    @FXML
    private Button bauMenuUnterhaltungsBauButton;
    @FXML
    private Button bauMenuFeuerwacheBauButton;
    @FXML
    private Button bauMenuPolizeiwacheBauButton;
    @FXML
    private Pane niederlagenPane;
    @FXML
    private Label labelRunde;
    @FXML
    private Label labelUmweltverschmutzung;
    @FXML
    private Label event_DialogBeschreibung;
    @FXML
    private Label aufWertMenuWahrscheinlichkeitsLabel;
    @FXML
    private Label event_DialogName;
    @FXML
    private Label labelRundenNiederlage;
    @FXML
    private Pane event_Dialogfenster;
    @FXML
    private Label bauUndInfoPaneWohnraumLabel;
    @FXML
    private Label bauUndInfoPaneProduktionLabel;
    @FXML
    private Label bauUndInfoPaneVerschmutzungsLabel;
    @FXML
    private Label bauUndInfoPaneZufriedenheitsboniLabel;
    @FXML
    private Label bauUndInfoPaneProduktionsboniLabel;
    @FXML
    private Label bauUndInfoPaneTitelLabel;
    @FXML
    private Label bauUndInfoPaneTypeLabel;
    @FXML
    private Label bauUndInfoPaneLevelLabel;
    @FXML
    private Label labelGrundNiederlage;
    @FXML
    private GridPane allForschungsbaum;
    @FXML
    private Button aufwertMenuButton;
    @FXML
    private Pane aufwertMenu;
    @FXML
    private Button aufwertMenuEsc;
    @FXML
    private Button buttonAufwerten;
    @FXML
    private SplitPane forschungsBaumMenu;
    @FXML
    private Label labelUltimatum;
    @FXML
    private Pane ultimatumsPane;
    @FXML
    private VBox sideBar;
    @FXML
    private Slider sliderEpoche;
    @FXML
    private Label epocheAngabe;
    @FXML
    private Button buttonForschungsMenu;
    @FXML
    private Button forschungbuttonIndustrie1;
    @FXML
    private Button forschungbuttonIndustrie2;
    @FXML
    private Button forschungbuttonIndustrie3;
    @FXML
    private Button forschungbuttonIndustrie4;
    @FXML
    private ImageView forschungbildIndustrie1;
    @FXML
    private ImageView forschungbildIndustrie2;
    @FXML
    private ImageView forschungbildIndustrie3;
    @FXML
    private ImageView forschungbildIndustrie4;
    @FXML
    private Button forschungbuttonBildung1;
    @FXML
    private Button forschungbuttonBildung2;
    @FXML
    private Button forschungbuttonBildung3;
    @FXML
    private Button forschungbuttonBildung4;
    @FXML
    private ImageView forschungbildBildung1;
    @FXML
    private ImageView forschungbildBildung2;
    @FXML
    private ImageView forschungbildBildung3;
    @FXML
    private ImageView forschungbildBildung4;
    @FXML
    private Button forschungbuttonEntertainment1;
    @FXML
    private Button forschungbuttonEntertainment2;
    @FXML
    private Button forschungbuttonEntertainment3;
    @FXML
    private Button forschungbuttonEntertainment4;
    @FXML
    private ImageView forschungbildEntertainment1;
    @FXML
    private ImageView forschungbildEntertainment2;
    @FXML
    private ImageView forschungbildEntertainment3;
    @FXML
    private ImageView forschungbildEntertainment4;
    @FXML
    private Button forschungbuttonWohnung1;
    @FXML
    private Button forschungbuttonWohnung2;
    @FXML
    private Button forschungbuttonWohnung3;
    @FXML
    private Button forschungbuttonWohnung4;
    @FXML
    private ImageView forschungbildWohnung1;
    @FXML
    private ImageView forschungbildWohnung2;
    @FXML
    private ImageView forschungbildWohnung3;
    @FXML
    private ImageView forschungbildWohnung4;
    @FXML
    private ImageView feuer;
    @FXML
    private Label forschungsPunkteLabel;
    @FXML
    private Label aufwertungDauerLabel;
    @FXML
    private Label aufwertungKostenLabel;
    @FXML
    private Label aufwertungLevelLabel;
    @FXML
    private Pane rundenCounterPane;
    @FXML
    private ImageView weltHintergrund;
    @FXML
    private ImageView dialogFensterBild;
    @FXML
    private Button naechsteRundeButton;
    @FXML
    private Button abrissButton;
    @FXML
    private Label aufwertMenuFrageLabel;
    @FXML
    private Label aufWertMenuTitelLabel;



    /*
    * Finn W.
    *
    *
    *
    *
    Rundensystem */

    public void naechsteRunde() {

        /*Runde beenden
        if (bauUndInfoPane.isVisible()) {
            new ZoomOut(bauUndInfoPane).play();

            if (bauMenuAuswahlPane.isVisible()) {
                new ZoomOut(bauMenuAuswahlPane).play();

            }
            if (aufwertMenu.isVisible()) {
                new ZoomOut(aufwertMenu).play();
            }
        }
        if (forschungsBaumMenu.isVisible()) {
            new ZoomOut(forschungsBaumMenu).play();
        }
        new ZoomIn(rundenCounterPane).play();
        new ZoomOut(rundenCounterPane).playOnFinished(ZoomIn);
         */
        dialogButtonInteraktiv.setVisible(false);
        dialogFensterBild.setVisible(false);
        bauUndInfoPane.setVisible(false);
        bauMenuAuswahlPane.setVisible(false);
        aufwertMenu.setVisible(false);
        aufwertMenu.setLayoutX(500);
        forschungsBaumMenu.setVisible(false);
        bauUndInfoPaneBauButton.setDisable(false);
        mainPane.setDisable(false);
        dialogFensterSchliessen();
        event_DialogName.setTextFill(Color.WHITE);
        event_DialogBeschreibung.setTextFill(Color.WHITE);

        //nächste Runde starten
        Musik.stop();
        rundenzaehler++;
        forschungsPunkte++;
        labelRunde.setText("Runde: "+rundenzaehler);

        for (Building gebaeude : abrissListe) {
            if (gebaeude.getBrennt()) {
                zufallsZahl=(int) Math.floor(Math.random() * (35-2)+1);
                System.out.println("Zufallszahl: "+zufallsZahl);
                if (zufallsZahl <= loeschKraft) {
                    loescheBuilding(gebaeude);
                }
            }
        }
            //if (gebaeude.gibLevel() == 0)
            //    gebauedeListe.remove(gebaeude);
           // Musik.addeSound("Sound/1/Fire_destruction.wav");


        //Zufallsberechnung Zerstörung
        // durch Feuer


        baukran.setGebaeudeListe(gebauedeListe); //Liste an Baukran geben, falls Gebaeude durch Aufwertrung oder Abriss entfernt wurden
        baukran.errichten(bauListe);
        baukran.abreissen(abrissListe);
        gebauedeListe=baukran.gibGebaeudeListe();
        abrissListe=baukran.gibAbrissListe();
        System.out.println(abrissListe);
        if (rundenzaehler % 5 == 0) {            //Umweltverschmutzung geht mit der Zeit langsam zurück (auch in den negativen Bereich, als kleiner Bonus + Change auf ein Event steigt mit der Zeit
            basisUmweltverschmutzung--;
            eventChance=eventChance+4;
            zufriedenheitsBoni++;

            if (gebauedeListe.isEmpty() && bauListe.isEmpty()) {
                verliereSpiel("Aufgrund Ihrer Unt\u00e4tigkeit wurden Sie gewaltsam abgesetzt!");
            }

            if (!umweltschaeden) {
                jahresZeit++;
            } else {
                zufallsZahl=(int) Math.floor(Math.random() * (umweltverschmutzung-2)+1);

                if (zufallsZahl < 15) {
                    jahresZeit++;
                }
            }
            /* Jahreszeitenwechsel
             *
             *
             *
             * */
            if (jahresZeit == 2) {
                weltHintergrund.setImage(winter);
                jahreszeitenFaktor=0.5;
                event.geschehen(98);
                dialogButtonStandard.setText("Wir werden es schaffen.");
                dialogButtonStandard.setVisible(true);
                new FlipInX(event_Dialogfenster).play();
                dialogFensterOeffnen();
                dialogFensterBild.setImage(dialogFensterWinter);
                dialogFensterBild.setVisible(true);

            }
            if (jahresZeit == 4) {
                weltHintergrund.setImage(sommer);
                jahresZeit=0;
                jahreszeitenFaktor=1;
                event.geschehen(97);
                dialogButtonStandard.setText("Wundervoll!");
                dialogButtonStandard.setVisible(true);
                new FlipInX(event_Dialogfenster).play();
                dialogFensterOeffnen();
                dialogFensterBild.setImage(dialogFensterSommer);
                dialogFensterBild.setVisible(true);
            }
        } //Ende Jahreszeiten

        if (abrissListe.isEmpty()) {
            feuer.setVisible(false);
        }

        //Zurücksetzung aller Werte, für Berechnung jener in dieser Runde
        einnahmen=basisEinkommen;
        zufriedenheit=grundZufriedenheit;
        umweltverschmutzung=basisUmweltverschmutzung;
        produktivitaetsboni=1;
        //zufriedenheitsBoni=grundZufriedenheitsBoni;
        wohnraum=basisWohnraum;
        sicherheit=basisSicherheit;
        loeschKraft=0;

        for (
                Building gebaeude : gebauedeListe) {
            zufriedenheit=zufriedenheit+gebaeude.gibZufriedenheitsBoni();
            produktivitaetsboni=produktivitaetsboni+gebaeude.gibProduktivitaetsBoni();
            einnahmen=(einnahmen+gebaeude.gibEinkommen() * produktivitaetsboni);
            einnahmen=Math.round(einnahmen * jahreszeitenFaktor);
            umweltverschmutzung=umweltverschmutzung+gebaeude.gibUmweltverschmutzung();
            wohnraum=wohnraum+gebaeude.gibWohnraum();
            sicherheit=sicherheit+gebaeude.gibSicherheit();
            loeschKraft=loeschKraft+gebaeude.gibloeschKraft();

        }
        if (forschungsPunkte == 2) {
            Musik.addeSound("Sound/1/Neue_Forschungen.wav");
            new Flash(buttonForschungsMenu).play();
            new Pulse(buttonForschungsMenu).play();
        }
        if (bevoelkerung > wohnraum) {
            Musik.addeSound("Sound/1/Betten_belegt_2.wav");
            zufriedenheit-=5;

            if (jahresZeit == 2) { //im Winter erfrieren alle Einwohner, die kein Bett haben.
                event.geschehen(bevoelkerung-wohnraum, "Aufgrund der K\u00e4lte sind unsere Obdachlosen Einwohner verstorben!", "Einwohner erfroren!");
                dialogButtonStandard.setText("Das h\u00e4tte nicht passieren d\u00fcrfen...");
                dialogButtonStandard.setVisible(true);
                new FlipInX(event_Dialogfenster).play();
                dialogFensterOeffnen();
                dialogFensterBild.setImage(dialogFensterWinter);
                dialogFensterBild.setVisible(true);
                bevoelkerung=bevoelkerung-event.gibTote();
            }
        } else if ((int) Math.round(bevoelkerung+(bevoelkerung / 2) * zufriedenheit / 1.5 / 100) > wohnraum) {
            bevoelkerung=wohnraum;            //Es können nicht mehr Leute einziehen, als Betten zur Verfügung stehen
            Musik.addeSound("Sound/1/Betten_belegt.wav");
        } else {
            bevoelkerung=(int) Math.round(bevoelkerung+(bevoelkerung / 2) * zufriedenheit / 1.5 / 100);
        }


        einnahmen=einnahmen * produktivitaetsboni;
        kontostand=kontostand+einnahmen;
        zufriedenheit=zufriedenheit+zufriedenheitsBoni;

        System.out.println("Löschkraft: ");
        System.out.println(loeschKraft);
        if (loeschKraft > 35) {
            feuerZerstoerungsWahrscheinlichkeit="Verschwindend gering";
        } else if (loeschKraft > 30) {
            feuerZerstoerungsWahrscheinlichkeit="Gering";
        } else if (loeschKraft > 20) {
            feuerZerstoerungsWahrscheinlichkeit="Ungewiss";
        } else if (loeschKraft > 15) {
            feuerZerstoerungsWahrscheinlichkeit="Moderat";
        } else if (loeschKraft > 10) {
            feuerZerstoerungsWahrscheinlichkeit="Hoch";
        } else if (loeschKraft > 5) {
            feuerZerstoerungsWahrscheinlichkeit="Extrem";
        } else if (loeschKraft < 5) {
            feuerZerstoerungsWahrscheinlichkeit="astronomisch Hoch";
        }

        if (umweltverschmutzung > 35) {
            zufriedenheit=zufriedenheit-umweltverschmutzung / 2;
            eventChance+=5; //Je schlimmer die Umweltbelastung, desto höher die Change auf ein Ereignis
            Musik.addeSound("Sound/1/Umweltbelastung.wav");
            labelUmweltverschmutzung.setTextFill(Color.rgb(255, 0, 0));
            new Flash(labelUmweltverschmutzung).play();
        } // end of if

        if (umweltverschmutzung > 45 && !umweltschaeden) { //Soll nur bei Aktivierung angezeigt werden, nicht jede Runde
            umweltschaeden=true;
            event.geschehen(95);
            dialogButtonStandard.setText("Was haben wir nur angerrichtet?!");
            dialogButtonStandard.setVisible(true);
            new FlipInX(event_Dialogfenster).play();
            dialogFensterOeffnen();
            dialogFensterBild.setVisible(true);
            dialogFensterBild.setImage(dialogFensterKlimawandel);

        } else if (umweltverschmutzung < 20 && umweltschaeden) {
            umweltschaeden=false;
            event.geschehen(96);
            dialogButtonStandard.setText("Das war knapp!");
            dialogButtonStandard.setVisible(true);
            new FlipInX(event_Dialogfenster).play();
            dialogFensterOeffnen();
            dialogFensterBild.setImage(dialogFensterKlimaschutz);
            dialogFensterBild.setVisible(true);

        }
        if (wohnraum-bevoelkerung > 0) {

            zufriedenheit=zufriedenheit+2 * (wohnraum-bevoelkerung);
        }
        if (zufriedenheit <= 0) {
            ultimatum--;
            ultimatumsPane.setVisible(true);
            labelUltimatum.setText("Drohende Niederlage. Ultimatum: "+ultimatum+" Runden");
            Musik.addeSound("Sound/1/Ultimatum.wav");

        } else if (zufriedenheit > 0 && ultimatum != basisUltimatum && kontostand > 0) {

            ultimatum=basisUltimatum;
            ultimatumsPane.setVisible(false);
            Musik.addeSound("Sound/1/Ultimatum_erfuellt.wav");
        }

        if (zufriedenheit <= 0 && ultimatum == 0) {
            zufallsZahl=(int) Math.floor(Math.random() * (40-2)+1);
            if (zufallsZahl > sicherheit) {
                verliereSpiel("Grund: Aufgrund der hohen Unzufriedenheit wurdest du gewaltsam deines Amtes enthoben.");
            } else {
                polizeiEingriff();
            }

        }

        //Verhindern, dass die Zufriedenheit zu tief sinkt oder zu weit steigt
        if (zufriedenheit > 100) {
            zufriedenheit=100;
        }

        if (bevoelkerung <= 0) {
            verliereSpiel("Grund: Keine Einwohner mehr.");

        }


        if (kontostand <= 0 && ultimatum == 0) {
            zufallsZahl=(int) Math.floor(Math.random() * (30-2)+1);
            System.out.println(zufallsZahl);
            System.out.println(sicherheit);
            if (zufallsZahl > sicherheit) {
                verliereSpiel("Grund: Zu stark verschuldet.");
            } else {
                polizeiEingriff();
            }


        } else if (kontostand >= -2000 && kontostand < 0) {
            Musik.addeSound("Sound/1/Verschuldung.wav");
            labelUltimatum.setText("Hohe Verschuldung. Ultimatum stagniert. Weitere Verschuldung verhindern! ");
        } else if (kontostand <= -2000 && ultimatum > 0) {
            ultimatum--;
            ultimatumsPane.setVisible(true);
            labelUltimatum.setText("Drohende Niederlage. Ultimatum: "+ultimatum+" Runden");
            Musik.addeSound("Sound/1/Ultimatum.wav");

        } else if (kontostand > 0 && ultimatum != basisUltimatum) {
            ultimatum=3;
            ultimatumsPane.setVisible(false);
            Musik.addeSound("Sound/1/Ultimatum_erfuellt.wav");
        }


        labelsUpdaten(); //aktuallisiert Infoleiste
        Musik.spieleSound();


        /* zufällige Ereignisse prüfen und ausführen
         *
         * "EVENTS"
         *
         *
         * */

        if (!event_Dialogfenster.isVisible()) {
            zufallsZahl=(int) Math.floor(Math.random() * (100-2)+1);

            if (zufallsZahl <= eventChance) {
                Musik.stop();
                zufallsZahl=(int) Math.floor(Math.random() * (23-2)+1);
                dialogButtonStandard.setText("Das sind schlechte Neuigkeiten...");
                event.geschehen(zufallsZahl);
                eventChance=eventChance-10; //nicht zu viele Events hintereinander
                kontostand=kontostand-event.gibRepKosten();
                zufriedenheitsBoni+=event.gibZufriedenheitsMali();
                //grundZufriedenheitsBoni+=event.gibZufriedenheitsMali();
                zufriedenheit=zufriedenheit+zufriedenheitsBoni;
                bevoelkerung=bevoelkerung-event.gibTote();

                new FlipInX(event_Dialogfenster).play();
                dialogFensterOeffnen();

                if (event.gibEventType() == 2) {
                    mainPane.setDisable(true);
                    dialogButtonStandard.setVisible(false);
                    dialogButtonInteraktiv.setVisible(true);
                    dialogButtonInteraktiv.setText("Was zum?!");
                } else if (event.gibEventType() == 3) {
                    dialogButtonStandard.setVisible(true);
                    dialogButtonInteraktiv.setVisible(false);
                    if (!gebauedeListe.isEmpty()) {
                        Building brennend=(gebauedeListe.get((int) Math.floor(Math.random() * (gebauedeListe.size()-2)+1)));
                        System.out.println(brennend);
                        for (ImageView bauplatz : ListImage) {
                            if (brennend.gibBauplatzID().equals(bauplatz.getId())) {
                                feuer.setLayoutX(bauplatz.getLayoutX());
                                feuer.setLayoutY(bauplatz.getLayoutY()+verschiebFeuer);
                                feuer.setVisible(true);
                                brennend.setBrennt(true);
                                abrissListe.add(brennend);
                                Musik.addeSound("Sound/1/Building_burning.wav");
                                System.out.println("Gebäude in Brand!");

                            }
                        }

                    }
                } else if (event.gibEventType() == 4) {
                    mainPane.setDisable(true);
                    dialogButtonStandard.setVisible(false);
                    dialogButtonInteraktiv.setVisible(true);
                    dialogButtonInteraktiv.setText("Erstaunlich!");
                    dialogFensterBild.setImage(dialogFensterPositiv);
                    dialogFensterBild.setVisible(true);
                    event_DialogName.setTextFill(Color.BLACK);
                    event_DialogBeschreibung.setTextFill(Color.BLACK);
                } else {
                    dialogButtonStandard.setVisible(true);
                    dialogButtonInteraktiv.setVisible(false);
                }

                if (zufriedenheit < 0) {
                    starteAufstand();
                }
                labelsUpdaten();


            }

        }

    } //Ende der naechsten Runde Methode

    //Fraktionswahl
    public void waehleFraktionGDI() {
        fraktion=1;
        baukran.setFraktion(fraktion);
        event.setFraktion(fraktion);
        Musik.musik("Sound/"+fraktion+"/Hintergrund.wav", true, fraktion);
        Musik.musik("Sound/1/Auswahl.wav", false, fraktion);
        new FlipOutX(fraktionsWahl).play();

        for (ImageView bauplatz : ListImage) {
            bauplatz.setImage(bauPlatzGDI);
        }


        //Start Boni der GDI
        defaultWohngebaeude.setmaxLvl(1);
        defaultBildung.setmaxLvl(0);
        defaultEntertain.setmaxLvl(1);
        defaultIndustrie.setmaxLvl(0);

        Residential_Building residential_building=new Residential_Building();
        baukran.gebauedeListe.add(residential_building);

        //Spiel starten
        naechsteRunde();


    }

    public void waehleFraktionWardens() {
        fraktion=2;
        baukran.setFraktion(fraktion);
        event.setFraktion(fraktion);
        Musik.musik("Sound/"+fraktion+"/Hintergrund.wav", true, fraktion);
        Musik.musik("Sound/2/Auswahl.wav", false, fraktion);
        new FlipOutX(fraktionsWahl).play();

        for (ImageView bauplatz : ListImage) {
            bauplatz.setImage(bauPlatzNOD);
        }

        //Start Boni der Wardens
        defaultWohngebaeude.setmaxLvl(1);
        defaultBildung.setmaxLvl(0);
        defaultEntertain.setmaxLvl(0);
        defaultIndustrie.setmaxLvl(1);

        Industrial_Building bonusBuilding=new Industrial_Building();
        baukran.gebauedeListe.add(bonusBuilding);

        //Spiel starten
        naechsteRunde();

    }

    /*
     * Finn W. und Colin
     *
     *
     *
     *
     */

    public void menuBauPlatz() {
        bauMenuAuswahlPane.setVisible(false); //Menü wird ausgeblendet, sobald man auf einen anderen Bauplatz klickt
        aufwertMenu.setVisible(false);

        buttonFound=false;
        verschieb=144;
        for (ImageView iv : ListImage) {
            if (iv.isHover()) {           //Wenn bereits an Position (da Menü z.B. bereits geöffnet wurde, dann Sichtbarkeit umkehren, um das Menü ein- und auszublenden
                whereAmIIm=iv;
                if ((whereAmIIm.getLayoutX()-1290 > 0)) {
                    verschieb=-264;
                }
                if (iv.getLayoutX()+verschieb == bauUndInfoPane.getLayoutX() && iv.getLayoutY() == bauUndInfoPane.getLayoutY()) {
                    bauUndInfoPane.setVisible(!bauUndInfoPane.isVisible());
                } else {                                 //wenn nicht bereits an Positon: Sichtbarkeit ein + an Position bringen um Bau und Info Menü anzuzeigen
                    bauUndInfoPane.setLayoutX(iv.getLayoutX()+verschieb);
                    bauUndInfoPane.setLayoutY(iv.getLayoutY());
                    bauUndInfoPane.setVisible(true);
                    new ZoomIn(bauUndInfoPane).play();

                }


            }


        }


        updatebauPlatz();

    }

    /* Info Fenster zu Gebäude aktivieren und beschriften
     *
     *
     * Finn W. und Colin B.
     *
     * */

    public void destroyBuilding(Building gebaeude) {
        gebaeude.setLevel(0);
    }

    public void updatebauPlatz() {
        //Farben zurücksetzen
        bauUndInfoPane.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        aufwertMenu.setBackground(new Background(new BackgroundFill(Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
        bauUndInfoPaneProduktionLabel.setTextFill(Color.BLACK);

        //Texte zurücksetzen
        aufwertMenuFrageLabel.setText("M\u00f6chten Sie wirklich aufwerten?");
        aufWertMenuTitelLabel.setText("Aufwertung");
        buttonAufwerten.setText("Ja!");
        aufwertMenuButton.setText("Aufwerten");
        aufWertMenuWahrscheinlichkeitsLabel.setVisible(false);


        for (Building gebaeude : bauListe) {                        //Geht alle Gebaeude in der bauListe durch, werden gebaut, haben also das baurabeiten Image
            if (!buttonFound) {

                if (whereAmIIm.getImage().equals(bauarbeiten) && whereAmIIm.getId().equals(gebaeude.gibBauplatzID())) {
                    //Bau und Info Pane Beschriftung
                    bauUndInfoPaneBauButton.setDisable(true);

                    bauUndInfoPaneZufriedenheitsboniLabel.setText(" ");
                    bauUndInfoPaneProduktionLabel.setText(" ");
                    bauUndInfoPaneProduktionsboniLabel.setText(" ");
                    bauUndInfoPaneTypeLabel.setText("Geb\u00e4udetyp: "+gebaeude.gibGebaeudeTyp());
                    bauUndInfoPaneTitelLabel.setText("Wird gebaut...");
                    new Flip(bauUndInfoPaneTitelLabel).play();

                    bauUndInfoPaneVerschmutzungsLabel.setText("");
                    bauUndInfoPaneLevelLabel.setText("Runden bis Fertigstellung: "+(gebaeude.gibmaxLvl()-gebaeude.gibLevel()));
                    bauUndInfoPaneWohnraumLabel.setText(" ");
                    Musik.musik("Sound/Baustelle.wav", false, fraktion);
                    //Aufwertmenü Beschriftung
                    aufwertMenuButton.setDisable(true);
                    buttonAufwerten.setDisable(true);

                    buttonFound=true;
                }
            }
        }
        for (Building gebaeude : gebauedeListe) {

            if (!buttonFound) {
                if (whereAmIIm.getImage().equals(gebaeude.builtImage)) {
                    if (!gebaeude.getBrennt()) {
                        //Bau und Info Pane Beschriftung
                        bauUndInfoPaneBauButton.setDisable(true);
                        abrissButton.setDisable(false);

                        bauUndInfoPaneZufriedenheitsboniLabel.setText("Zufriedenheitsboni: "+gebaeude.gibZufriedenheitsBoni());
                        bauUndInfoPaneProduktionLabel.setText("Produktion pro Runde: "+gebaeude.gibEinkommen());
                        bauUndInfoPaneProduktionsboniLabel.setText("Produktionsboni: "+gebaeude.gibProduktivitaetsBoni());
                        bauUndInfoPaneTypeLabel.setText("Geb\u00e4udetyp: "+gebaeude.gibGebaeudeTyp());
                        bauUndInfoPaneTitelLabel.setText(gebaeude.gibGebaeudeTyp());
                        bauUndInfoPaneVerschmutzungsLabel.setText("Umweltverschmutzung: "+gebaeude.gibUmweltverschmutzung());
                        bauUndInfoPaneLevelLabel.setText("Geb\u00e4udelevel: "+gebaeude.gibLevel());
                        bauUndInfoPaneWohnraumLabel.setText("Wohnraum: "+gebaeude.gibWohnraum());
                        //Aufwertmenü Beschriftung
                        aufwertMenuButton.setDisable(false);
                        buttonAufwerten.setDisable(true);

                        //Anklick Sounds
                        if (gebaeude.gibtyp().equals("Wohnhaus")) {
                            Musik.musik("Sound/Residential_Building.wav", false, fraktion);
                        } else if (gebaeude.gibtyp().equals("Bildung")) {
                            Musik.musik("Sound/Schule.wav", false, fraktion);
                        } else if (gebaeude.gibtyp().equals("Unterhaltung")) {
                            Musik.musik("Sound/Unterhaltung.wav", false, fraktion);
                        } else if (gebaeude.gibtyp().equals("Industrie")) {
                            Musik.musik("Sound/Industrie.wav", false, fraktion);
                        } else if (gebaeude.gibtyp().equals("Polizeiwache")) {
                            Musik.musik("Sound/Polizeiwache.wav", false, fraktion);
                            bauUndInfoPaneWohnraumLabel.setText("Sicherheit: "+gebaeude.gibSicherheit());
                        } else if (gebaeude.gibtyp().equals("Feuerwache")) {
                            Musik.musik("Sound/Feuerwache.wav", false, fraktion);
                            bauUndInfoPaneWohnraumLabel.setText("L\u00f6schkraft: "+gebaeude.gibloeschKraft());
                        }
                        Musik.spieleSound();
                        // Anklick Sounds Ende
                    } else {
                        //Gebäude brennt
                        aufWertMenuWahrscheinlichkeitsLabel.setVisible(true);
                        aufWertMenuWahrscheinlichkeitsLabel.setText(feuerZerstoerungsWahrscheinlichkeit);
                        aufWertMenuWahrscheinlichkeitsLabel.setTextFill(Color.WHITE);
                        new Flash(aufWertMenuWahrscheinlichkeitsLabel).play();
                        bauUndInfoPaneBauButton.setDisable(true);
                        bauUndInfoPaneZufriedenheitsboniLabel.setText("");
                        buttonAufwerten.setText("Maßnahmen ergreifen");
                        bauUndInfoPaneProduktionLabel.setTextFill(Color.WHITE);
                        bauUndInfoPaneProduktionLabel.setText("Geb\u00e4ude steht in Flammen!");
                        bauUndInfoPaneProduktionsboniLabel.setText("");
                        bauUndInfoPaneTypeLabel.setText("Geb\u00e4udetyp: "+gebaeude.gibGebaeudeTyp());
                        bauUndInfoPaneTitelLabel.setText(gebaeude.gibGebaeudeTyp());
                        bauUndInfoPaneVerschmutzungsLabel.setText(" ");
                        bauUndInfoPaneLevelLabel.setText("Geb\u00e4udelevel: "+gebaeude.gibLevel());
                        bauUndInfoPaneWohnraumLabel.setText(" ");
                        buttonAufwerten.setDisable(true);
                        abrissButton.setDisable(true);
                        bauUndInfoPane.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                        aufwertMenu.setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
                        aufwertungKostenLabel.setText("Einsatzkosten: "+gebaeude.gibBaupreis() * gebaeude.gibLevel() / 2);
                        aufwertungDauerLabel.setText("Wahrscheinlichkeit, dass das Geb\u00e4ude ohne Ma\u00dfnahmen zerst\u00f6rt wird:");
                        aufwertMenuFrageLabel.setText("M\u00f6chten Sie einen Sonderl\u00f6schtrupp schicken?");
                        aufWertMenuTitelLabel.setText("Ma\u00dfnahmen");
                        aufwertMenuButton.setDisable(false);
                        buttonAufwerten.setDisable(false);
                        aufwertMenuButton.setText("Ma\u00dfnahmen");
                        buttonAufwerten.setText("Ja!");
                        Musik.musik("Sound/1/Feuer_Alarm.wav", false, fraktion);


                    }

                    for (Building defaultBuilding : ListdefaultBuildings) {
                        if (defaultBuilding.gibGebaeudeTyp().equals(gebaeude.gibGebaeudeTyp()) && defaultBuilding.gibmaxLvl() > gebaeude.gibLevel()) {
                            buttonAufwerten.setDisable(false);
                        }
                    }
                    if (!gebaeude.getBrennt()) {
                        aufwertungDauerLabel.setText("Dauer in Runden bis Fertigstellung: "+String.valueOf(gebaeude.gibmaxLvl()-gebaeude.gibLevel()));
                        aufwertungLevelLabel.setText("Levelerh\u00f6hung auf: "+String.valueOf(gebaeude.gibLevel()+1));
                        aufwertungKostenLabel.setText("Kosten f\u00fcr Aufwertung: "+String.valueOf(gebaeude.gibBaupreis() * gebaeude.gibLevel()));


                    }
                    buttonFound=true;
                }
            }
        }


        if (!buttonFound) {
            //Bau und Info Pane Beschriftung
            bauUndInfoPaneBauButton.setDisable(false);

            bauUndInfoPaneTitelLabel.setText("Freier Bauplatz");
            bauUndInfoPaneVerschmutzungsLabel.setText("");
            bauUndInfoPaneLevelLabel.setText("");
            bauUndInfoPaneWohnraumLabel.setText("");
            bauUndInfoPaneZufriedenheitsboniLabel.setText("");
            bauUndInfoPaneProduktionLabel.setText("");
            bauUndInfoPaneProduktionsboniLabel.setText("");
            bauUndInfoPaneTypeLabel.setText("Hier k\u00f6nnte ihr Geb\u00e4ude stehen!");
            Musik.musik("Sound/Bauplatz.wav", false, fraktion);
            //Aufwertmenü Beschriftung
            aufwertMenuButton.setDisable(true);
            abrissButton.setDisable(true);
            buttonAufwerten.setDisable(true);
        }
    }


    public void bauPlatzBauMenuAufrufen() {

        for (Button bauButton : ListBauMenueButton) { //Alle Buttons ihre Beschreibung geben und wenn nötig (Forschung) disabeln
            for (Building gebaeude : ListdefaultBuildings) {
                if (bauButton.getId().contains(gebaeude.gibtyp())) {
                    if (gebaeude.gibmaxLvl() == 0) {
                        bauButton.setText("Noch nicht erforscht! \n Erforsche Level 1 zum freizuschalten \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        bauButton.setDisable(true);
                    } else {
                        /*------------BauButtons beschriften--------------*/
                        if (gebaeude.gibtyp().equals("Wohnhaus")) {
                            bauButton.setText(gebaeude.gibGebaeudeTyp()+"\n Lass deine Leute nicht im Regen stehen. \n Je mehr H\u00e4user, \n desto mehr Leute haben auch Platz. \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        } else if (gebaeude.gibtyp().equals("Industrie")) {
                            bauButton.setText(gebaeude.gibGebaeudeTyp()+"\n Gebe deiner Bev\u00f6lkerung Arbeit \n und kurble gleichzeitig dein Einkommen an! \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        } else if (gebaeude.gibtyp().equals("Bildung")) {
                            bauButton.setText(gebaeude.gibGebaeudeTyp()+"\n Bildung f\u00fcr die Kinder! \n Das wird die Leute fr\u00f6hlich stimmen! Au\u00dferdem \nerh\u00e4lst du pro Schule einen Produktionsbonus. \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        } else if (gebaeude.gibtyp().equals("Unterhaltung")) {
                            bauButton.setText(gebaeude.gibGebaeudeTyp()+"\n Freude ist das was die Leute fesselt. \n Freude und Spa\u00df! \n Erf\u00fclle Ihnen dies mit einem \n neuen Unterhaltungsgeb\u00e4ude! \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        } else if (gebaeude.gibtyp().equals("Feuerwache")) {
                            bauButton.setText(gebaeude.gibGebaeudeTyp()+"\n Erh\u00f6ht die Chance Geb\u00e4ude vor \n Zerst\u00f6rung durch Feuer zu bewahren. \n Kleiner Beliebheitsbonus. \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        } else if (gebaeude.gibtyp().equals("Polizeiwache")) {
                            bauButton.setText(gebaeude.gibGebaeudeTyp()+"\n Spendet Sicherheit in der Stadt. \n Verringert die Chance auf Ereignisse. \n Kann Niederlage tempor\u00e4r abwenden. \n Kosten zum Bauen: "+gebaeude.gibBaupreis());
                        }
                        /*-------------------------------------------------*/
                        bauButton.setDisable(false);
                    }
                }

            }
        }


        bauMenuAuswahlPane.setVisible(true);
        new ZoomIn(bauMenuAuswahlPane).play();
        new ZoomIn(bauMenuAuswahlPane2).play();
        bauMenuAuswahlPane.setDisable(false);
        bauMenuAuswahlPane2.setDisable(false);
        //bauMenuAuswahlPane.setLayoutX(bauUndInfoPane.getLayoutX()+273);              //Diese beiden Zeilen würden das Baumenue an die Position, des Bauplatzes bewegen -> aktuelles Problem: Skallierung
        //bauMenuAuswahlPane.setLayoutY(bauUndInfoPane.getLayoutY());
    }

    /*  Start Bau Methoden
     *
     * Finn W.
     *
     *
     * */


    public void baue(Building gebaeude) {
        kontostand=kontostand-gebaeude.gibKosten();
        new Pulse(labelGeld).play();
        bauListe.add(gebaeude);
        gebaeude.bauPlatzID=whereAmIIm.getId();
        whereAmIIm.setImage(bauarbeiten);
        gebaeude.bauPlatzBild=whereAmIIm;
        Musik.musik("Sound/"+fraktion+"/Wird_gebaut.wav", false, fraktion);
        bauUndInfoPaneBauButton.setDisable(true);
        schliesseBauMenu();
    }

    public void baueWohnGebaeude() {
        Residential_Building residential_Building=new Residential_Building();
        baue(residential_Building);
        labelsUpdaten();
    }

    public void baueIndustrieGebaude() {
        Industrial_Building industrial_Building=new Industrial_Building();
        baue(industrial_Building);
        labelsUpdaten();
    }

    public void baueBildungsGebaeude() {
        Education_Building education_Building=new Education_Building();
        baue(education_Building);
        labelsUpdaten();
    }

    public void baueUnterhaltungsGebaeude() {
        Entertainment_Building entertainment_Building=new Entertainment_Building();
        baue(entertainment_Building);
        labelsUpdaten();
    }

    public void baueFeuerwache() {
        Fire_Station fire_station=new Fire_Station();
        baue(fire_station);
        labelsUpdaten();
    }

    public void bauePolizeiwache() {
        Police_Station police_station=new Police_Station();
        baue(police_station);
        labelsUpdaten();
    }

    public void schliesseBauMenu() {
        new ZoomOut(bauUndInfoPane).play();
        new ZoomOut(bauMenuAuswahlPane).play();
        new ZoomOut(bauMenuAuswahlPane2).play();
        bauMenuAuswahlPane.setDisable(true);
        bauMenuAuswahlPane2.setDisable(true);
        //bauUndInfoPane.setVisible(false);
        // bauMenuAuswahlPane.setVisible(false);
    }
    /*  Ende Bau Methoden
     *
     *
     * */


    /*  Sonstige Methoden
     * Finn W. und Colin B.
     *
     *
     *
     * */

    public void abreissen() {
        for (Building gebaeude : gebauedeListe) {
            if (whereAmIIm.getId().equals(gebaeude.gibBauplatzID())) {
                kontostand=kontostand-gebaeude.gibBaupreis() * gebaeude.gibLevel();
                whereAmIIm.setImage(bauarbeiten);
                ;

                //In der Zeit des Umbaus wird das Building zu einer Baustelle und erst nach Fertigstellung wieder in die Buildingliste aufgenommen
                gebauedeListe.remove(gebaeude);
                abrissListe.add(gebaeude);
            }
        }
    }

    public void aufwerten() {

        // Methode zum aufwerten UND zum Löschen von Gebäuden im Falle eines Feuer

        for (Building gebaeude : gebauedeListe) {
            //Feuer
            if (whereAmIIm.getId().equals(gebaeude.gibBauplatzID())) {
                if (gebaeude.getBrennt()) {
                    kontostand=kontostand-(gebaeude.gibBaupreis() * gebaeude.gibLevel() / 2);
                    loescheBuilding(gebaeude);
                    Musik.spieleSound();
                }
                //Standard
                else {
                    kontostand=kontostand-gebaeude.gibBaupreis() * gebaeude.gibLevel();
                    whereAmIIm.setImage(bauarbeiten);
                    gebaeude.maxLvlUp();

                    //In der Zeit des Umbaus wird das Building zu einer Baustelle und erst nach Fertigstellung wieder in die Buildingliste aufgenommen
                    gebauedeListe.remove(gebaeude);
                    bauListe.add(gebaeude);
                }
            }
        }

        updatebauPlatz();
        bauUndInfoPane.setVisible(false);
        aufwertMenuAufruf();
        labelsUpdaten();
        Musik.musik("Sound/1/aufgewertet.wav", false, fraktion);


    }

    /* Infoleiste aktuallisieren
     *
     * Finn W.
     * */
    public void labelsUpdaten() {


        labelBeliebtheit.setText(String.valueOf(zufriedenheit));
        labelEinwohner.setText(String.valueOf(bevoelkerung));
        labelBetten.setText(String.valueOf(wohnraum));
        labelGeld.setText(String.valueOf(Math.round(kontostand)));
        labelBilanz.setText(String.valueOf(Math.round(einnahmen)));
        labelUmweltverschmutzung.setText(String.valueOf(umweltverschmutzung));
    }

    /*------------Forschung-Colin + (Finn: Animationen) --------------*/

    public void aufwertMenuAufruf() {
        int verschieb=407;
        if ((whereAmIIm.getLayoutX()-1290 > 0)) {
            verschieb=-482;
        }
        if ((whereAmIIm.getLayoutX()+verschieb) == aufwertMenu.getLayoutX() && whereAmIIm.getLayoutY() == aufwertMenu.getLayoutY()) {
            aufwertMenu.setVisible(!aufwertMenu.isVisible());

        } else {                                 //wenn nicht bereits an Positon: Sichtbarkeit ein + an Position bringen um Aufwertungsmenü Menü anzuzeigen
            aufwertMenu.setLayoutX(whereAmIIm.getLayoutX()+verschieb);
            aufwertMenu.setLayoutY(whereAmIIm.getLayoutY());
            aufwertMenu.setVisible(true);
            new Pulse(aufwertMenu).play();

        }

        // Aufwertmenü bereits bei Methode: "menuBauPlatz" beschriftet.

    }

    public void aufwertMenuSchliessen() {
        aufwertMenu.setVisible(false);
    }

    public void forschungsMenuAufruf() {                        //Öffnet oder schließt das Forschungsmenü basiered darauf ob es bereits geöffnet ist. Bei start des Programms ist es außerhalb des sehbaren Bildschirms aber nicht unsichtbar, da sonst beim "sichtbarmachen" der obersten Pane, untergeordnete Bestandteile unsichtbar bleiben.
        if (forschungsBaumMenu.getLayoutY() == 82) {
            forschungsBaumMenu.setVisible(!forschungsBaumMenu.isVisible());
        } else {
            forschungsBaumMenu.setLayoutY(82);
            forschungsBaumMenu.setVisible(true);
        }
        bauUndInfoPane.setVisible(false);
        bauMenuAuswahlPane.setVisible(false);
        aufwertMenu.setVisible(false);
        setSliderEpoche(1);
        forschungsPunkteLabel.setText("Forschungspunkte: "+forschungsPunkte);
        allForschungsbaum.setVisible(true);
        new ZoomIn(forschungsBaumMenu).play();
        updateForschungsButtons(defaultIndustrie, ListForschungAllButton);
    }


    public void allForschungsbaumAufruf() {                     //Öffnet den gesamten Forschungsbaum
        allForschungsbaum.setVisible(true);


    }

    public void einzelForschungsbaumAufruf() {                  //Öffnet einen Einzelnen Forschungsbaum, basierend auf welche Forschung man ausgewählt hat.
        allForschungsbaum.setVisible(false);
    }

    public void setSliderEpoche(int epoche) {                   //Genutzt um den Epochenslider mit samt der Buttons auf eine bestimmte Epoche zu setzen.
        derzeitigeEpoche=epoche;
        int i=0;
        epocheAngabe.setText("Epoche: "+derzeitigeEpoche);

        for (Button forschungButton : ListForschungAllButton) {

            forschungButton.setText("Level "+(i+derzeitigeEpoche));
            if (i == 3) i=0;
            else i++;
        }
        sliderEpoche.setValue(epoche);
    }

    public void updateForschungsButtons(Building defaults, List<Button> listButtons) {
        int lvl=defaults.gibmaxLvl();
        forschungsPunkteLabel.setText("Forschungspunkte: "+forschungsPunkte);
        if (listButtons.equals(ListForschungAllButton)) {
            updateForschungsButtons(defaultIndustrie, ListForschungIndustrieButton);
            updateForschungsButtons(defaultBildung, ListForschungBildungButton);
            updateForschungsButtons(defaultEntertain, ListForschungEntertainmentButton);
            updateForschungsButtons(defaultWohngebaeude, ListForschungWohnButton);
        } else {

            for (Button forschungsButton : listButtons) {
                if (!forschungsButton.getText().equals("Level "+(lvl+1))) {
                    forschungsButton.setDisable(true);
                } else {
                    forschungsButton.setDisable(false);
                }
            }
        }

    }

    public void epochenWechsel() {                              //Ändert aktiv, beim verändern des Sliders die Buttons.
        setSliderEpoche((int) sliderEpoche.getValue());
        updateForschungsButtons(defaultIndustrie, ListForschungAllButton);
    }

    public void forschung(Building fG) {                        // fG bedeutet: forschungs Gebiet. Methode führt die Erhöhung des maximalen Levels eines Gebäudes aus.
        fG.maxLvlUp();
        forschungsPunkte-=2;
    }

    public void forschungIndustry() {
        if (forschungsPunkte-2 >= 0) {
            Musik.addeSound("Sound/1/Forschung_abgeschlossen.wav");
            Musik.spieleSound();
            forschung(defaultIndustrie);
            updateForschungsButtons(defaultIndustrie, ListForschungIndustrieButton);
            if (defaultIndustrie.gibmaxLvl() >= 2) kontostand-=(1100 * (3));
            else kontostand-=(1100 * (defaultIndustrie.gibmaxLvl()+1));
            labelsUpdaten();
        }
    }

    public void forschungBildung() {
        if (forschungsPunkte-2 >= 0) {
            Musik.addeSound("Sound/1/Forschung_abgeschlossen.wav");
            Musik.spieleSound();
            forschung(defaultBildung);
            updateForschungsButtons(defaultBildung, ListForschungBildungButton);
            if (defaultBildung.gibmaxLvl() >= 2) kontostand-=(1000 * (3));
            else kontostand-=(1000 * (defaultBildung.gibmaxLvl()+1));
            labelsUpdaten();
        }
    }

    public void forschungEntertainment() {
        if (forschungsPunkte-2 >= 0) {
            Musik.addeSound("Sound/1/Forschung_abgeschlossen.wav");
            Musik.spieleSound();
            forschung(defaultEntertain);
            updateForschungsButtons(defaultEntertain, ListForschungEntertainmentButton);
            if (defaultWohngebaeude.gibmaxLvl() >= 2) kontostand-=(800 * (3));
            else kontostand-=(800 * (defaultEntertain.gibmaxLvl()+1));
            labelsUpdaten();
        }
    }

    public void forschungWohnung() {
        if (forschungsPunkte-2 >= 0) {
            Musik.addeSound("Sound/1/Forschung_abgeschlossen.wav");
            Musik.spieleSound();
            forschung(defaultWohngebaeude);
            updateForschungsButtons(defaultWohngebaeude, ListForschungWohnButton);
            if (defaultWohngebaeude.gibmaxLvl() >= 2) kontostand-=(2000 * (3));
            else kontostand-=(2000 * (defaultWohngebaeude.gibmaxLvl()+1));
            labelsUpdaten();
        }
    }

    /* Ende der Forschung */


    //Wird nach Start der Oberfläche aufgerufen
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fraktionsWahl.setVisible(true);
        ListdefaultBuildings.add(defaultIndustrie);
        ListdefaultBuildings.add(defaultBildung);
        ListdefaultBuildings.add(defaultEntertain);
        ListdefaultBuildings.add(defaultWohngebaeude);
        ListdefaultBuildings.add(defaultPolizeiWache);
        ListdefaultBuildings.add(defaultFeuerWache);

        //Trägt alle existierenden Bauplätze in eine Liste ein
        ListImage.add(bauplatz1);
        ListImage.add(bauplatz2);
        ListImage.add(bauplatz3);
        ListImage.add(bauplatz4);
        ListImage.add(bauplatz5);
        ListImage.add(bauplatz6);
        ListImage.add(bauplatz7);
        ListImage.add(bauplatz8);
        ListImage.add(bauplatz9);
        ListImage.add(bauplatz10);
        ListImage.add(bauplatz11);
        ListImage.add(bauplatz12);

        //Trägt alle exestierenden forschungsButtons in die jeweilige Liste ein
        ListForschungIndustrieButton.add(forschungbuttonIndustrie1);
        ListForschungIndustrieButton.add(forschungbuttonIndustrie2);
        ListForschungIndustrieButton.add(forschungbuttonIndustrie3);
        ListForschungIndustrieButton.add(forschungbuttonIndustrie4);

        ListForschungBildungButton.add(forschungbuttonBildung1);
        ListForschungBildungButton.add(forschungbuttonBildung2);
        ListForschungBildungButton.add(forschungbuttonBildung3);
        ListForschungBildungButton.add(forschungbuttonBildung4);

        ListForschungEntertainmentButton.add(forschungbuttonEntertainment1);
        ListForschungEntertainmentButton.add(forschungbuttonEntertainment2);
        ListForschungEntertainmentButton.add(forschungbuttonEntertainment3);
        ListForschungEntertainmentButton.add(forschungbuttonEntertainment4);

        ListForschungWohnButton.add(forschungbuttonWohnung1);
        ListForschungWohnButton.add(forschungbuttonWohnung2);
        ListForschungWohnButton.add(forschungbuttonWohnung3);
        ListForschungWohnButton.add(forschungbuttonWohnung4);

        ListForschungAllButton.addAll(ListForschungIndustrieButton);
        ListForschungAllButton.addAll(ListForschungBildungButton);
        ListForschungAllButton.addAll(ListForschungEntertainmentButton);
        ListForschungAllButton.addAll(ListForschungWohnButton);

        //Trägt alle existierenden bauMenü Buttons in eine Liste ein
        ListBauMenueButton.add(bauMenuWohnhausBauButton);
        ListBauMenueButton.add(bauMenuBildungsBauButton);
        ListBauMenueButton.add(bauMenuIndustrieBauButton);
        ListBauMenueButton.add(bauMenuUnterhaltungsBauButton);
        ListBauMenueButton.add(bauMenuFeuerwacheBauButton);
        ListBauMenueButton.add(bauMenuPolizeiwacheBauButton);

        defaultFeuerWache.setmaxLvl(7);
        defaultPolizeiWache.setmaxLvl(7);

    }

    /* Feature Methoden
     * Finn W.
     *
     * */

    public void dialogFensterSchliessen() {

        event_Dialogfenster.setVisible(false);
        naechsteRundeButton.setDisable(false);
    }

    public void loescheBuilding(Building gebaeude) {
        abrissListe.remove(gebaeude);
        gebaeude.setBrennt(false);
        feuer.setVisible(false);
        Musik.addeSound("Sound/1/Feuer_geloescht.wav");
        Musik.entferneSound("Sound/1/Building_burning.wav");
    }

    public void dialogFensterOeffnen() {
        event_Dialogfenster.setVisible(true);
        event_DialogName.setText(event.gibName());
        event_DialogBeschreibung.setText(event.gibInfo());
        naechsteRundeButton.setDisable(true);
    }

    public void wechsleBauMenu() {
        bauMenuAuswahlPane.setVisible(!bauMenuAuswahlPane.isVisible());
        bauMenuAuswahlPane2.setVisible(!bauMenuAuswahlPane2.isVisible());
        bauPlatzBauMenuAufrufen();
    }

    public void verliereSpiel(String grund) {
        sideBar.setVisible(false);
        dialogFensterSchliessen();
        event_Dialogfenster.setVisible(false);
        new ZoomIn(niederlagenPane).play();
        niederlagenPane.setVisible(true);
        mainPane.setDisable(false);
        labelGrundNiederlage.setText(grund);
        labelRundenNiederlage.setText("Runden \u00fcberlebt: "+rundenzaehler);
        sideBar.setVisible(false);
        event_Dialogfenster.setVisible(false);
        dialogFensterSchliessen();
        Musik.stop();
        Musik.musik("Sound/"+fraktion+"/Niederlage.wav", false, fraktion);
    }

    public void schliesseSpiel() {
        System.exit(0);
    }

    public void starteAufstand() {
        event.geschehen(99);
        zufriedenheit=0;
        kontostand=kontostand-event.gibRepKosten();
        bevoelkerung=bevoelkerung-event.gibTote();
        event_Dialogfenster.setVisible(true);
        event_DialogName.setText(event.gibName());
        event_DialogBeschreibung.setText(event.gibInfo());
        labelsUpdaten();

        if (kontostand < 0) {
            verliereSpiel("Grund: Du wurdest gewaltsam des Amtes enthoben.");
        }
    }

    public void polizeiEingriff() {
        event.geschehen(94);
        new FlipInX(event_Dialogfenster).play();
        dialogFensterOeffnen();
        dialogFensterBild.setImage(dialogFensterPolizei);
        dialogFensterBild.setVisible(true);
        event_Dialogfenster.setVisible(true);
        ultimatum=basisUltimatum;
        dialogButtonStandard.setVisible(true);
        dialogButtonStandard.setText("Das war knapp...");
        dialogButtonInteraktiv.setVisible(false);
    }
}


