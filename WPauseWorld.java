import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse PauseWorld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class WPauseWorld extends World
{

    /**
     * Konstruktor für Objekte der Klasse PauseWorld
     * 
     */
    public WPauseWorld(World old)
    {    
        // Erstellt eine neue Welt mit 600x400 Zellen und einer Zell-Größe von 1x1 Pixeln.
        super(1200, 900, 1); 
        this.addObject(new BResumeButton(old), 600, 486);
        
    }
}