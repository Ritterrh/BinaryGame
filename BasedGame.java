import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;

import greenfoot.*; // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BasedGame here.
 * 
 * @author (your name)
 * @version (a version number or a date)
 */
public class BasedGame extends World {
    private message leveltext =  new message();
    private message pointstext=  new message();
    private SaveButton sbutton = new SaveButton(this);
    private PauseButton button = new PauseButton();
    private EndGameButton ebutton = new EndGameButton();
    public GameModManger gameModManger = new GameModManger(this);
    private String level ;
    private String points;
    private int gameMode;
    int setBlockValue = 0;
    private List<List<Integer>> nullOderEinsList = new ArrayList<>();
    private HashMap<Integer, BinaryBlockResult> blockMap;

    /**
     * Konstruktor für Objekte der Klasse BinaryWorld
     * 
     */
    public BasedGame(int level, int points) {

        super(36, 27, 33);
        this.level = String.valueOf(level);
        this.points = String.valueOf(points);
        loadlevel();
        gameModManger.init();
        gameModManger.switchGameMode(1);
    }

    public void act() {
         level = String.valueOf(gameModManger.getLevel());
         points = String.valueOf(gameModManger.getPoints());

         leveltext.showText("Deine Level: " + level, this, 1010, 10, 24, null, Color.WHITE);
         pointstext.showText("Deine Punkte: " + points, this, 1010, 40, 24, null, Color.WHITE);

    }

    public void loadlevel() {
        addObject(button, 33, 23);
        addObject(ebutton, 33, 25);
        addObject(sbutton, 33, 21);
    }


    public void GameModeOne() {

        for (int row = 1; row < 8; row++) {

            List<Integer> nullOderEinsRow = new ArrayList<>();

            for (int col = 0; col < 8; col++) {

                BinaryBlockResult block;
                block = new BinaryBlockResult(this);
                block.setNullOderEins(Greenfoot.getRandomNumber(2));
                addObject(block, col * 3 + 1, row * 3 + 1);

                BinaryTextBoxResult buton = new BinaryTextBoxResult(this, row, col);
                addObject(buton, 26, row * 3 + 1);

                nullOderEinsRow.add(block.getNullOderEins());
              //  System.out.println("NullOderEinsRow" + nullOderEinsRow);
            }
            nullOderEinsList.add(nullOderEinsRow);
          //  System.out.println("NullOderEinsList" + nullOderEinsList);
        }

    }

    public void GameModeTow() {
        for (int row = 1; row < 8; row++) {
            for (int col = 0; col < 8; col++) {

               //   System.out.println("Block Id" + id + "Set Block Value" + setBlockValue);
                BinaryBlock block;
                int sollwert = Greenfoot.getRandomNumber(2);
                int istwert = Greenfoot.getRandomNumber(2);
                block = new BinaryBlock(setBlockValue, sollwert, istwert);
                addObject(block, col * 3 + 1, row * 3 + 1);
                BinaryTextResult buton = new BinaryTextResult();
                addObject(buton, 26, row * 3 + 1);

            }
        }

    }

    public BinaryBlockResult getBlockById(int id) {
        return blockMap.get(id);
    }

    public int calculateDecimalForRow(List<Integer> row) {
        int decimal = 0;
        int power = row.size() - 1;
        for (int i = 0; i < row.size(); i++) {
            decimal += row.get(i) * Math.pow(2, power);
            power--;
        }
        return decimal;
    }

    public int[] calculateDecimalForAllRows() {
        int[] decimalArray = new int[nullOderEinsList.size()];
        int rowIndex = 0;
        for (List<Integer> row : nullOderEinsList) {
            int decimalForRow = calculateDecimalForRow(row);
            decimalArray[rowIndex] = decimalForRow;
            rowIndex++;
        }
        return decimalArray;
    }

    public boolean checkUserInput(int userInput, int rowIndex) {
        int[] decimalArray = calculateDecimalForAllRows();
        if (rowIndex >= 0 && rowIndex < decimalArray.length) {
            int correctDecimal = decimalArray[rowIndex];
            System.out.println("Correct Decimal" + correctDecimal);
            return userInput == correctDecimal;
        }

        return false;
    }

    public void removeAllObjectsInRow(int row, int col, Color color) {

        LargeElement largeElement = new LargeElement(color, 1964, 90);
        addObject(largeElement, col * 3 - 100, row * 3 + 1);
    }

}
