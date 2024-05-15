import greenfoot.*;

public class BinaryTextBoxResult extends Actor {

    private GreenfootImage image; // Nur einmal initialisieren

    private String eingabe;
    private int vaules;
    private int row;
    private int col;
    private BasedGame world;

    public BinaryTextBoxResult(BasedGame basedGame, int row, int col) {
        this.col = col;
        this.row = row;
        this.world = basedGame;

        image = new GreenfootImage("BinaryTextBoxResult.jpg");
        updateText("Deine Eingabe");
    }

    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            eingabe = Greenfoot.ask("Bitte gebe die Dezimalzahl ein: ");
            if (!eingabe.isEmpty()) {
                this.vaules = Integer.parseInt(eingabe);
             //     System.out.println("Eingabe" + vaules);
              //    System.out.println("Row" + row);
                 world.gameModManger.checkInput(vaules, row, col);
                updateText(eingabe);
            }
        }
    }

    public void updateText(String newText) {
        // Lösche den alten Text
        image.clear();
        image.drawString("", 45, 45);
        image.clear();
        image.setColor(Color.BLUE);
        image.setFont(new Font("Arial", 20));
        image.drawString(newText, 45, 45);
        setImage(image);
    }
}
