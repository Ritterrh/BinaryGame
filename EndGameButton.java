
import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse EndGameButton.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class EndGameButton extends Actor {

    /**
     * Act - tut, was auch immer EndGameButton tun will. Diese Methode wird
     * aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */
    public EndGameButton() {

    }

    public void act() {
        // Ergänzen Sie Ihren Quelltext hier...
        if (Greenfoot.mouseClicked(this))
            Greenfoot.setWorld(new EndWorld(this.getWorld()));
    }

}