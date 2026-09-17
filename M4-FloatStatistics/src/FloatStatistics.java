import java.util.Scanner;

/**
 * Module 4 Critical Thinking - Option #1: Looping Construct with Floating Point Numbers
 *
 * Uses a while-loop to read five floating-point values from the user, then
 * reports the total, average, maximum, minimum, and 20% interest on the total.
 *
 * Endless-loop protection:
 *   1. The loop stops once five valid values have been read.
 *   2. The loop also stops after MAX_ATTEMPTS entries, valid or not, so
 *      repeated bad input cannot keep it running forever.
 *   3. The loop stops if the input stream closes.
 *   Non-numeric input is consumed and rejected so the same bad token
 *   is never re-read on the next pass.
 *
 * Author: Theo Thomas
 * Course: CSC320-1 Programming I
 */
public class FloatStatistics {

    private static final int VALUE_COUNT = 5;
    private static final int MAX_ATTEMPTS = 15;
    private static final double INTEREST_RATE = 0.20;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        int valuesRead = 0;
        int attempts = 0;
        boolean inputOpen = true;

        double total = 0.0;
        double maximum = 0.0;
        double minimum = 0.0;

        System.out.println("Enter " + VALUE_COUNT + " floating-point values.");

        while (valuesRead < VALUE_COUNT && attempts < MAX_ATTEMPTS && inputOpen) {
            attempts++;
            System.out.print("Value " + (valuesRead + 1) + ": ");

            if (scnr.hasNextDouble()) {
                double value = scnr.nextDouble();

                if (Double.isFinite(value)) {
                    total += value;

                    // The first valid value sets both extremes; later values are compared.
                    if (valuesRead == 0 || value > maximum) {
                        maximum = value;
                    }
                    if (valuesRead == 0 || value < minimum) {
                        minimum = value;
                    }
                    valuesRead++;
                } else {
                    System.out.println("Please enter a finite number.");
                }
            } else if (scnr.hasNext()) {
                String badInput = scnr.next();   // consume the bad token
                System.out.println("\"" + badInput + "\" is not a number. Please try again.");
            } else {
                inputOpen = false;               // no more input available
            }
        }

        if (valuesRead < VALUE_COUNT) {
            System.out.println();
            System.out.println("Stopped after " + attempts + " attempts with only "
                    + valuesRead + " valid values. Please run the program again.");
            scnr.close();
            return;
        }

        double average = total / VALUE_COUNT;
        double interest = total * INTEREST_RATE;

        System.out.println();
        System.out.println("--- Results ---");
        String interestLabel = String.format("Interest at %.0f%%:", INTEREST_RATE * 100);

        System.out.printf("%-18s %,12.2f%n", "Total:", total);
        System.out.printf("%-18s %,12.2f%n", "Average:", average);
        System.out.printf("%-18s %,12.2f%n", "Maximum:", maximum);
        System.out.printf("%-18s %,12.2f%n", "Minimum:", minimum);
        System.out.printf("%-18s %,12.2f%n", interestLabel, interest);

        scnr.close();
    }
}
