import greenfoot.*;

public class BSaveButton extends Actor {

     FGameModManger gameManager = FGameModManger.getInstance();


    BSaveButton() {
        GreenfootImage backround = gameManager.getImage("images/Speichern.jpg");
        setImage(backround);
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            String name = Greenfoot.ask("Gebe deinem Spiel stand einen Namen");
            gameManager.setLevelName(name);
            gameManager.saveGame();
        }
    }
}
