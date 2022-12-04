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
    static final int HEX_255 = 0xff;

    public Colour(float red, float green, float blue) throws IllegalArgumentException {
        checkValueRange(red, green, blue);

        this.red = (int) (red * 255);
        this.green = (int) (green * 255);
        this.blue = (int) (blue * 255);
    }

    public Colour(int rgbValue) throws IllegalArgumentException {
        if (rgbValue > MAX_INT_VAL || rgbValue < MIN_VAL) {
            throw new IllegalArgumentException(
                    "RGB value out of range [" + (int) MIN_VAL + ", " + MAX_INT_VAL + "]: RGB = " + rgbValue);
        }

        red = HEX_255 & (rgbValue >> 16);   //extracting the red component by using bitwise-and and shifting right 16 places
        green = HEX_255 & (rgbValue >> 8);  //extracting the green component by using bitwise-and and shifting right 8 places
        blue = HEX_255 & rgbValue;          //extracting the blue component by using bitwise-and
    }

    private void checkValueRange(float red, float green, float blue) throws IllegalArgumentException {
        boolean isOutOfRange = false;
        StringBuilder outOfRangeParameter = new StringBuilder();

        if (red < MIN_VAL || red > MAX_FLOAT_VAl) {
            isOutOfRange = true;
            outOfRangeParameter.append(" red = ").append(red);
        }
        if (green < MIN_VAL || green > MAX_FLOAT_VAl) {
            isOutOfRange = true;
            outOfRangeParameter.append(" green = ").append(green);
        }
        if (blue < MIN_VAL || blue > MAX_FLOAT_VAl) {
            isOutOfRange = true;
            outOfRangeParameter.append(" blue = ").append(blue);
        }
        if (isOutOfRange) {
            throw new IllegalArgumentException(
                    "Color parameter(s) out of range [" + MIN_VAL + ", " + MAX_FLOAT_VAl + "]:" + outOfRangeParameter);
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

        if (red != colour.red) return false;
        if (green != colour.green) return false;
        return blue == colour.blue;
    }

    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }
}
