/*
* This program plays rock paper scissors with the user
*
* @author  Cristiano Sellitto
* @version 1.0
* @since   2024-03-04
*/

import java.util.Scanner;

/**
* This is the program.
*/
final class RockPaperScissors {
    /**
    * Prevent instantiation.
    * Throw an exception IllegalStateException.
    * if this is ever called
    *
    * @throws IllegalStateException if this is ever called
    *
    */
    private RockPaperScissors() {
        throw new IllegalStateException("Cannot be instantiated");
    }

    /**
    * Randomly chooses between three strings.
    *
    * @param choiceOne is the first choice
    * @param choiceTwo is the second choice
    * @param choiceThree is the third choice
    *
    * @return the computer's choice
    */
    static String rockPaperScissors(
                    String choiceOne, String choiceTwo, String choiceThree
    ) {
        final int maxValue = 3;
        final int randomInt = 1 + (int) (Math.random() * ((maxValue - 1) + 1));
        String choice = "invalid";
        switch (randomInt) {
            case 1:
                choice = choiceOne;
                break;
            case 2:
                choice = choiceTwo;
                break;
            default:
                choice = choiceThree;
                break;
        }
        return choice;
    }

    /**
    * The starting main() function.
    *
    * @param args No args will be used
    */
    public static void main(final String[] args) {
        // String constants
        final String rock = "rock";
        final String paper = "paper";
        final String scissors = "scissors";

        // Make scanner
        final Scanner input = new Scanner(System.in);

        // Choice loop
        while (true) {
            // Check if input is valid
            try {
                System.out.print("Choose rock, paper or scissors: ");
                final String choice = input.nextLine();
                if (rock.equals(choice) || paper.equals(choice)
                                          || scissors.equals(choice)
                ) {
                    // Input is valid
                    final String computerChoice = rockPaperScissors(
                                    rock, paper, scissors
                    );
                    System.out.println("Your opponent chose "
                                      + computerChoice + "."
                    );
                    if (rock.equals(choice)
                                && scissors.equals(computerChoice)
                        || paper.equals(choice)
                                && rock.equals(computerChoice)
                        || scissors.equals(choice)
                                && paper.equals(computerChoice)
                    ) {
                        // Player win
                        System.out.println("\nYou win!");
                        break;
                    } else if (choice.equals(computerChoice)) {
                        // Draw
                        System.out.println("\nThere was a draw.\n");
                    } else {
                        // Computer win
                        System.out.println("\nYou lost.");
                        break;
                    }
                } else {
                    // Input is invalid
                    Integer.parseInt(null);
                }
            } catch (NumberFormatException nfe) {
                // Input is invalid
                System.out.println("Not a correct choice.\n");
            }
        }

        // Close scanner
        input.close();

        // Show the program as done
        System.out.println("\nDone.");
    }
}
