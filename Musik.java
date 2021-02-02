/**
 * Beschreibung: Zuständig für das Abspielen von Musik und Sounds
 * Jeder Sound wird ein eigener Thread -> Überlappung möglich
 *
 * @version 1.0 vom 05.06.2020
 * @Autor: Finn W.
 * Changelog: 28.6: Finn W. : Musik loopt jetzt zwischen 10 verschiedenen Tracks (leicht erweiterbar)
 * wie folgt: Fraktionstheme, random Track, Fraktionstheme, random Track usw.
 * . Denkbar und relativ simple wäre später noch der Loop, zwischen Fraktionsabhängigen Tracks
 */

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Musik {

    static boolean loop;
    static Set<String> soundListe=new HashSet<>();
    // static FloatControl volume;

    public static synchronized void musik(String pfad, boolean wiederholung, int fraktion) {

        loop=wiederholung;


        new Thread(new Runnable() {
            String zufallsPfad;
            int zufallsZahl;

            public void run() {
                do {
                    try {
                        Clip clip=AudioSystem.getClip();
                        AudioInputStream inputStream=AudioSystem.getAudioInputStream(new File(pfad));
                        clip.open(inputStream);
                        clip.start();
                        Thread.sleep(clip.getMicrosecondLength() / 1000);

                        while (wiederholung) {
                            zufallsZahl=(int) Math.floor(Math.random() * (10-2)+1);

                            if (zufallsZahl == 1) {
                                zufallsPfad=("Sound/1/V2BO1.wav");
                            } else if (zufallsZahl == 2) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO2.wav");
                            } else if (zufallsZahl == 3) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO3.wav");
                            } else if (zufallsZahl == 4) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO4.wav");
                            } else if (zufallsZahl == 5) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO5.wav");
                            } else if (zufallsZahl == 6) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO6.wav");
                            } else if (zufallsZahl == 7) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO7.wav");
                            } else if (zufallsZahl == 8) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO8.wav");
                            } else if (zufallsZahl == 9) {
                                zufallsPfad=("Sound/"+fraktion+"/V2BO9.wav");
                            } else if (zufallsZahl == 10) {
                                zufallsPfad=("Sound/"+fraktion+"/V2B10.wav");
                            }

                            clip.close();
                            inputStream=AudioSystem.getAudioInputStream(new File(zufallsPfad));
                            clip.open(inputStream);
                            clip.start();
                            Thread.sleep(clip.getMicrosecondLength() / 1000);
                            //clip.loop(clip.LOOP_CONTINUOUSLY);
                        }


                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Fehler");
                    }  // end of try
                }
                while (wiederholung); // end of while
            }
        }).start();

    }

    public static synchronized void spieleSound() {

//soundListe= list.stream()
     //   .distinct()
       // .collect(Collectors.toList());

        new Thread(new Runnable() {

            public void run() {

                synchronized(soundListe) {
                    //for (String sound : soundListe) {
                        soundListe.removeIf(e -> playSoundAndClearIt(e));
                    //}
                }

                stop();
            }

        }).

                start();

    }

    public static void stop() {
        soundListe.clear();
    }

    public static void addeSound(String pfad) {
        soundListe.add(pfad);
    }


    public static void entferneSound(String pfad) {
        soundListe.remove(pfad);
    }

    public static boolean playSoundAndClearIt(String pfad) {
        try {
            Clip clip=AudioSystem.getClip();
            AudioInputStream inputStream=AudioSystem.getAudioInputStream(new File(pfad));
            clip.open(inputStream);
            clip.start();
            Thread.sleep(clip.getMicrosecondLength() / 1000);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Fehler");
        }  // end of try
        return true;
    }
}
// end of class Musik

