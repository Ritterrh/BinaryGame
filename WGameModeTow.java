import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import greenfoot.*;

public class WGameModeTow extends World {
    private List<List<BinaryBlock>> binaryGrid = new ArrayList<>();
    private List<List<Integer>> sollStates = new ArrayList<>(); // List of soll states for each row
    private List<List<Integer>> istStates = new ArrayList<>(); // List of ist states for each row
    private FMessage leveltext = new FMessage();
    private FMessage pointstext = new FMessage();
    private BSaveButton sbutton = new BSaveButton();
    private BPauseButton button = new BPauseButton();
    private BEndGameButton ebutton = new BEndGameButton();
    private FGameModManger gameManager = FGameModManger.getInstance();
    private boolean allRowsCorrect = false; // Flag to track if all rows are correct

    public WGameModeTow() {
        super(36, 27, 33);
        loadLevel();
    }

    public void act() {
        leveltext.showText("Deine Level: " + gameManager.getLevel(), this, 1010, 10, 24, null, Color.WHITE);
        pointstext.showText("Deine Punkte: " + gameManager.getPoints(), this, 1010, 40, 24, null, Color.WHITE);

        // Check for correct states of binary blocks and update their colors
        for (int row = 0; row < binaryGrid.size(); row++) {
            List<BinaryBlock> binaryRow = binaryGrid.get(row);
            List<Integer> sollRow = sollStates.get(row);
            List<Integer> istRow = istStates.get(row);
            boolean isRowCorrect = true;
            for (int col = 0; col < binaryRow.size(); col++) {
                BinaryBlock block = binaryRow.get(col);
                int sollState = sollRow.get(col);
                int istState = block.getIstState();
                istRow.set(col, istState); // Update ist state list
                if (sollState != istState) {
                    isRowCorrect = false;
                    block.setColor(istState == 1 ? Color.ORANGE : Color.BLUE);
                } else {
                    blockCorrcet();
                    block.setColor(Color.GREEN);
                }
            }
            if (isRowCorrect && !allRowsCorrect) {
            
            }
        }
        if (checkAllRowsCorrect() && !allRowsCorrect) {
            allRowsCorrect = true;
            allRowsCorrectAction();
        }
    }

    // Method to be called when all blocks in a row are correct
    private void  blockCorrcet() {
        gameManager.rowCommplet();
    }

    // Method to be called when all rows are correct
    private void allRowsCorrectAction() {
        gameManager.allRowComplett();
    }

    private void loadLevel() {
        GreenfootImage background = new GreenfootImage("images/BinaryWorld_1200x900.jpg");
        setBackground(background);
        addObject(button, 33, 23);
        addObject(ebutton, 33, 25);
        addObject(sbutton, 33, 21);

        Random rand = new Random();

        for (int row = 0; row < 8; row++) {
            List<BinaryBlock> binaryRow = new ArrayList<>();
            List<Integer> sollRow = new ArrayList<>();
            List<Integer> istRow = new ArrayList<>();
            int decimalForRow = rand.nextInt(256); // Generate random decimal value between 0 and 255 for each row
            System.out.println("Decimal for row " + row + ": " + decimalForRow);

            for (int col = 0; col < 8; col++) {
                BinaryBlock block = new BinaryBlock();
                int randomState = rand.nextInt(2); // Generate random value (0 or 1) for istState
                int sollState = (decimalForRow >> (7 - col)) & 1; // Extract the corresponding bit from decimalForRow
                sollRow.add(sollState);
                istRow.add(randomState);
                block.setStates(randomState, sollState);
                binaryRow.add(block);
                addObject(block, col * 3 + 1, row * 3 + 3);
            }

            // Add binaryRow, sollRow, istRow to respective lists
            binaryGrid.add(binaryRow);
            sollStates.add(sollRow);
            istStates.add(istRow);

            // Display the decimal value for the row
            IBinaryTextBoxResult textBox = new IBinaryTextBoxResult(row, 8, 2);
            textBox.setDecimal(decimalForRow);
            addObject(textBox, 26, row * 3 + 3);
        }
    }

    // Method to check if all rows are correct
    private boolean checkAllRowsCorrect() {
        for (int row = 0; row < binaryGrid.size(); row++) {
            List<BinaryBlock> binaryRow = binaryGrid.get(row);
            boolean isRowCorrect = true;
            for (int col = 0; col < binaryRow.size(); col++) {
                BinaryBlock block = binaryRow.get(col);
                int sollState = sollStates.get(row).get(col);
                int istState = block.getIstState();
                if (sollState != istState) {
                    isRowCorrect = false;
                    break; // If any block in the row is incorrect, stop checking the row
                }
            }
            if (!isRowCorrect) {
                return false; // If any row is incorrect, return false
            }
        }
        return true; // If all rows are correct, return true
    }
}
