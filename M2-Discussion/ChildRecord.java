import java.time.LocalDate;
import java.time.Period;

public class ChildRecord {

    // Stored facts: these do not change.
    private String firstName;       // non-primitive, but predefined
    private LocalDate birthDate;    // non-primitive, from java.time

    public ChildRecord(String firstName, LocalDate birthDate) {
        this.firstName = firstName;
        this.birthDate = birthDate;
    }

    // Derived value: int is correct here because the RESULT is a whole number,
    // not because age is a whole-number fact worth storing.
    public int ageToday() {
        return Period.between(birthDate, LocalDate.now()).getYears();
    }

    public static void main(String[] args) {
        ChildRecord child = new ChildRecord("Amara", LocalDate.of(2015, 3, 14));

        System.out.println("Name:       " + child.firstName);
        System.out.println("Birth date: " + child.birthDate);
        System.out.println("Age today:  " + child.ageToday());
    }
}
