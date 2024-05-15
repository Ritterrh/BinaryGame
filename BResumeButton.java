import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse ResumeButton.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BResumeButton extends Actor
{
    /**
     * Act - tut, was auch immer ResumeButton tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    World oldWorld = null;
    
    public BResumeButton(World old)
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