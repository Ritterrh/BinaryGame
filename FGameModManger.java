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

    private FLoadFromAutoSave loadFromAutoSave;
    private FUpdateAutoSave updateAutoSave;

    private GameModeOne gameModeOne;
    private WGameModeTow gameModeTow;
    private WStartWelt startWelt;
    private WPauseWorld pauseWorld;
    private WSaveSelct saveSelct;
    private WLoding loding;
    private WEndWorld endWorld;

    private int level;
    private int points;
    private int levelstat;
    private int currentWorld;
    private int toworld = 0;

    private static boolean fgameModMangerInstace;
    private boolean isRight;

    private String levelName;

    /**
     * Constructor for objects of class GameModManger
     */
    public FGameModManger() {

    }

    public void act() {
        if (fgameModMangerInstace) {
            System.out.println("GameModManger wird gestoppt Irgeendwas ist schief gelaufen");
            Greenfoot.stop();
        }
        if (gameModManger != null) {
            System.out.println("GameModManger wird gestoppt Irgeendwas ist schief gelaufen");
            Greenfoot.stop();
        }
    }

    public static FGameModManger getInstanc() {
        if (gameModManger != null) {
            System.out.println("GameModManger ist schon erstellt");
        } else {
            if (!fgameModMangerInstace) {
                gameModManger = new FGameModManger();
                fgameModMangerInstace = true;
            }
            return gameModManger;
        }
        return gameModManger;
    }

    public void gameInit() {
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
       int gamemode = 1;
        // TODO Game Mode 2 int gamemode = Greenfoot.getRandomNumber(2);
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

    public void setCurrentWorld(int CurrentWorld) {
        if (CurrentWorld == 1) {
            setLoadingScreen();
        }
        if (CurrentWorld == 2) {
            setStartScreen();
        }
        if (CurrentWorld == 3) {
            setSaveSelctScreen();
        }
        if (CurrentWorld == 4) {
            setGameModeOne();
        }
        if (CurrentWorld == 5) {
            setGameModeTow();
        }
        if (CurrentWorld == 6) {
            setPauseScreen();
        }
        if (CurrentWorld == 67) {
            setEndScreen();
        }
    }

    public World getCurrentWorld() {
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
    public void loadfromAutoSave(){
        loadFromAutoSave = new FLoadFromAutoSave();
        setLevel(loadFromAutoSave.getLevel());
        setPoints(loadFromAutoSave.getPoints());
        startGame();
    }
    public void autoSaveGame() {
        updateAutoSave = new FUpdateAutoSave(getLevelName(), getLevel(), getPoints());
    }

    public void saveGame() {
        //TODO: Implementierung fehlt
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setPoints(int points) {
        this.points = points;
    }

    private void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public void setGameModeTow() {
        Greenfoot.setWorld(new WGameModeTow());
        setCurrentWorld(3);
    }

    public void setGameModeOne() {
        Greenfoot.setWorld(new GameModeOne());
        setCurrentWorld(2);
    }

    public void setStartScreen() {
        Greenfoot.setWorld(new WStartWelt());
        setCurrentWorld(1);
    }

    public void setPauseScreen() {
        Greenfoot.setWorld(new WPauseWorld());
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

    public String getLevelName() {
        return levelName;
    }

    private boolean getIsRight() {
        return isRight;
    }

    public int getPoints() {
        return points;
    }

    public int getLevel() {
        return level;
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