import java.util.Date;

public class GaneSaveManger {

    private FLoadGameState gameState;

    /**
     * Constructor for objects of class GaneSaveManger
     */
    public GaneSaveManger() {
        // Spielzustand laden
        gameState = new FLoadGameState();


        // Auf Spielzustandsdaten zugreifen und anzeigen
       //TODO ID fertig machen int id = gameState.getId();
        String name = gameState.getName();
        Date lastSave = gameState.getLastSave();
        int level = gameState.getLevel();
        int points = gameState.getPoints();

        // Spielzustand anzeigen
       // System.out.println("ID: " + id);
       //   System.out.println("Name: " + name);
       //   System.out.println("Last Save: " + lastSave);
       //   System.out.println("Level: " + level);
       //   System.out.println("Points: " + points);
    }
}
