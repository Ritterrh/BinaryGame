import greenfoot.*;

public class BNoButton extends Actor {
    private FGameModManger gameModManger;

    BNoButton() {
        gameModManger = FGameModManger.getInstanc();
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (gameModManger.getCurrentWorld() == null) {
                // TODO implement go back to the main menu and show error message
            } else {
                gameModManger.setCurrentWorld(1);
            }
        }
    }
}
