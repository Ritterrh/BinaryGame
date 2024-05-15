import greenfoot.*;

/**
 * Write a description of class GameModManger here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FGameModManger extends Actor {

    private static FGameModManger gameModManger;


    private FCheckFileExistence checkFileExistence = new FCheckFileExistence();
    private FLoadGameConfig loadGameConfig = new FLoadGameConfig();
    private FLoadGameState loadGameState = new FLoadGameState();
    private Logger log = Logger.getInstance();


    private GameModeOne gameModeOne = new GameModeOne();
    private WGameModeTow gameModeTow = new WGameModeTow();
    private WStartWelt startWelt = new WStartWelt();
    private WPauseWorld pauseWorld;
    private WSaveSelct saveSelct = new WSaveSelct();
    private WLoding loding = new WLoding();
    private WEndWorld endWorld;

    private int level;
    private int points;
    private int levelstat;
    private int currentWorld;
    private int toworld = 0;

    private boolean isRight;

    /**
     * Constructor for objects of class GameModManger
     */
    public FGameModManger() {
        gameInit();
    }

    public static FGameModManger getInstanc() {
        if (gameModManger == null) {
            gameModManger = new FGameModManger();
        } else {
            return gameModManger;
        }
        return gameModManger;
    }
    public void gameInit() {
        setCurrentWorld(7);
        log.call("GameModManger", " gameinitFinshed(); wird aufgerufen");
        gameinitFinshed();
    }

    public void gameinitFinshed() {
        log.call("GameModManger", "setCurrentWorld(1); wird aufgerufen");
        setCurrentWorld(1);
    }

    public void levelUp() {
        if (getIsRight()) {
            this.levelstat++;
        } else {
            this.levelstat++;
        }

        while (this.levelstat == 7) {
            System.out.println("Level abgeschlossen" + levelstat);
            Greenfoot.delay(1000);
            setLevel(getLevel() + 1);
        }
    }

    public void checkInputGameModeOne(int userInput, int row, int col) {

        setIsRight(gameModeOne.checkUserInputGameModeOne(userInput, row - 1));
        if (getIsRight()) {
            setPoints(getPoints() + 5);
            gameModeOne.removeAllObjectsInRow(row, col, Color.GREEN);
        } else {
            setPoints(getPoints() - 2);
        }
        levelUp();

        System.out.println("isRight" + getIsRight());
    }

    private void startGame() {
        int gamemode = Greenfoot.getRandomNumber(2);
        switch (gamemode) {
            case 1:
                setGameModeOne();
                break;
            case 2:
                setGameModeTow();
                break;
            default:
                setGameModeOne();
                break;
        }
    }

    public void loadfromSave() {
        setLevel(loadGameState.getLevel());
        setPoints(loadGameState.getPoints());
        startGame();
    }

    public void loadNewGame() {
        setLevel(0);
        setPoints(0);
        startGame();
    }

    private void setCurrentWorld(int CurrentWorld) {
        if (CurrentWorld == currentWorld) {
            log.log("Die Angefodertet welt ist schon", "green");
            return;
        } else {
            log.log("Die Welt wird gewechselt", "green");
            currentWorld = CurrentWorld; // Update currentWorld here
        }
        switch (CurrentWorld) {
            case 1:
                setStartScreen();
            this.toworld = 0;
                break;
            case 2:
                setGameModeOne();
                this.toworld = 0;
                break;
            case 3:
                setGameModeTow();
                this.toworld = 0;
                break;
            case 4:
                setPauseScreen();
                this.toworld = 0;
                break;
            case 5:
                setEndScreen();
                this.toworld = 0;
                break;
            case 6:
                setSaveSelctScreen();
                this.toworld = 0;
                break;
            case 7:
                setLoadingScreen();
                this.toworld = 0;
                break;
            default:
                break;
        }
    }
    

    private World getCurrentWorld() {
        World returnWorld = null;
        switch (currentWorld) {
            case 1:
                returnWorld = startWelt;
                break;
            case 2:
                returnWorld = gameModeOne;
                break;
            case 3:
                returnWorld = gameModeTow;
                break;
            case 4:
                returnWorld = pauseWorld;
                break;
            case 5:
                returnWorld = endWorld;
                break;
            case 6:
                returnWorld = saveSelct;
                break;
            case 7:
                returnWorld = loding;
                break;
            default:
                break;
        }
        return returnWorld;
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

    private boolean getIsRight() {
        return isRight;
    }

    private void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public void setGameModeTow() {
        Greenfoot.setWorld(gameModeTow);
        setCurrentWorld(3);
    }

    public void setGameModeOne() {
        Greenfoot.setWorld(gameModeOne);
        setCurrentWorld(2);
    }

    public void setStartScreen() {
        Greenfoot.setWorld(startWelt);
        setCurrentWorld(1);
    }

    public void setPauseScreen() {
        Greenfoot.setWorld(pauseWorld);
        setCurrentWorld(4);
    }

    public void setEndScreen() {
        Greenfoot.setWorld(endWorld);
        setCurrentWorld(5);
    }

    public void setLoadingScreen() {
        Greenfoot.setWorld(loding);
        setCurrentWorld(7);
    }

    public void setSaveSelctScreen() {
        Greenfoot.setWorld(saveSelct);
        setCurrentWorld(6);
    }

    private World getGameModeTow() {
        return gameModeTow;
    }

    private World getGameModeOne() {
        return gameModeOne;
    }

    private World getStartScreen() {
        return startWelt;
    }

    private World getPauseScreen() {
        return pauseWorld;
    }

    private World getEndWorld() {
        return endWorld;
    }

    private World getLoading() {
        return loding;
    }

    private World getSaveSelcetWorld() {
        return saveSelct;
    }

}