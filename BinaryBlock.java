import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse BinaryBlock.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class BinaryBlock extends Actor {
    private int id = 0;
    private Actor actorMouseOver = null;
    private int Wert = 0;
    private int SollWert = 0;
    private GreenfootImage ImageEins;
    private GreenfootImage ImageNull;
    private GreenfootImage ImageEinsOver;
    private GreenfootImage ImageNullOver;

    public BinaryBlock(int id, int Wert, int SollWert) {
        this.Wert = Wert;
        this.SollWert = SollWert;
        this.id = id;
        ImageEins = new GreenfootImage("blockEins.jpg");
        ImageNull = new GreenfootImage("blockNull.jpg");
        ImageEinsOver = new GreenfootImage("blockEinsOver.jpg");
        ImageNullOver = new GreenfootImage("blockNullOver.jpg");
        setImage(ImageNull);
    }

    /**
     * Act - tut, was auch immer BinaryBlock tun will. Diese Methode wird
     * aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */
    public void act() {
        MausKlickChangeValue();

        if (mouseOver(this)) {
            // was passiert beim Maus over
            if (Wert == 0) {
                setImage(ImageNullOver);
            } else {
                setImage(ImageEinsOver);
            }
        } else {
            // was passiert bei nicht Maus over
            if (Wert == 0) {
                setImage(ImageNull);
            } else {
                setImage(ImageEins);
            }
        }

    }

    public boolean MausKlickChangeValue() {
        if (Greenfoot.mouseClicked(this)) {
            if (Wert == 0)
                Wert = 1;
            else
                Wert = 0;

            return true;
        }

        return false;
    }

    private void mouseOwner() {
        if ((actorMouseOver == null || actorMouseOver.getWorld() == null)
                && Greenfoot.mouseMoved(this)) {
            actorMouseOver = this;
        } else if (actorMouseOver == this && Greenfoot.mouseMoved(null)
                && !Greenfoot.mouseMoved(this)) {
            actorMouseOver = null;
        }
    }

    public boolean mouseOver(Actor actor) {
        mouseOwner();
        return actorMouseOver == actor;
    }

    public int getId() {
        return id;
    }



}