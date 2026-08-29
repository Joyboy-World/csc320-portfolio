public class ChildRecordSimple {

    public static void main(String[] args) {

        // Stored facts. These two never change.
        String firstName = "Amara";     // non-primitive, but predefined by Java
        int birthYear    = 2015;        // primitive

        // Derived value. Recomputed every time it is needed, never stored.
        int currentYear = 2026;
        int ageInYears  = currentYear - birthYear;   // primitive

        System.out.println("Name:       " + firstName);
        System.out.println("Birth year: " + birthYear);
        System.out.println("Age:        " + ageInYears);
    }
}
