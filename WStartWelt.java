import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)


public class WStartWelt extends World {

    FGameModManger gameManager = FGameModManger.getInstance();

    public WStartWelt() {

        super(1200, 900, 1);
        GreenfootImage background = gameManager.getImage("images/StartWelt.jpg");
        setBackground(background);
        addObject(new BStartButton(), 588, 480);

    }

}