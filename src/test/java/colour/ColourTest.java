package colour;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ColourTest {
    @Test
    void Colour_ThreeValidComponents_CreateColourWithCorrectValues() {
        int expectedRed = 0;
        int expectedGreen = 127;
        int expectedBlue = 255;

        Colour colour = new Colour(0.0F, 0.5F, 1.0F);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedRed, colour.getRed()),
                () -> Assertions.assertEquals(expectedGreen, colour.getGreen()),
                () -> Assertions.assertEquals(expectedBlue, colour.getBlue())
        );
    }

    @Test
    void Colour_ThreeValidComponents_CreateColoursWithCorrectValues() {
        int expectedRed = 0;
        int expectedGreen = 0;
        int expectedBlue = 0;

        Colour colour = new Colour(0.0F, 0.0F, 0.0F);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedRed, colour.getRed()),
                () -> Assertions.assertEquals(expectedGreen, colour.getGreen()),
                () -> Assertions.assertEquals(expectedBlue, colour.getBlue())
        );
    }

    @Test
    void Colour_AnotherThreeValidComponents_CreateColoursWithCorrectValues() {
        int expectedRed = 255;
        int expectedGreen = 255;
        int expectedBlue = 255;

        Colour colour = new Colour(1.0F, 1.0F, 1.0F);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedRed, colour.getRed()),
                () -> Assertions.assertEquals(expectedGreen, colour.getGreen()),
                () -> Assertions.assertEquals(expectedBlue, colour.getBlue())
        );
    }

    @Test
    void Colour_OneComponentIsGreaterThanExpected_ThrowIllegalArgumentException() {
        String expectedMessage = "Color parameter(s) out of range [0.0, 1.0]: red = 1.5 blue = 15.0";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Colour(1.5F, 0.5F, 15.0F));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void Colour_OneComponentIsSmallerThanExpected_ThrowIllegalArgumentException() {
        String expectedMessage = "Color parameter(s) out of range [0.0, 1.0]: blue = -1.0";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Colour(0.0F, 0.5F, -1.0F));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void Colour_OneValidRGBComponent_CreateColourWithCorrectValues() {
        int expectedRed = 255;
        int expectedGreen = 0;
        int expectedBlue = 255;

        Colour colour = new Colour(16711935);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedRed, colour.getRed()),
                () -> Assertions.assertEquals(expectedGreen, colour.getGreen()),
                () -> Assertions.assertEquals(expectedBlue, colour.getBlue())
        );
    }

    @Test
    void Colour_ValidRGBComponents_CreateColoursWithCorrectValues() {
        int expectedRed = 170;
        int expectedGreen = 170;
        int expectedBlue = 170;

        Colour colour = new Colour(11184810);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedRed, colour.getRed()),
                () -> Assertions.assertEquals(expectedGreen, colour.getGreen()),
                () -> Assertions.assertEquals(expectedBlue, colour.getBlue())
        );
    }

    @Test
    void Colour_AnotherValidRGBComponents_CreateColoursWithCorrectValues() {
        int expectedRed = 255;
        int expectedGreen = 255;
        int expectedBlue = 255;

        Colour colour = new Colour(16777215);

        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedRed, colour.getRed()),
                () -> Assertions.assertEquals(expectedGreen, colour.getGreen()),
                () -> Assertions.assertEquals(expectedBlue, colour.getBlue())
        );
    }

    @Test
    void Colour_ComponentIsGreaterThanExpected_ThrowIllegalArgumentException() {
        String expectedMessage = "RGB parameter out of range [0, 16777215]: RGB = 16777216";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Colour(16777216));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void Colour_ComponentIsSmallerThanExpected_ThrowIllegalArgumentException() {
        String expectedMessage = "RGB parameter out of range [0, 16777215]: RGB = -50";

        Throwable exception = assertThrows(IllegalArgumentException.class,
                () -> new Colour(-50));

        Assertions.assertEquals(expectedMessage, exception.getMessage());
    }

    @Test
    void Equals_ColoursHaveTheSameComponentValues_ReturnTrue() {
        Colour colour = new Colour(1.0F, 0.0F, 1.0F);
        Colour colour2 = new Colour(16711935);

        Assertions.assertTrue(colour.equals(colour2));
    }

    @Test
    void Equals_ColoursHaveNotTheSameComponentValues_ReturnFalse() {
        Colour colour = new Colour(1.0F, 1.0F, 1.0F);
        Colour colour2 = new Colour(0);

        Assertions.assertFalse(colour.equals(colour2));
    }

    @Test
    void HashCode_ColoursHaveTheSameComponentValues_ReturnTrue() {
        Colour colour = new Colour(1.0F, 0.0F, 1.0F);
        Colour colour2 = new Colour(16711935);

        Assertions.assertEquals(colour.hashCode(), colour2.hashCode());
    }

    @Test
    void HashCode_ColoursHaveNotTheSameComponentValues_ReturnFalse() {
        Colour colour = new Colour(1.0F, 0.0F, 1.0F);
        Colour colour2 = new Colour(0);

        Assertions.assertNotEquals(colour.hashCode(), colour2.hashCode());
    }

}
