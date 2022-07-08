import org.junit.Assert;
import org.junit.Test;

public class RefundTicketPricePercentTests {

    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled,
                                                Boolean wasConcertRescheduled) {

        if (wasConcertCancelled && wasConcertRescheduled) return 100;
        if (hoursBeforeConcert > 240) return 100;
        if (hoursBeforeConcert >= 144 && hoursBeforeConcert <= 240) return 50;
        if (hoursBeforeConcert > 3 && hoursBeforeConcert <= 144) return 30;

        return 0;
    }

    @Test
    public void MoreThanTenDaysTest(){
        int result = getRefundTicketPricePercent(241, false, false);
        Assert.assertEquals(100, result);
    }

    @Test
    public void TenDaysTest(){
        int result = getRefundTicketPricePercent(240, false, false);
        Assert.assertEquals(50, result);
    }

    @Test
    public void LessThanTenDays(){
        int result = getRefundTicketPricePercent(239, false, false);
        Assert.assertEquals(50, result);
    }

    @Test
    public void SixDaysTest(){
        int result = getRefundTicketPricePercent(144, false, false);
        Assert.assertEquals(50, result);
    }

    @Test
    public void FiveDaysTest(){
        int result = getRefundTicketPricePercent(120, false, false);
        Assert.assertEquals(30, result);
    }

    @Test
    public void MoreThanThreeDaysTest(){
        int result = getRefundTicketPricePercent(73, false, false);
        Assert.assertEquals(30, result);
    }

    @Test
    public void ThreeDaysTest(){
        int result = getRefundTicketPricePercent(72, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void LessThanThreeDays(){
        int result = getRefundTicketPricePercent(71, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void TwoHoursBeforeTest(){
        int result = getRefundTicketPricePercent(2, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void ZeroHoursTest(){
        int result = getRefundTicketPricePercent(0, false, false);
        Assert.assertEquals(0, result);
    }

    @Test
    public void NegativeHoursTest(){
        int result = getRefundTicketPricePercent(-1, false, false);
        Assert.assertEquals(0, result);
    }
}
