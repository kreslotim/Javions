package ch.epfl.javions;

public final class Math2 {
    private Math2() {}

    public static int clamp(int min, int v, int max) {
        Preconditions.checkArgument(max >= min);
        if (v < min) return min;
        return Math.min(v, max);
    }

    public static double asinh(double x) {
        return Math.log(x + Math.hypot(1,x));
    }
}
