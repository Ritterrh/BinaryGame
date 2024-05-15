import greenfoot.*;

public class BSaveButton extends Actor {

    private FGameModManger gameModManger = new FGameModManger();

    BSaveButton() {
        gameModManger = FGameModManger.getInstanc();
    }

    public void act() {

        if (Greenfoot.mouseClicked(this)) {
            String name = Greenfoot.ask("Gebe deinem Spiel stand einen Namen");
            gameModManger.setLevelName(name);
            gameModManger.saveGame();
        }
    }
}
