public class EnumExercise {

    // 1. Define the Enum
    public enum Level {
        LOW, MEDIUM, HIGH, URGENT, CRITICAL
    }

    /**
     * Maps an integer to a Level enum.
     * Returns null if the number doesn't match a case.
     */
    public static Level getEnumerated(int num) {
        return switch (num) {
            case 1 -> Level.LOW;
            case 2 -> Level.MEDIUM;
            case 3 -> Level.HIGH;
            case 4 -> Level.URGENT;
            case 5 -> Level.CRITICAL;
            default -> null; // Works because Level is an Object type
        };
    }

    public static void main(String[] args) {
        // Testing different inputs
        int[] testInputs = { 1, 3, 5, 10 };

        for (int input : testInputs) {
            Level result = getEnumerated(input);

            if (result != null) {
                System.out.println("Input " + input + " mapped to: " + result);
            } else {
                System.out.println("Input " + input + " is not a valid level.");
            }
        }
    }
}
