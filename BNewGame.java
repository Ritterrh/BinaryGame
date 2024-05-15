import greenfoot.*;

public class BNewGame extends Actor {
    private FGameModManger gameModManger;

    public BNewGame() {
        this.gameModManger = FGameModManger.getInstanc();
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            gameModManger.loadNewGame();
        }
    }
}
