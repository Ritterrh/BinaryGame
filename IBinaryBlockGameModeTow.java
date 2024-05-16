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
    private GreenfootImage RightEins;
    private GreenfootImage RightNull;
    private boolean isBlockRight = false;
    private int Wert;

    public IBinaryBlockGameModeTow() {
        this.Wert = Greenfoot.getRandomNumber(2);
        ImageEins = new GreenfootImage("blockEins.jpg");
        ImageNull = new GreenfootImage("blockNull.jpg");
        ImageEinsOver = new GreenfootImage("blockEinsOver.jpg");
        ImageNullOver = new GreenfootImage("blockNullOver.jpg");
        RightEins = new GreenfootImage("blockEinsGreen.jpg");
        RightNull = new GreenfootImage("blockNullGreen.jpg");
        setImage(ImageNull);
    }

    /**
     * Act - tut, was auch immer BinaryBlock tun will. Diese Methode wird
     * aufgerufen,
     * sobald der 'Act' oder 'Run' Button in der Umgebung angeklickt werden.
     */
    public void act() {
        System.out.println("SollWert: " + SollWert + " Wert: " + Wert);
        if (!isBlockRight) {
            isMouseOver();
            MausKlickChangeValue();
        }

    }

    public enum BlockState {
        RIGHT, WRONG, NONE
    }

    private BlockState state = BlockState.NONE;

    private void updateImage() {
        switch (state) {
            case RIGHT:
                if (Wert == 0)
                    setImage(RightNull);
                else
                    setImage(RightEins);
                break;
            case NONE:
                if (Wert == 0) {
                    setImage(ImageNull);
                } else {
                    setImage(ImageEins);
                }
                break;
            default:
                if (Wert == 0) {
                    setImage(ImageNull);
                } else {
                    setImage(ImageEins);
                }
                break;
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

    // Methode zum Setzen des Zustands des Blocks
    public void setState(BlockState newState) {
        this.state = newState;
        updateImage(); // Aktualisiere das Bild nach dem Setzen des Zustands
    }

    // Methode zum Überprüfen des aktuellen Zustands des Blocks
    public BlockState getState() {
        return state;
    }

    // Methode zum Markieren des Blocks als richtig platziert
    public void setRight() {
        setState(BlockState.RIGHT);
    }

    public void setWert(int wert) {
        this.SollWert = wert;
    }

}
