package XO;

import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose game type:");
        System.out.println("1 - UserGame (User vs Computer)");
        System.out.println("2 - SelfGame (Computer vs Computer)");
        System.out.print("Enter choice: ");

        int choice = scanner.nextInt();

        if (choice == 1) {
            UserGame game = new UserGame();
            game.play();
        } else if (choice == 2) {
            SelfGame game = new SelfGame();
            game.play();
        } else {
            System.out.println("Invalid choice.");
        }

        // scanner.close(); // אפשר, אבל אם יש לך Scanner גם בתוך UserPlayer עדיף לא לסגור פה כדי לא לסגור את System.in באמצע
    }
}