import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse NoButton.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class NoButton extends Actor
{
    World oldWorld = null;
    NoButton(World old)
    {
        oldWorld = old;
    }
    public void act() 
    {
        // Ergänzen Sie Ihren Quelltext hier...
        if(Greenfoot.mouseClicked(this))
        {
            if( oldWorld == null)
                 Greenfoot.setWorld(new BasedGame(0,0));
            else 
                Greenfoot.setWorld(oldWorld);
            }
    }    
}