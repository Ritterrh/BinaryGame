import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class initGame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class WInitGame extends World {
    private Logger log;
    private FMessage infotext = new FMessage();

    /**
     * Constructor for objects of class initGame.
     * 
     */
    public WInitGame() {
        super(600, 400, 1);
        this.log = Logger.getInstance();
        log.call("InitGame", "logger.getInstance() String log wurde die loggerInstance hinzugefügt");
   
        log.call("InitGame",
                " infotext.showText(\"Spiel wird geladen\", this, 300, 200, 24, null, Color.WHITE); wird aufgerufen");
        infotext.showText("Spiel wird geladen", this, 300, 200, 24, null, Color.WHITE);
        Greenfoot.start();
        log.log("Game is starting", "green");
        log.call("InitGame", "prepare()");
        prepare();
    }

    private void prepare() {
        log.call("InitGame", "new GameModManger(); wird aufgerufen");
        FGameModManger.getInstanc();

    }
}
