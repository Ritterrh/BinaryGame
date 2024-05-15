import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse LastSave.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class LastSave extends Actor {
    private int lastLevel;
    private int lastPoints;
    private LoadGameState loadGameState = new LoadGameState();

    public LastSave() {
        this.lastLevel = loadGameState.getLevel();
        this.lastPoints = loadGameState.getPoints();
    }

    /**
     * Act - tut, was auch immer LastSave tun will. Diese Methode wird aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */

    public void act() {
        System.out.println("LastSave"+ this.lastLevel + " " + this.lastPoints);
        if (Greenfoot.mouseClicked(this)) {
            Greenfoot.setWorld(new loding(this.lastLevel, this.lastPoints));
        }
    }
}
