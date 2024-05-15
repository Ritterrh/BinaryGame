import greenfoot.*;

public class BPauseButton extends Actor {

    private FGameModManger gameManager = FGameModManger.getInstanc();


    public BPauseButton() {
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameManager.autoSaveGame();
            gameManager.setCurrentWorld(4);
        }
    }
}