package colour;

/**
 * The {@code Colour} class is used to represent RGB colours.
 * Every colour has three components: {@code red, green, blue}
 * in the range 0&nbsp;-&nbsp;255.
 * <p>
 * There are two ways to construct a {@code Colour}: with three float
 * components or one int RGB encoded value. When creating the
 * {@code Colour} with float variables, these three components are
 * ranged 0.0&nbsp;-&nbsp;1.0. When creating the {@code Colour} with
 * RGB encoded value, it is ranged 0.0&nbsp;-&nbsp;16777215.
 * </p>
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
    static final int HEX_255_VAL = 0xff;

    /**
     * Creates an RGB colour with the specified float red, green
     * and blue values in the range 0.0 - 1.0 by converting it
     * to int colour components. Converting a float primitive
     * value to int primitive is implemented via down-casting (int).
     *
     * @param red   the red component
     * @param green the green component
     * @param blue  the blue component
     * @throws IllegalArgumentException if {@code red}, {@code green} or {@code blue}
     *                                  are outside of the range 0.0 - 1.0
     */
    public Colour(float red, float green, float blue) throws IllegalArgumentException {
        checkValueRange(red, green, blue);

        this.red = (int) (red * 255);
        this.green = (int) (green * 255);
        this.blue = (int) (blue * 255);
    }

    /**
     * Creates an RGB colour with the specified encoded RGB value in the range 0 - 16777215
     * by converting it to int colour components. Converting an int primitive RGB value
     * to int primitive components is implemented by using bitwise-and and shifting right.
     *
     * @param rgbValue the encoded RGB value
     * @throws IllegalArgumentException if RGB value is outside of the range 0 - 16777215
     */
    public Colour(int rgbValue) throws IllegalArgumentException {
        if (rgbValue > MAX_INT_VAL || rgbValue < MIN_VAL) {
            throw new IllegalArgumentException(
                    "RGB value out of range [" + (int) MIN_VAL + ", " + MAX_INT_VAL + "]: RGB = " + rgbValue);
        }

        red = HEX_255_VAL & (rgbValue >> 16);   //extracting the red component by using bitwise-and and shifting right 16 places
        green = HEX_255_VAL & (rgbValue >> 8);  //extracting the green component by using bitwise-and and shifting right 8 places
        blue = HEX_255_VAL & rgbValue;          //extracting the blue component by using bitwise-and
    }

    /**
     * Checks {@code Colour float} components to be valid.
     *
     * @param red   the red component
     * @param green the green component
     * @param blue  the blue component
     * @throws IllegalArgumentException if the value(s) is(are) out of range.
     */
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

    /**
     * Returns current red component in the range 0 - 255.
     *
     * @return the red component.
     */
    public int getRed() {
        return red;
    }

    /**
     * Returns current green component in the range 0 - 255.
     *
     * @return the green component.
     */
    public int getGreen() {
        return green;
    }

    /**
     * Returns current blue component in the range 0 - 255.
     *
     * @return the blue component.
     */
    public int getBlue() {
        return blue;
    }

    /**
     * Checks if another object is equal to this {@code Colour}.
     * <p>
     * The result is {@code true} if the argument is not {@code null}
     * and is a {@code Colour} object that has the same red, green,
     * and blue components as this object.
     *
     * @param o the object to test with this {@code Colour}
     * @return {@code true} if the objects are the same;
     * {@code false} otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Colour colour = (Colour) o;

        if (red != colour.red) return false;
        if (green != colour.green) return false;
        return blue == colour.blue;
    }

    /**
     * Computes and returns the hash code for this {@code Coluor}.
     *
     * @return a hash code value for this object.
     */
    @Override
    public int hashCode() {
        int result = red;
        result = 31 * result + green;
        result = 31 * result + blue;
        return result;
    }
}
