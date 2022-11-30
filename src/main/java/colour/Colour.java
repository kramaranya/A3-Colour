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

    public Colour(float r, float g, float b) {

        red = (int) (r * 255);
        green = (int) (g * 255);
        blue = (int) (b * 255);
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
