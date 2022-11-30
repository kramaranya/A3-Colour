package colour;

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

    public Colour(float r, float g, float b) throws IllegalArgumentException {
        if (r < 0.0 || r > 1.0 || g < 0.0 || g > 1.0 || b < 0.0 || b > 1.0) {
            throw new IllegalArgumentException("Colour parameter outside of range");
        }
        red = (int) (r * 255);
        green = (int) (g * 255);
        blue = (int) (b * 255);
    }

    public Colour(int rgb) {
        red = 0xff & (rgb >> 16);
        green = 0xff & (rgb >> 8);
        blue = 0xff & rgb;
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
}
