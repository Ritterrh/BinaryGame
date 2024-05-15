import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class initGame here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class initGame extends World
{
    private CheckFileExistence checkFileExistence = new CheckFileExistence();
    private LoadGameConfig loadGameConfig = new LoadGameConfig();


    /**
     * Constructor for objects of class initGame.
     * 
     */
    public initGame()
    {    
        super(600, 400, 1); 
        Greenfoot.start();
        startup();
        prepare();
    }
    
 
    private void startup()
    {
           
        
        boolean gameConfigis = checkFileExistence.checkFileExistence("GameConfig.txt", "config/");
        boolean gameSave = checkFileExistence.checkFileExistence("GameSave.txt", "save/");
        if (gameConfigis) {
            Object gamestate = loadGameConfig.getGameConfig();
         //     System.out.println("Game Config" + gamestate.toString());    
         //     System.out.println("Game configuration exists");
        } else {
       //       System.out.println("Game configuration does not exist");
        }
        if(gameSave) {
       //       System.out.println("Game Save");
       //       System.out.println("Game save exists");
        } else {
         //     System.out.println("Game save does not exist");
        }
      Greenfoot.setWorld(new StartWelt());
    }
        /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
    }
}
