import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse StartButton.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BStartButton extends Actor {
    FGameModManger gameManager = FGameModManger.getInstance();


    /**
     * Act - tut, was auch immer StartButton tun will. Diese Methode wird
     * aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */

    public BStartButton() {
        GreenfootImage backround  = gameManager.getImage("images/Start.jpg");
        setImage(backround);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.setSaveSelctScreen();
        }
    }
}