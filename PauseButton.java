import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse PauseButton.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class PauseButton extends Actor
{
    /**
     * Act - tut, was auch immer PauseButton tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    public void act() 
    {
        // Ergänzen Sie Ihren Quelltext hier...
        if(Greenfoot.mouseClicked(this))
        Greenfoot.setWorld(new PauseWorld(this.getWorld()));
    }    
}