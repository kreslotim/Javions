package ch.epfl.javions;

public class Bits {
    private final static int INT_BITS = Integer.SIZE; // 32 bits in an Integer
    private final static int LONG_BITS = Long.SIZE; // 64 bits in a Long
    private Bits() {}

    public static int extractUInt(long value, int start, int size) {
        Preconditions.checkArgument(size > 0 && size < INT_BITS);
        if (!(start >=0 && (start + size) >= 0 && (start + size <= LONG_BITS))) throw new IndexOutOfBoundsException();
        long l = value << (LONG_BITS - (start + size));
        return (int) (l >>> LONG_BITS - size);
    }

    public static boolean testBit(long value, int index) {
        if (! (0 <= index && index < LONG_BITS)) throw new IndexOutOfBoundsException();
        long mask = 1L << index;
        return ((value & mask) != 0);
    }
}
