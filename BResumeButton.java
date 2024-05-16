import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse ResumeButton.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BResumeButton extends Actor {
    FGameModManger gameManager = FGameModManger.getInstance();

    public BResumeButton() {
        GreenfootImage backround = gameManager.getImage("images/Resume.jpg");
        setImage(backround);
    }

    public void act() {

        // Ergänzen Sie Ihren Quelltext hier...
        if (Greenfoot.mouseClicked(this)) {
            gameManager.loadfromAutoSave();
        }
    }
}
