import java.util.ArrayList;
import java.util.Scanner;

/**
 * WeeklyTemperatures
 * Stores the average temperature for each day of one week in two parallel
 * ArrayLists. The user can look up a single day, enter "week" to see every
 * day plus the weekly average, or enter "exit" to quit.
 */
public class WeeklyTemperatures {

    public static void main(String[] args) {
        Scanner scnr = new Scanner(System.in);

        // Parallel lists: index i in days matches index i in temps.
        ArrayList<String> days = new ArrayList<>();
        ArrayList<Double> temps = new ArrayList<>();

        days.add("Monday");    temps.add(68.5);
        days.add("Tuesday");   temps.add(71.0);
        days.add("Wednesday"); temps.add(74.2);
        days.add("Thursday");  temps.add(69.8);
        days.add("Friday");    temps.add(65.3);
        days.add("Saturday");  temps.add(63.9);
        days.add("Sunday");    temps.add(66.4);

        System.out.println("Weekly Temperature Lookup");
        String input = "";

        // Keep prompting until the user types "exit".
        while (!input.equalsIgnoreCase("exit")) {
            System.out.println();
            System.out.print("Enter a day (Monday-Sunday), \"week\", or \"exit\": ");
            input = scnr.nextLine().trim();

            if (input.equalsIgnoreCase("exit")) {
                System.out.println("Goodbye.");
            } else if (input.equalsIgnoreCase("week")) {
                printWeek(days, temps);
            } else {
                int index = lookupDay(days, input);
                if (index != -1) {
                    System.out.printf("%s: %.1f F%n", days.get(index), temps.get(index));
                } else {
                    System.out.println("\"" + input + "\" is not a day of the week. Please try again.");
                }
            }
        }

        scnr.close();
    }

    /**
     * Returns the position of the matching day, ignoring case,
     * or -1 if the input does not match any day.
     */
    public static int lookupDay(ArrayList<String> days, String dayName) {
        for (int i = 0; i < days.size(); i++) {
            if (days.get(i).equalsIgnoreCase(dayName)) {
                return i;
            }
        }
        return -1;
    }

    /** Returns the average of every value in the list. */
    public static double calculateAverage(ArrayList<Double> temps) {
        double total = 0.0;
        for (int i = 0; i < temps.size(); i++) {
            total += temps.get(i);
        }
        return total / temps.size();
    }

    /** Prints each day with its temperature, followed by the weekly average. */
    public static void printWeek(ArrayList<String> days, ArrayList<Double> temps) {
        System.out.println("--- Weekly Temperatures ---");
        for (int i = 0; i < days.size(); i++) {
            System.out.printf("%-10s %.1f F%n", days.get(i), temps.get(i));
        }
        System.out.printf("Weekly average: %.1f F%n", calculateAverage(temps));
    }
}
