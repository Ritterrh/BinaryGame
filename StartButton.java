import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse StartButton.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class StartButton extends Actor
{
    /**
     * Act - tut, was auch immer StartButton tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */

    public StartButton(){
    }
    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
    {   
        
        Greenfoot.setWorld(new SaveSelct());
        /* System.out.println("Es passiert was wow :3"); */

    }  
}
}