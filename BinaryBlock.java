import greenfoot.*;
import java.util.Random;

public class BinaryBlock extends Actor {
    private int istState; // Aktueller Zustand des Blocks (0 oder 1)
    private int sollState; // Gewünschter Zustand des Blocks (0 oder 1)

    public BinaryBlock() {
        // Initialisiere den Block mit einem zufälligen istState
        Random rand = new Random();
        istState = rand.nextInt(2);
        sollState = 0; // Startwert für den sollState (kann später aktualisiert werden)
        updateColor();
    }

    // Setze den aktuellen und den gewünschten Zustand des Blocks
    public void setStates(int istState, int sollState) {
        this.istState = istState;
        this.sollState = sollState;
        updateColor();
    }

    public void act() {
        mouseClickChangeValue(); // Rufe die Methode zur Verarbeitung des Mausklicks auf
    }

    // Methode zur Verarbeitung des Mausklicks
    public void mouseClickChangeValue() {
        if (Greenfoot.mouseClicked(this)) {
            // Ändere den Zustand des Blocks, wenn er angeklickt wird
            if (istState == 0) {
                setIstState(1);
            } else {
                setIstState(0);
            }
        }
    }

    // 
    // Überprüfe, ob der aktuelle Zustand mit dem gewünschten Zustand übereinstimmt
    public boolean isCorrectState() {
        return istState == sollState;
    }

    // Aktualisiere die Farbe des Blocks basierend auf seinem Zustand
    private void updateColor() {
        if (istState == 1) {
            if (isCorrectState()) {
                setImage("blockEinsGreen.jpg"); // Grüner Block für den Zustand 1 und korrekten Zustand
            } else {
                setImage("blockEins.jpg"); // Orangefarbener Block für den Zustand 1 und inkorrekten Zustand
            }
        } else {
            if (isCorrectState()) {
                setImage("blockNullGreen.jpg"); // Blauer Block für den Zustand 0 und korrekten Zustand
            } else {
                setImage("blockNull.jpg"); // Orangefarbener Block für den Zustand 0 und inkorrekten Zustand
            }
        }
    }

    // Setze den aktuellen Zustand des Blocks
    public void setIstState(int state) {
        istState = state;
        updateColor();
    }

    // Gib den aktuellen Zustand des Blocks zurück
    public int getIstState() {
        return istState;
    }

    // Gib den gewünschten Zustand des Blocks zurück
    public int getSollState() {
        return sollState;
    }

    public void setColor(Color green) {

    }
}
