import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToeTest {
    public static void main(String[] args) {

        //Scanner erstellen und öffnen
        Scanner sc = new Scanner(System.in);

        int zeile = 0;
        int spalte = 0;
        boolean valid = false;
        boolean gameOn = true;
        char winner = ' ';
        String again = " ";


        do {
            TicTacToe s1 = new TicTacToe();

            for (int i = 0; i < 9; i++) {

                valid = false;

                if (i % 2 == 0) {

                    while (!valid) {

                        try {
                            System.out.print("Player 1: ");

                            zeile = sc.nextInt();
                            spalte = sc.nextInt();
                            System.out.println();


                            if (zeile < 0 || zeile > 2 || spalte < 0 || spalte > 2) {
                                System.out.println("Please write two numbers from 0 to 2. Try again \n");
                            }
                            else if (s1.getSpielfeld()[zeile][spalte] == ' ') {
                                s1.getSpielfeld()[zeile][spalte] = 'x';
                                valid = true;
                            }
                            else {
                                System.out.println("This field is already filled. Try again \n");
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Please write two numbers from 0 to 2. Try again \n");
                            sc.nextLine();
                            valid = false;
                        }
                    }

                }
                else {

                    while (!valid) {
                        try {
                            System.out.print("Player 2: ");

                            zeile = sc.nextInt();
                            spalte = sc.nextInt();
                            System.out.println();


                            if (zeile < 0 || zeile > 2 || spalte < 0 || spalte > 2) {
                                System.out.println("Please write two numbers from 0 to 2. Try again \n");
                            }
                            else if (s1.getSpielfeld()[zeile][spalte] == ' ') {
                                s1.getSpielfeld()[zeile][spalte] = 'o';
                                valid = true;
                            }
                            else {
                                System.out.println("This field is already filled. Try again \n");
                            }
                        }
                        catch (InputMismatchException e) {
                            System.out.println("Please write two numbers from 0 to 2. Try again \n");
                            sc.nextLine();
                            valid = false;
                        }
                    }
                }

                s1.printSpielfeld();
                System.out.println();


                winner = s1.checkWinner();

                if (winner != ' ') {
                    System.out.println("Game Over! Winner: " + winner);
                    break;
                }
            }

            if (winner == ' ') {
                System.out.println(" Game Over! It's a Tie.");
            }

            System.out.print("Again? (y/n) ");
            again = sc.next();

            System.out.println(again);

            if (again.equalsIgnoreCase("y")) {
                System.out.println("Great, have fun!");
                gameOn = true;
            }
            else if (again.equalsIgnoreCase("n")) {
                System.out.println("Goodbye!");
                gameOn = false;
            }
            else {
                System.out.println("Wrong Insert! The game will be closed.");
                gameOn = false;
            }

        } while (gameOn == true);


        // Scanner schließen
        sc.close();
    }
}
