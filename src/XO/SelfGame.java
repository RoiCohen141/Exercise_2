package XO;

public class SelfGame extends Game {

    private Player p1;
    private Player p2;

    public SelfGame() {
        super();
        p1 = new SelfPlayer('X');
        p2 = new SelfPlayer('O');
    }

    public void play() {
        printBoard();

        while (true) {
            if (getTurn() == PlayerType.X) {
                p1.run(this);
            } else {
                p2.run(this);
            }

            printBoard();

            if (checkWin()) {
                System.out.println("Player " + getTurn() + " wins");
                break;
            }

            if (getFreeCells().length == 0) {
                System.out.println("Draw");
                break;
            }

            switchTurn();
        }
    }
}