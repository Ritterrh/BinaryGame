import greenfoot.*;

public class BEndGameButton extends Actor {

    FGameModManger gameManager = FGameModManger.getInstanc();



    public BEndGameButton() {

    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.autoSaveGame();
            gameManager.setCurrentWorld(5);
        }
    }

}