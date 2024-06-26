import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse EndWorld.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class WEndWorld extends World
{

    /**
     * Konstruktor für Objekte der Klasse EndWorld
     * 
     */
    public WEndWorld()
    {    
        // Erstellt eine neue Welt mit 600x400 Zellen und einer Zell-Größe von 1x1 Pixeln.
        super(1200, 900, 1);
        GreenfootImage backround = new GreenfootImage("images/EndeWelt.jpg");
        setBackground(backround);
        this.addObject(new BYesButton(), 550, 496);
        this.addObject(new BNoButton(), 650, 496);
    }
}