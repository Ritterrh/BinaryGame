import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse ResumeButton.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BResumeButton extends Actor {
   private  FGameModManger gameManager = FGameModManger.getInstanc();

    public BResumeButton() {
    }

    public void act() {

        // Ergänzen Sie Ihren Quelltext hier...
        if (Greenfoot.mouseClicked(this)) {
            gameManager.loadfromAutoSave();
        }
    }
}
