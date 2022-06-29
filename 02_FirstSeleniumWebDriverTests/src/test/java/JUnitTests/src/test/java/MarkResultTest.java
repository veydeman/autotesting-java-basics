import org.junit.Assert;
import org.junit.Test;

public class MarkResultTest {

    private String getMarkResult(Integer mark) {

        if (mark >= 0 && mark <= 35) return "2";
        if (mark > 35 && mark <= 56) return "3";
        if (mark > 56 && mark < 71) return "4";
        if (mark > 72 && mark < 100) return "5";

        return "no mark result";
    }

    @Test
    public void NegativeScoreTest(){
        var mark = -1;
        Assert.assertEquals("no mark result", getMarkResult(mark));
    }

    @Test
    public void ZeroScoreTest(){
        var mark = 0;
        Assert.assertEquals("2", getMarkResult(mark));
    }

    @Test
    public void OneScoreTest(){
        var mark = 1;
        Assert.assertEquals("2", getMarkResult(mark));
    }

    @Test
    public void ThirtyFourScoreTest(){
        var mark = 34;
        Assert.assertEquals("2", getMarkResult(mark));
    }

    @Test
    public void ThirtyFiveScoreTest(){
        var mark = 35;
        Assert.assertEquals("2", getMarkResult(mark));
    }

    @Test
    public void ThirtySixScoreTest(){
        var mark = 36;
        Assert.assertEquals("3", getMarkResult(mark));
    }

    @Test
    public void FiftyFiveScoreTest(){
        var mark = 55;
        Assert.assertEquals("3", getMarkResult(mark));
    }

    @Test
    public void FiftySixScoreTest(){
        var mark = 56;
        Assert.assertEquals("3", getMarkResult(mark));
    }

    @Test
    public void FiftySevenScoreTest(){
        var mark = 57;
        Assert.assertEquals("4", getMarkResult(mark));
    }

    @Test
    public void FiftyEightScoreTest(){
        var mark = 58;
        Assert.assertEquals("4", getMarkResult(mark));
    }

    @Test
    public void SeventyScoreTest(){
        var mark = 70;
        Assert.assertEquals("4", getMarkResult(mark));
    }

    @Test
    public void SeventyOneScoreTest(){
        var mark = 71;
        Assert.assertEquals("4", getMarkResult(mark));
    }

    @Test
    public void SeventyTwoScoreTest(){
        var mark = 72;
        Assert.assertEquals("5", getMarkResult(mark));
    }

    @Test
    public void SeventyThreeScoreTest(){
        var mark = 73;
        Assert.assertEquals("5", getMarkResult(mark));
    }

    @Test
    public void NinetyNineScoreTest(){
        var mark = 99;
        Assert.assertEquals("5", getMarkResult(mark));
    }

    @Test
    public void HundredScoreTest(){
        var mark = 100;
        Assert.assertEquals("5", getMarkResult(mark));
    }

    @Test
    public void MoreThanHundredScoreTest(){
        var mark = 101;
        Assert.assertEquals("no mark result", getMarkResult(mark));
    }
}
