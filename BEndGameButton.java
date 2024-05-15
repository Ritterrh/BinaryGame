import greenfoot.*;

public class BEndGameButton extends Actor {

    private FGameModManger gameModManger;

    public BEndGameButton() {
        gameModManger = FGameModManger.getInstanc();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            gameModManger.autoSaveGame();
            gameModManger.setCurrentWorld(5);
        }
    }

}