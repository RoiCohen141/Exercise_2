package XO;
import java.util.Scanner;

public class UserPlayer extends Player {

    private Scanner scanner;

    public UserPlayer(char symbol) {
        super(symbol);
        scanner = new Scanner(System.in);
    }

    @Override
    public void run(Game game) {

        int row, col;
        boolean success = false;

        while (!success) {

            System.out.println("Enter Row (0-4): ");
            row = scanner.nextInt();

            System.out.println("Enter Col (0-4): ");
            col = scanner.nextInt();

            success = game.placeSymbol(row, col);

            if (!success) {
                System.out.println("Invalid move, try again.");
            }
        }
    }
}