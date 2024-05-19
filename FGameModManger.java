import greenfoot.*;

/**
 * Write a description of class GameModManger here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class FGameModManger {

    private static FGameModManger instance;

    private FLoadGameState loadGameState = new FLoadGameState();
    private Logger log = Logger.getInstance();

    private FLoadFromAutoSave loadFromAutoSave;
    
    private WGameModeOne gameModeOne;
    
    private WGameModeTow gameModeTow;
    private WStartWelt startWelt;
    private WPauseWorld pauseWorld;
    private WSaveSelct saveSelct;
    private WLoding loding;
    private WEndWorld endWorld;

    int[] decimalArray;
    private int level = 0;
    private int points;
    private int levelstat;
    private int currentWorld;
    int gamemode;
    private boolean isRight;
    private boolean GameModeTowisRight;

    private String levelName;

    private int decimal;

    /**
     * Constructor for objects of class GameModManger
     */
    private FGameModManger() {

    }

    public void act() {

    }

    public static FGameModManger getInstance() {
        if (instance == null) {
            instance = new FGameModManger();
        }
        return instance;
    }

    public void gameInit() {
        log.call("GameModManger", "setCurrentWorld(1); wird aufgerufen");
        setCurrentWorld(2);
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
            this.levelstat = 0;
            startGame();
        }
    }



    public void checkInputGameModeOne(int userInput, int row, int col) {
        setIsRight(
                gameModeOne.checkUserInputGameModeOne(userInput, row -1));
        if (getIsRight()) {
            setPoints(getPoints() + 5);
            gameModeOne.removeAllObjectsInRow(row, col, Color.GREEN);
            levelUp();
        } else {
            setPoints(getPoints() - 2);
        }


        System.out.println("isRight" + getIsRight());
    }

    public void rowCommplet() {
      
    }

    public void allRowComplett() {
        setPoints(getPoints() + 8);
        setLevel(getLevel() + 1);
        levelstat = 0;
        startGame();
    }

    private void startGame() {
        if(Greenfoot.getRandomNumber(2) == 0){
            setGameModeOne();
        }else{
            setGameModeTow();
        }
    }

    public int getGameMode() {
        return gamemode;
    }

    public void loadfromSave() {
        setLevel(loadGameState.getLevel());
        setPoints(loadGameState.getPoints());
        System.out.println(getLevel());
        System.out.println(getPoints());
        startGame();
    }

    public void loadNewGame() {
        setLevel(0);
        setPoints(0);
        startGame();
    }

    public void setCurrentWorld(int CurrentWorld) {
        if (CurrentWorld == 1) {
            log.call("setCurrentWorld", "setStartScreen() wird aufgerufen");
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
        if (CurrentWorld == 7) {
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

    public int[] getdecimalArray() {
        return decimalArray;
    }

    public void setDecimalArray(int[] decimalArray) {
        this.decimalArray = decimalArray;
    }

    public boolean checkUserInputGameModeOne(int userInput, int rowIndex) {
        if (rowIndex >= 0 && rowIndex < decimalArray.length) {
            int correctDecimal = decimalArray[rowIndex];
            return userInput == correctDecimal;
        }

        return false;
    }

    public void loadfromAutoSave() {
        loadFromAutoSave = new FLoadFromAutoSave();
        setLevel(loadFromAutoSave.getLevel());
        setPoints(loadFromAutoSave.getPoints());
        startGame();
    }

    public void autoSaveGame() {
        log.call(levelName, levelName);
        new FUpdateAutoSave(this.getLevel(), this.getPoints());
    }

    public void saveGame() {
        // TODO: Implementierung fehlt
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    private void setLevel(int l) {
        level = l;
    }

    private void setPoints(int p) {
        points = p;
    }

    private void setIsRight(boolean isRight) {
        this.isRight = isRight;
    }

    public void setGameModeTow() {

        Greenfoot.setWorld(new WGameModeTow());

    }

    public void setGameModeOne() {
        this.gameModeOne = new WGameModeOne();
        Greenfoot.setWorld(this.gameModeOne);
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

    public void setGameModeTowisRight(boolean GameModeTowisRight) {
        this.GameModeTowisRight = GameModeTowisRight;
    }

    public void setDecimal(int decimal) {
        this.decimal = decimal;
    }

    public int getDecimal() {
        return decimal;
    }

    public boolean getGameModeTowisRight() {
        return GameModeTowisRight;
    }

    public GreenfootImage getImage(String path) {
        GreenfootImage image = new GreenfootImage(path);
        return image;
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


}