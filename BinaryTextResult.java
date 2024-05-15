import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse BinaryTextResult.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BinaryTextResult extends Actor
{
    private int Decimal;
    private GreenfootImage Image = null;
    private int GameMode;

    public BinaryTextResult()
    {
        this.Image = new GreenfootImage("BinaryTextResult.jpg");
    }
    
    /**
     * Act - tut, was auch immer BinaryTextResult tun will. Diese Methode wird aufgerufen, 
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden. 
     */

    public void act() 
    {   
        if (GameMode == 1) {
            if(Greenfoot.mouseClicked(this)){
                Greenfoot.ask("Bitte gebe die Dezimalzahl ein: ");
            }
        }

        // Ergänzen Sie Ihren Quelltext hier...
         int zahl = Decimal;
            String text = Integer.toString( zahl );
            Image.setColor(Color.BLUE);
            Image.setFont(new Font("Arial",28));
            Image.drawString(text,45,45);
            
            setImage(Image);
    }    

    public void setGameMode(int mode)
    {
        GameMode = mode;
    }
    
    
}