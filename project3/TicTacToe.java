import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class TicTacToe {

    public TicTacToe() {
        game();
    }

    private void game() {
        boolean isPlaying = false;
        char[] chars = new char[]{'1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Random random = new Random();
        Scanner scan = new Scanner(System.in);

        for (int moves = 0; moves < 9;) {

            displayBoard(chars);

            System.out.print("Enter your move: ");

            try {
                int move = scan.nextInt();
                if (move <= 9 && move >= 1 && chars[move - 1] == move + 48) {
                    chars[move - 1] = 'X';
                    moves++;
                    while (true) {
                        int integer = random.nextInt(8);

                        for (int i = 0; i < chars.length; i++) {
                            if (chars[integer - 1] == integer + 48) {
                                chars[integer - 1] = 'O';
                                break;
                            }
                        }
                    }
                } else {
                    System.out.println("Invalid move!");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid move!");
                scan.next();
            }
        }
    }

    private void displayBoard(char[] chars) {
        System.out.printf("[%c][%c][%c]\n", chars[0], chars[1], chars[2]);
        System.out.printf("[%c][%c][%c]\n", chars[3], chars[4], chars[5]);
        System.out.printf("[%c][%c][%c]\n", chars[6], chars[7], chars[8]);
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

}