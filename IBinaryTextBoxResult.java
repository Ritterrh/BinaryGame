import greenfoot.*;

public class IBinaryTextBoxResult extends Actor {

    private GreenfootImage image; 

    private String eingabe;
    private int vaules;
    private int row;
    private int col;
    private World world;
    FGameModManger gameManager = FGameModManger.getInstanc();



    public IBinaryTextBoxResult(World world, int row, int col) {
        this.col = col;
        this.row = row;
        this.world = world;

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
                 gameManager.checkInputGameModeOne(vaules, row, col);
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
