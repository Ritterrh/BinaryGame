import greenfoot.*;

public class BNewGame extends Actor {
    FGameModManger gameManager = FGameModManger.getInstanc();


    public BNewGame() {
        
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            gameManager.loadNewGame();
        }
    }
}
