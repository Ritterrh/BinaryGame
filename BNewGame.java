import greenfoot.*;

public class BNewGame extends Actor {
    FGameModManger gameManager = FGameModManger.getInstance();


    public BNewGame() {
        GreenfootImage backround  = gameManager.getImage("images/NeuesSpiel.jpg");
        setImage(backround);
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            gameManager.loadNewGame();
        }
    }
}
