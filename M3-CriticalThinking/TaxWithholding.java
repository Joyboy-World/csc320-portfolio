import java.util.Scanner;

/**
 * Module 3 Critical Thinking - Option #1: Calculate Average Withholding
 *
 * Prompts the user for a weekly income, determines the applicable tax rate
 * from four income bands, and reports the weekly withholding and take-home pay.
 *
 * Income bands:
 *   less than $500                      -> 10%
 *   $500 or more and less than $1500    -> 15%
 *   $1500 or more and less than $2500   -> 20%
 *   $2500 or more                       -> 30%
 *
 * Author: Theo Thomas
 * Course: CSC320-1 Programming I
 */
public class TaxWithholding {

    // Band boundaries and rates are named so the thresholds appear once.
    private static final double BAND_ONE_LIMIT   = 500.00;
    private static final double BAND_TWO_LIMIT   = 1500.00;
    private static final double BAND_THREE_LIMIT = 2500.00;

    private static final double RATE_BAND_ONE   = 0.10;
    private static final double RATE_BAND_TWO   = 0.15;
    private static final double RATE_BAND_THREE = 0.20;
    private static final double RATE_BAND_FOUR  = 0.30;

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        System.out.print("Enter weekly income: $");
        double weeklyIncome = scnr.nextDouble();

        // Guard against input the income bands do not describe.
        if (weeklyIncome < 0.0) {
            System.out.println("Income cannot be negative. Please run the program again.");
            scnr.close();
            return;
        }

        double taxRate;

        // Compound relational operators state each band's full range explicitly.
        if (weeklyIncome < BAND_ONE_LIMIT) {
            taxRate = RATE_BAND_ONE;
        } else if (weeklyIncome >= BAND_ONE_LIMIT && weeklyIncome < BAND_TWO_LIMIT) {
            taxRate = RATE_BAND_TWO;
        } else if (weeklyIncome >= BAND_TWO_LIMIT && weeklyIncome < BAND_THREE_LIMIT) {
            taxRate = RATE_BAND_THREE;
        } else {
            taxRate = RATE_BAND_FOUR;
        }

        double withholding = weeklyIncome * taxRate;
        double takeHomePay = weeklyIncome - withholding;

        System.out.println();
        System.out.println("--- Weekly Withholding Summary ---");
        System.out.printf("Weekly income:      $%,.2f%n", weeklyIncome);
        System.out.printf("Tax rate:            %.0f%%%n", taxRate * 100);
        System.out.printf("Weekly withholding: $%,.2f%n", withholding);
        System.out.printf("Take-home pay:      $%,.2f%n", takeHomePay);

        scnr.close();
    }
}
