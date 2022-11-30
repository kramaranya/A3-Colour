import colour.Colour;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;


public class ColourTest {
    @Test
    void Colour_ThreeValidComponents_CreateColourWithCorrectValues() {
        Colour colour = new Colour(0.0F, 0.5F, 1.0F);

        Assertions.assertEquals(0, colour.getRed());
        Assertions.assertEquals(255 / 2, colour.getGreen());
        Assertions.assertEquals(255, colour.getBlue());
    }
}
