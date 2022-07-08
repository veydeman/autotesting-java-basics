import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShoesStoreTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module03/practice1/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testSizePositive() {
        var sizeElement = driver.findElement(By.name("check"));
        var button = driver.findElement(By.id("check-size-button"));
        var expected = "В нашем магазине есть обувь вашего размера";
        sizeElement.sendKeys("36");
        button.click();
        var actual = driver.findElement(By.className("error"));
        Assert.assertEquals("Неверный тест при успешном заполнении", expected, actual.getText());
    }

    @Test
    public void testSizeNegative() {
        var button = driver.findElement(By.id("check-size-button"));
        button.click();
        var expected = "Введите размер обуви!";
        var actual = driver.findElement(By.id("size-error")).getText();
        Assert.assertEquals("Неверный текст ошибки", expected, actual);
        }
}
