package colour;

import java.util.Objects;

/**
 * The {@code Colour} class is used to represent RGB colours.
 *
 * @author Anna Kramar
 * @version 29 Nov 2022
 */
public class Colour {
    private final int red;
    private final int green;
    private final int blue;

    static final int MAX_INT_VAL = 16777215;
    static final float MAX_FLOAT_VAl = 1.0F;
    static final float MIN_VAL = 0.0F;

    public Colour(float r, float g, float b) throws IllegalArgumentException {
        checkValueRange(r, g, b);

        red = (int) (r * 255);
        green = (int) (g * 255);
        blue = (int) (b * 255);
    }

    public Colour(int rgb) throws IllegalArgumentException {
        if (rgb > MAX_INT_VAL || rgb < MIN_VAL) {
            throw new IllegalArgumentException("RGB parameter out of range");
        }
        
        red = 0xff & (rgb >> 16);
        green = 0xff & (rgb >> 8);
        blue = 0xff & rgb;
    }

    private static void checkValueRange(float r, float g, float b) throws IllegalArgumentException {
        boolean isOutOfRange = false;
        StringBuilder outOfRangeComponent = new StringBuilder();

        if (r < MIN_VAL || r > MAX_FLOAT_VAl) {
            isOutOfRange = true;
            outOfRangeComponent.append(" red");
        }
        if (g < MIN_VAL || g > MAX_FLOAT_VAl) {
            isOutOfRange = true;
            outOfRangeComponent.append(" green");
        }
        if (b < MIN_VAL || b > MAX_FLOAT_VAl) {
            isOutOfRange = true;
            outOfRangeComponent.append(" blue");
        }
        if (isOutOfRange) {
            throw new IllegalArgumentException("Color parameter out of range:" + outOfRangeComponent);
        }
    }

    public int getRed() {
        return red;
    }

    public int getGreen() {
        return green;
    }

    public int getBlue() {
        return blue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Colour colour = (Colour) o;
        return red == colour.red && green == colour.green && blue == colour.blue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(red, green, blue);
    }
}
