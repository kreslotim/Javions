package ch.epfl.javions;

public record GeoPos(int longitudeT32, int latitudeT32) {
    public GeoPos {
        Preconditions.checkArgument(isValidLatitudeT32(latitudeT32));
    }
    public static boolean isValidLatitudeT32(int latitudeT32) {
        return ((-(1<<30) <= latitudeT32) && (latitudeT32 <= (1<<30)));
    }

    //Hello!

    public double longitude() {
        return Units.convert(longitudeT32, Units.Angle.T32, Units.Angle.RADIAN);
    }
    public double latitude() {
        return Units.convert(latitudeT32, Units.Angle.T32, Units.Angle.RADIAN);
    }

    @Override
    public String toString() {
        return "("+Units.convert(longitude(), Units.Angle.RADIAN, Units.Angle.DEGREE)+"°, "
                +Units.convert(latitude(), Units.Angle.RADIAN, Units.Angle.DEGREE)+"°)";
    }
}
