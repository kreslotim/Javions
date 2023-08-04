package ch.epfl.javions;

import java.util.Arrays;
import java.util.HexFormat;
import java.util.Objects;

public final class ByteString {
    private byte[] bytes;
    public ByteString(byte[] bytes) {
        this.bytes = bytes.clone();
    }

    public int size() {
        return bytes.length;
    }

    public int byteAt(int index) {
        Objects.checkIndex(index, bytes.length);
        return bytes[index] & 0xFF; // masked with 0xFF to avoid sign extension
    }

    public long bytesInRange(int fromIndex, int toIndex) {
        Objects.checkFromToIndex(fromIndex, toIndex, bytes.length);
        Preconditions.checkArgument(toIndex - fromIndex < Long.BYTES);
        long result = 0;
        for (int i = fromIndex; i < toIndex; i++) {
            result = (result << 8) | (bytes[i] & 0xFF); // masked with 0xFF to avoid sign extension
        }
        return result;
    }

    public static ByteString ofHexadecimalString(String hexString) {
        Preconditions.checkArgument(hexString.length() % 2 == 0);
        HexFormat hf = HexFormat.of().withUpperCase();
        byte[] bytes = hf.parseHex(hexString);
        return new ByteString(bytes);
    }

    @Override
    public boolean equals(Object thatO) {
        if (thatO instanceof ByteString that) {
            return Arrays.equals(this.bytes, that.bytes);
        } else return false;
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(bytes);
    }

    @Override
    public String toString() {
        HexFormat hf = HexFormat.of().withUpperCase();
        return hf.formatHex(bytes);
    }


}
