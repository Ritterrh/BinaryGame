import greenfoot.*;

public class IBinaryTextBoxResult extends Actor {

    private GreenfootImage image;

    private String eingabe;
    private int vaules;
    private int row;
    private int col;
    private int gameMode;
    private int decimal;
    private World world;
    FGameModManger gameManager = FGameModManger.getInstance();


    public IBinaryTextBoxResult(int row, int col, int gm) {
        this.gameMode = gm;
        this.col = col;
        this.row = row;

        image = new GreenfootImage("BinaryTextBoxResult.jpg");
        switch (gameMode) {
            case 1:
                updateText("Deine Eingabe");
                break;
            case 2:
                updateText(String.valueOf(decimal));
                break;
            default:
                break;
        }
    }

    public void act() {
        switch (gameMode) {
            case 1:
                if (Greenfoot.mouseClicked(this)) {
                    eingabe = Greenfoot.ask("Bitte gebe die Dezimalzahl ein: ");
                    if (!eingabe.isEmpty()) {
                        this.vaules = Integer.parseInt(eingabe);
                       
                        gameManager.checkInputGameModeOne(vaules, row, col);
                        updateText(eingabe);
                    }
                }
                break;
            case 2:
                updateText(String.valueOf(decimal));
                break;
            default:
                break;
        }

    }

    public void setDecimal(int decimals) {
        this.decimal = decimals;
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
