import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse NoButton.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BNoButton extends Actor {
    World oldWorld = null;

    BNoButton(World old) {
        oldWorld = old;
    }

    public void act() {
        // Ergänzen Sie Ihren Quelltext hier...
        if (Greenfoot.mouseClicked(this)) {
            if (oldWorld == null) {
                //TODO implement go back to the main menu and show error message
            } else
            {
            //TODO: implement functionality to go back to the old world (bzw create new world and set the level pointer to the new level)

            }
        }
    }
}
