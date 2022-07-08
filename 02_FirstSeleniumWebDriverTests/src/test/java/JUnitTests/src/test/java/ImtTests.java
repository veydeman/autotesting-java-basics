import org.junit.Assert;
import org.junit.Test;

public class ImtTests {

    private String getIMTResult(Float heightCm, Float weightKg) {

        var userIndex = Math.round(weightKg / Math.pow((heightCm / 100), 2));
        String userResult = null;

        if (userIndex <= 16) {
            userResult = "выраженному дефициту массы тела";
        } else if (userIndex > 16 && userIndex < 19) {
            userResult = "недостаточной массе тела";
        } else if (userIndex > 19 && userIndex < 25) {
            userResult = "нормальной массе тела";
        } else if (userIndex > 25) {
            userResult = "избыточной массе тела";
        }
        if (heightCm.equals(0.0f)) userResult += "указан некорректный рост";
        return userResult;

    }

    @Test
    public void ZeroIMTTest() {
        var weight = 1f;
        var height = 180f;
        Assert.assertEquals("выраженному дефициту массы тела", getIMTResult(height, weight));
    }

    @Test
    public void SixteenIMTTest() {
        var weight = 51.85f;
        var height = 180f;
        Assert.assertEquals("выраженному дефициту массы тела", getIMTResult(height, weight));
    }

    @Test
    public void MoreThanSixteenIMTTest() {
        var weight = 53.47f;
        var height = 180f;
        Assert.assertEquals("недостаточной массе тела", getIMTResult(height, weight));
    }

    @Test
    public void NineteenIMTTest() {
        var weight = 61f;
        var height = 180f;
        Assert.assertEquals("нормальной массе тела", getIMTResult(height, weight));
    }

    @Test
    public void TwentyIMTTest() {
        var weight = 65f;
        var height = 180f;
        Assert.assertEquals("нормальной массе тела", getIMTResult(height, weight));
    }

    @Test
    public void TwentyFourIMTTest() {
        var weight = 77f;
        var height = 180f;
        Assert.assertEquals("нормальной массе тела", getIMTResult(height, weight));
    }

    @Test
    public void TwentyFiveIMTTest() {
        var weight = 80f;
        var height = 180f;
        Assert.assertEquals("избыточной массе тела", getIMTResult(height, weight));
    }

    @Test
    public void TwentySixIMTTest() {
        var weight = 85f;
        var height = 180f;
        Assert.assertEquals("избыточной массе тела", getIMTResult(height, weight));
    }
}
