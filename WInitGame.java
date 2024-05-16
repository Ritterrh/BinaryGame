import greenfoot.*;

public class WInitGame extends World {

    FGameModManger gameManager = FGameModManger.getInstance();

    public WInitGame() {
        super(600, 400, 1);
        GreenfootImage backround = new GreenfootImage("images/Loading.jpg");
        setBackground(backround);
        gameManager.gameInit();
        prepare();
    }

    private void prepare() {
    }
}
