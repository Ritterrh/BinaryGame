import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Save here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class WSave extends World
{
    /**
     * Constructor for objects of class Save.
     * 
     */
    public WSave()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.addObject(new BSaveButton(), 550, 496);
        this.addObject(new BDonotSaveButton(), 650, 496);
    }
}