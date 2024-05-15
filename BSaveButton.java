
import java.time.LocalDate;
import java.time.ZoneId;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class SaveButton here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BSaveButton extends Actor {
    
    private GameModeOne world = (GameModeOne) getWorld();
    
    BSaveButton() {
        
    }
    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            String name = Greenfoot.ask("Gebe deinem Spiel stand einen Namen");
           //TODO: implement functionality to save the game 
        }
    }


}
