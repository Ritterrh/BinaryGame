import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse NoButton.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BNoButton extends Actor
{
    World oldWorld = null;
    BNoButton(World old)
    {
        oldWorld = old;
    }
    public void act() 
    {
        // Ergänzen Sie Ihren Quelltext hier...
        if(Greenfoot.mouseClicked(this))
        {
            if( oldWorld == null)
                 Greenfoot.setWorld(new BasedGame());
            else 
                Greenfoot.setWorld(oldWorld);
            }
    }    
}