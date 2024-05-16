import greenfoot.*;

public class BEndGameButton extends Actor {

    FGameModManger gameManager = FGameModManger.getInstance();



    public BEndGameButton() {
        GreenfootImage backround = gameManager.getImage("images/EndGame.jpg");
        setImage(backround);
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.autoSaveGame();
            gameManager.setCurrentWorld(5);
        }
    }

}