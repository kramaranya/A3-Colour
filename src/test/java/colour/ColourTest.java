package colour;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ColourTest {
    @Test
    void Colour_ThreeValidComponents_CreateColourWithCorrectValues() {
        Colour colour = new Colour(0.0F, 0.5F, 1.0F);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, colour.getRed()),
                () -> Assertions.assertEquals(255 / 2, colour.getGreen()),
                () -> Assertions.assertEquals(255, colour.getBlue())
        );
    }

    @Test
    void Colour_ThreeValidComponents_CreateColoursWithCorrectValues() {
        Colour colour = new Colour(0.0F, 0.0F, 0.0F);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, colour.getRed()),
                () -> Assertions.assertEquals(0, colour.getGreen()),
                () -> Assertions.assertEquals(0, colour.getBlue())
        );
    }

    @Test
    void Colour_AnotherThreeValidComponents_CreateColoursWithCorrectValues() {
        Colour colour = new Colour(1.0F, 1.0F, 1.0F);

        Assertions.assertAll(
                () -> Assertions.assertEquals(255, colour.getRed()),
                () -> Assertions.assertEquals(255, colour.getGreen()),
                () -> Assertions.assertEquals(255, colour.getBlue())
        );
    }

    @Test
    void Colour_OneComponentIsGreaterThanExpected_ThrowIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(1.5F, 0.5F, 15.0F));
        Assertions.assertEquals("Color parameter(s) out of range [0.0, 1.0]: red = 1.5 blue = 15.0", exception.getMessage());
    }

    @Test
    void Colour_OneComponentIsSmallerThanExpected_ThrowIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(0.0F, 0.5F, -1.0F));
        Assertions.assertEquals("Color parameter(s) out of range [0.0, 1.0]: blue = -1.0", exception.getMessage());
    }

    @Test
    void Colour_OneValidRGBComponent_CreateColourWithCorrectValues() {
        Colour colour = new Colour(16711935);

        Assertions.assertAll(
                () -> Assertions.assertEquals(255, colour.getRed()),
                () -> Assertions.assertEquals(0, colour.getGreen()),
                () -> Assertions.assertEquals(255, colour.getBlue())
        );
    }

    @Test
    void Colour_ValidRGBComponents_CreateColoursWithCorrectValues() {
        Colour colour = new Colour(11184810);

        Assertions.assertAll(
                () -> Assertions.assertEquals(170, colour.getRed()),
                () -> Assertions.assertEquals(170, colour.getGreen()),
                () -> Assertions.assertEquals(170, colour.getBlue())
        );
    }

    @Test
    void Colour_AnotherValidRGBComponents_CreateColoursWithCorrectValues() {
        Colour colour = new Colour(16777215);

        Assertions.assertAll(
                () -> Assertions.assertEquals(255, colour.getRed()),
                () -> Assertions.assertEquals(255, colour.getGreen()),
                () -> Assertions.assertEquals(255, colour.getBlue())
        );
    }

    @Test
    void Colour_ComponentIsGreaterThanExpected_ThrowIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(16777216));
        Assertions.assertEquals("RGB parameter out of range [0, 16777215]: RGB = 16777216", exception.getMessage());
    }

    @Test
    void Colour_ComponentIsSmallerThanExpected_ThrowIllegalArgumentException() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Colour(-50));
        Assertions.assertEquals("RGB parameter out of range [0, 16777215]: RGB = -50", exception.getMessage());
    }

    @Test
    void Equals_ColoursHaveTheSameComponentValues_ReturnTrue(){
        Colour colour = new Colour(1.0F, 0.0F, 1.0F);
        Colour colour2 = new Colour(16711935);

        Assertions.assertTrue(colour.equals(colour2));
    }

    @Test
    void Equals_ColoursHaveNotTheSameComponentValues_ReturnFalse(){
        Colour colour = new Colour(1.0F, 1.0F, 1.0F);
        Colour colour2 = new Colour(0);

        Assertions.assertFalse(colour.equals(colour2));
    }

    @Test
    void HashCode_ColoursHaveTheSameComponentValues_ReturnTrue(){
        Colour colour = new Colour(1.0F, 0.0F, 1.0F);
        Colour colour2 = new Colour(16711935);

        Assertions.assertEquals(colour.hashCode(), colour2.hashCode());
    }

    @Test
    void HashCode_ColoursHaveNotTheSameComponentValues_ReturnFalse(){
        Colour colour = new Colour(1.0F, 0.0F, 1.0F);
        Colour colour2 = new Colour(0);

        Assertions.assertNotEquals(colour.hashCode(), colour2.hashCode());
    }

}
