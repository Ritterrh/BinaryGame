import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse YesButton.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BYesButton extends Actor
{
    /**
     * Act - tut, was auch immer YesButton tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */
    public void act() 
    {
        
    if(Greenfoot.mouseClicked(this))
        {
                Greenfoot.setWorld(new WStartWelt());
        }
    }    
}