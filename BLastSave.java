import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse LastSave.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BLastSave extends Actor {

    private FGameModManger gameModManger;

    public BLastSave() {
        this.gameModManger = FGameModManger.getInstanc();
    }

    /**
     * Act - tut, was auch immer LastSave tun will. Diese Methode wird aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameModManger.loadfromSave();
        }
    }
}
