import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse StartWelt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class StartWelt extends World
{

    /**
     * Konstruktor für Objekte der Klasse StartWelt
     * 
     */
    public StartWelt()
    {    
        // Erstellt eine neue Welt mit 600x400 Zellen und einer Zell-Größe von 1x1 Pixeln.
        super(1200, 900, 1); 

        addObject(new StartButton(), 588, 480);

    }


}