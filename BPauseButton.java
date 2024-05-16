import greenfoot.*;

public class BPauseButton extends Actor {

     FGameModManger gameManager = FGameModManger.getInstance();


    public BPauseButton() {
        GreenfootImage backround = gameManager.getImage("images/Pause.jpg");
        setImage(backround);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.autoSaveGame();
            gameManager.setCurrentWorld(6);
        }
    }
}