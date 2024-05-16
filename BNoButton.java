import greenfoot.*;

public class BNoButton extends Actor {
    FGameModManger gameManager = FGameModManger.getInstance();


    BNoButton() {
        
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (gameManager.getCurrentWorld() == null) {
                // TODO implement go back to the main menu and show error message
            } else {
                gameManager.setCurrentWorld(1);
            }
        }
    }
}
