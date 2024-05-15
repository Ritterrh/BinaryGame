import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Write a description of class message here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class message extends Actor
{
    private BasedGame game;
    private GreenfootImage textArea;
    private int textX;
    private int textY;
    private String text;
    public message() {

    }
    public void showText(String text , BasedGame game, int  textX, int textY, int size, Color forgroundColor, Color backroundColor)
    {
        this.textX = textX;
        this.textY = textY;
        this.text = text;
        this.game = game;
        removeTextImage(); // so this method can replace any previous text image shown
        GreenfootImage textImage = new GreenfootImage(text, size, forgroundColor, backroundColor );
        textArea = new GreenfootImage(textImage); // textImage used only to size the area
        textArea.drawImage(game.getBackground(), textX, textY); // replaces image with affected background area (to be retained)
        game.getBackground().drawImage(textImage, textX, textY); // draws text image on background image
    }

    public void removeTextImage()
    {
        if (textArea != null) game.getBackground().drawImage(textArea, textX, textY);
    }
}
