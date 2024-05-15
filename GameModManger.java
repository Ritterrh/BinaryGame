import greenfoot.*;

/**
 * Write a description of class GameModManger here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class GameModManger extends Actor {
    // instance variables - replace the example below with your own
    private int gameMode;
    private int level;
    private int points;
    private BasedGame world;
    private int levelstat ;

    /**
     * Constructor for objects of class GameModManger
     */
    public GameModManger(BasedGame basedGame) {
        this.world = basedGame;

    }

    public void init() {
        switchGameMode(1);
        setPoints(0);
        setLevel(0);
    }

    public void GameMode() {
        Greenfoot.setWorld(new loding(level, points));
    }
    
    public int getGameMode() {
        return gameMode;
    }

    public int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    public int getPoints() {
        return points;
    }

    private void setPoints(int points) {
        this.points = points;
    }

    public void checkInput(int userInput, int row, int col) {

        boolean isRight = world.checkUserInput(userInput, row - 1);
        if (isRight) {
            setPoints(points + 5);
            world.removeAllObjectsInRow(row, col, Color.GREEN);
        } else {
            setPoints(points - 2);
        }
        levelUp(isRight);
        System.out.println("isRight" + isRight);
    }

    public void levelUp(boolean isRight) {
        if (isRight) {
            this.levelstat++;
        } else {
            this.levelstat++;
        }
        System.out.println("levelstat" + levelstat);
        while (this.levelstat == 7) {
            System.out.println("Level abgeschlossen" + levelstat);
            Greenfoot.delay(1000);
            switchGameMode(0);
            this.level = this.level + 1;
           }
    }

    public void switchGameMode(int gameMode) {
        switch (gameMode) {
            case 0:
                GameMode();
                break;
            case 1:
                world.GameModeOne();
                break;
            case 2:
                world.GameModeTow();
                break;
            default:
                world.GameModeOne();
                break;
        }
    }
}