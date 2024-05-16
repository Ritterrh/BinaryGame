import greenfoot.*;

public class BNoButton extends Actor {
    FGameModManger gameManager = FGameModManger.getInstance();


    BNoButton() {
        GreenfootImage backround = new GreenfootImage("images/EndeNoButton.jpg");
        setImage(backround);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.loadfromAutoSave();
        }
    }
}
