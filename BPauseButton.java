import greenfoot.*;

public class BPauseButton extends Actor {

    private FGameModManger gameModManger;

    public BPauseButton() {
        gameModManger = FGameModManger.getInstanc();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameModManger.autoSaveGame();
            gameModManger.setCurrentWorld(4);
        }
    }
}