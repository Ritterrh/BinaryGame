import greenfoot.*;

/**
 * Write a description of class GameModManger here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FGameModManger  {

    private static FGameModManger instance;

    private FCheckFileExistence checkFileExistence = new FCheckFileExistence();
    private FLoadGameConfig loadGameConfig = new FLoadGameConfig();
    private FLoadGameState loadGameState = new FLoadGameState();
    private Logger log = Logger.getInstance();
    private FMessage infotext = new FMessage();

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

    private static boolean fgameModMangerInstace = false;
    private boolean isRight;

    private String levelName;

    /**
     * Constructor for objects of class GameModManger
     */
    public FGameModManger() {
        this.log = Logger.getInstance();
        log.call("InitGame", "logger.getInstance() String log wurde die loggerInstance hinzugefügt");
        log.log("Game is starting", "green");
        log.call("InitGame", "prepare()");
        gameInit();
  
    }
    public void act() {
        if(fgameModMangerInstace){
            Greenfoot.stop();
        }
    }
    public static synchronized FGameModManger getInstanc() {
        if (instance != null) {
            System.out.println("GameModManger ist schon erstellt");
        } else {
            if (!fgameModMangerInstace) {
                instance = new FGameModManger();
                fgameModMangerInstace = true;
            }
            return instance;
        }
        return instance;
    }

    public void gameInit() {
        log.call("GameModManger", "setCurrentWorld(1); wird aufgerufen");
        setStartScreen();

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

    }

    public void setGameModeOne() {
        Greenfoot.setWorld(new GameModeOne());

    }

    public void setStartScreen() {
        Greenfoot.setWorld(new WStartWelt());

    }

    public void setPauseScreen() {
        Greenfoot.setWorld(new WPauseWorld());

    }

    public void setEndScreen() {
        Greenfoot.setWorld(new WEndWorld());

    }

    public void setLoadingScreen() {
        Greenfoot.setWorld(new WLoding());

    }

    public void setSaveSelctScreen() {
        Greenfoot.setWorld(new WSaveSelct());

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