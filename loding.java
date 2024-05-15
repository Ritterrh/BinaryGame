import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class loding here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class loding extends World
{

    /**
     * Constructor for objects of class loding.
     * 
     */
    public loding(int level,int points)
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(474, 138, 1); 
        System.out.println("Level wird geladen " + level + "Punkte" + points);
        Greenfoot.setWorld(new BasedGame(level,points));
        System.out.println("Level wurde geladen" + level + "Punkte" + points);
    }
}
