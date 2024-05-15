import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse NewGame.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BNewGame extends Actor {
    private FGameModManger gameModManger;

    /**
     * Act - tut, was auch immer NewGame tun will. Diese Methode wird aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */

    public BNewGame() {
        this.gameModManger = FGameModManger.getInstanc();
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            gameModManger.loadNewGame();
        }
    }
}
