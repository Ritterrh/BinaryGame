import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot und MouseInfo)

/**
 * Ergänzen Sie hier eine Beschreibung für die Klasse BinaryBlock.
 * 
 * @author (Ihr Name)
 * @version (eine Versionsnummer oder ein Datum)
 */
public class IBinaryBlockGameModeTow extends Actor {

    private FGameModManger gameManager = FGameModManger.getInstance();
    private Actor actorMouseOver = null;
    private int SollWert = 0;
    private GreenfootImage ImageEins;
    private GreenfootImage ImageNull;
    private GreenfootImage ImageEinsOver;
    private GreenfootImage ImageNullOver;
    private boolean isBlockRight = false;
    private int Wert;

    public IBinaryBlockGameModeTow() {
        this.Wert = Greenfoot.getRandomNumber(2);
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
        if (!isBlockRight) {
            isMouseOver();
            MausKlickChangeValue();
        }

    }

    public void isMouseOver() {
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

    public void setWert(int wert) {
        this.SollWert = wert;
        this.Wert = wert; // Update the Wert property as well
        if (this.Wert == 0) {
            setImage(ImageNull);
        } else {
            setImage(ImageEins);
        }
    }
}
