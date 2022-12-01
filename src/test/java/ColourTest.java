import colour.Colour;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


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
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Colour(0.0F, 0.5F, 15.0F));
    }

    @Test
    void Colour_OneComponentIsSmallerThanExpected_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Colour(0.0F, 0.5F, -1.0F));
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
        Colour colour = new Colour(0);

        Assertions.assertAll(
                () -> Assertions.assertEquals(0, colour.getRed()),
                () -> Assertions.assertEquals(0, colour.getGreen()),
                () -> Assertions.assertEquals(0, colour.getBlue())
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
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Colour(16777216));
    }

    @Test
    void Colour_ComponentIsSmallerThanExpected_ThrowIllegalArgumentException() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> new Colour(-50));
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

}
