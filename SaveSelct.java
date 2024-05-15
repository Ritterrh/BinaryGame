import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse SaveSelct.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class SaveSelct extends World
{

    /**
     * Konstruktor für Objekte der Klasse SaveSelct
     * 
     */
    public SaveSelct()
    {    
        // Erstellt eine neue Welt mit 600x400 Zellen und einer Zell-Größe von 1x1 Pixeln.
        super(1200, 900, 1);
        this.addObject(new NewGame(), 500, 496);
        this.addObject(new LastSave(), 650, 496);

    }

}
