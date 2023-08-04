package ch.epfl.javions;

public final class Preconditions {
    /**
     * Default (non instantiable) Preconditions constructor.
     */
    private Preconditions() {}

    /**
     * Checks the validity of an input,
     * throwing an exception if one of given preconditions is false.
     *
     * @param shouldBeTrue multiples preconditions must be true
     * @throws IllegalArgumentException if one of given preconditions is false
     */
    public static void checkArgument(boolean shouldBeTrue) {
        if (!shouldBeTrue) throw new IllegalArgumentException();
    }
}
