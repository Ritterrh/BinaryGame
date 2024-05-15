
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
            ZoneId zoneId = ZoneId.of("Europe/Berlin");
            LocalDate lastSave = LocalDate.now(zoneId);
            new  FUpdateGameState(name, lastSave, world.gameModManger.getLevel(), world.gameModManger.getPoints());
        }
    }


}
