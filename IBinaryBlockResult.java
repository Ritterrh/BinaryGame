
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse BinaryBlockResult.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class IBinaryBlockResult extends Actor
{
    /**
     * Variablen
     */

    private GreenfootImage BinaryNullGreen = null;
    private GreenfootImage BinaryEinsGreen = null;
    
    private int Wert = 0;
    private int NullOderEins = 0;

    
    IBinaryBlockResult(World world)
    {
        BinaryNullGreen =  new GreenfootImage("blockNullGreen.jpg");
        BinaryEinsGreen =  new GreenfootImage("blockEinsGreen.jpg");
        
        
    }
    
    public void act() 
    {
        if (NullOderEins== 0)
        {
            setImage(BinaryNullGreen);
        }
        else
        {          
            setImage(BinaryEinsGreen);
        }  
    }
    
    public void setNullOderEins (int NullOderEins){
        this.NullOderEins = NullOderEins;
    }
    public int getNullOderEins (){
        return NullOderEins;
    }
    public void setWert(int Wert)
    {
        this.Wert = Wert;
    }
    public int getWert()
    {
        return Wert;
    }
    public void reset()
    {
        Wert = 0;
    }
    
}