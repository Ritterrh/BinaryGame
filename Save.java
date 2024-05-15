import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Save here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Save extends World
{
    /**
     * Constructor for objects of class Save.
     * 
     */
    public Save(BasedGame world)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        this.addObject(new SaveButton(world), 550, 496);
        this.addObject(new DonotSaveButton(), 650, 496);
    }
}
