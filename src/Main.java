import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the flip game!\n");

        System.out.println("Starting grid:");

        int width = 3;
        int height = 3;

        Grid grid = new Grid(width, height);
        grid.printGrid();

        // While the grid isn't fully filled with circles
        while (!grid.isCircleFilled()) {
            // Continue the game :

            // Ask the player a position
            int x, y = 0;
            do {
                // Read the player's input until it's valid
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
                System.out.println("Enter position: letter, number (e.g. A1)");
                String position = "";
                try {
                    position = bufferedReader.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                // Parse the input into a position
                try {
                    x = (int) position.charAt(0) - 64;
                    y = Integer.parseInt(position.substring(1));
                } catch (Exception e) {
                    x = 0;
                    y = 0;
                }

                // Check if the position is valid
            } while (x < 1 || x > width || y < 1 || y > height);

            // Flip the coin at the position
            grid.flipCoin(x, y);

            // Print the updated grid
            grid.printGrid();
        }

        System.out.println("Congratulations, you won!");
    }
}