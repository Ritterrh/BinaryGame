import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse LastSave.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BLastSave extends Actor {

    FGameModManger gameManager = FGameModManger.getInstance();

    public BLastSave() {
        GreenfootImage backround = gameManager.getImage("images/LetztSpielLaden.jpg");
        setImage(backround);
    }

    /**
     * Act - tut, was auch immer LastSave tun will. Diese Methode wird aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.loadfromAutoSave();
        }
    }
}
