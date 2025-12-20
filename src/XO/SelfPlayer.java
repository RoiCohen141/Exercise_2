package XO;

import java.util.Random;

public class SelfPlayer extends Player {

    private Random random;

    public SelfPlayer(char symbol) {
        super(symbol);
        random = new Random();
    }

    @Override
    public void run(Game game) {

        try {
            // שינה של בדיוק 500 מילי־שניות
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Cell[] freeCells = game.getFreeCells();
        if (freeCells.length == 0) {
            return;
        }

        int index = random.nextInt(freeCells.length);
        game.placeSymbol(freeCells[index]);
    }
}