import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * CSC320 Module 1 Discussion - modularization example.
 *
 * Demonstrates replaceability: modules announce themselves by name
 * instead of importing each other. Nothing in this class knows what
 * a "greet" module is, so a circular dependency cannot be built.
 */
public class ModuleRegistry {

    // Name -> the module that answers to it.
    private static final Map<String, Supplier<String>> handlers = new HashMap<>();

    // A module announces itself. Callers never import the module directly.
    public static void register(String name, Supplier<String> handler) {
        handlers.put(name, handler);
    }

    // A caller asks for a name. If nothing answers, say so instead of crashing.
    public static String call(String name) {
        Supplier<String> handler = handlers.get(name);
        if (handler == null) {
            return "No module registered under: " + name;
        }
        return handler.get();
    }

    public static void main(String[] args) {
        register("greet", () -> "Greeting module reporting in.");
        register("status", () -> "Status module: all systems nominal.");

        System.out.println(call("greet"));
        System.out.println(call("status"));
        System.out.println(call("report"));   // never registered
    }
}
