import greenfoot.*;

public class BSaveButton extends Actor {

    private FGameModManger gameManager = FGameModManger.getInstanc();


    BSaveButton() {
    
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            String name = Greenfoot.ask("Gebe deinem Spiel stand einen Namen");
            gameManager.setLevelName(name);
            gameManager.saveGame();
        }
    }
}
