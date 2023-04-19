import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * This program uses recursion to reverse,
 * a set of strings.
 *
 * @author  Sarah Andrew
 * @version 1.0
 *
 * @since 2023-13-04.
 */

public final class Fibonacci {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private Fibonacci() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");
        final File fileOut = new File("output.txt");

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fW = new FileWriter(fileOut);
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fW);

            while (sc.hasNextLine()) {
                // Read line as string.
                final String line = sc.nextLine();
                try {
                    // Parse the input as double.
                    final int newLine = Integer.parseInt(line);

                    // Declare variable.
                    final int aStr = newLine;

                    // If statement to determine negative
                    // inputs.
                    if (aStr >= 0) {
                        // Call function.
                        final int fibNum = recFibonacci(aStr);

                        // Display results.
                        System.out.print("The fibonacci sequence of " + aStr);
                        System.out.println(" is " + fibNum);

                        // Write to console.
                        write.print("The fibonacci sequence of " + aStr);
                        write.println(" is " + fibNum);

                    } else {
                        // Displays error to user.
                        System.out.println("Please enter a positive number.");
                        write.println("Please enter a positive number.");
                    }

                } catch (NumberFormatException e) {
                    // Displays error to user if input is not a valid double.
                    System.out.println("Invalid, \""
                            + line + "\" is not a valid number.");
                    write.println("Error: Invalid, \""
                            + line + "\" is not a valid number.");
                }
            }
            // Closes scanner & writer.
            write.close();
            sc.close();
        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses recursion to
    * calculate fibonacci sequence.
    *
    * @param aNum passed
    * @return recFibonacci.
    */
    public static int recFibonacci(int aNum) {
        // Calculates sequence.
        // Define base cases.
        if (aNum == 0) {
            // Returns 0.
            return 0;
        } else if (aNum == 1) {
            // Returns 1.
            return 1;
        } else {
            // Calls function recursively.
            return recFibonacci(aNum - 1) + recFibonacci(aNum - 2);
        }
    }
}
