import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PcRepairTests {

    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();

    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testFeedBack() {
        By nameInputLocator = By.cssSelector(".data.text");
        By emailInputLocator = By.cssSelector(".data.field");
        By feedbackInputLocator = By.cssSelector(".field.text");
        By sendButtonLocator = By.id("comment");
        By textLocator = By.className("message-header");

        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/os.html");
        String email = "test@test.ru";
        driver.findElement(nameInputLocator).sendKeys("Ваня");
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(feedbackInputLocator).sendKeys("Все отлично");
        driver.findElement(sendButtonLocator).click();
        Assert.assertTrue("Нет текста со спасибо", driver.findElement(textLocator).isDisplayed());
    }

    @Test
    public void testOrderPlace() {
        By fullNameInputLocator = By.cssSelector(".form-input.fio");
        By streetInputLocator = By.cssSelector(".data.form-input.street");
        By houseNumberInputLocator = By.cssSelector(".form-input.house");
        By apartmentNumberInputLocator = By.cssSelector(".form-input.flat");
        By dayInputLocator = By.cssSelector(".form-input.date");
        By submitButtonLocator = By.cssSelector(".form-submit");
        By formResultLocator = By.cssSelector(".form-result.result");

        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson3/index.html");
        driver.findElement(fullNameInputLocator).sendKeys("Иванов Лев Николаевич");
        driver.findElement(streetInputLocator).sendKeys("Светлая");
        driver.findElement(houseNumberInputLocator).sendKeys("9");
        driver.findElement(apartmentNumberInputLocator).sendKeys("675");
        driver.findElement(dayInputLocator).sendKeys("среда");
        driver.findElement(submitButtonLocator).click();
        Assert.assertTrue("Нет формы с результатами", driver.findElement(formResultLocator).isDisplayed());
    }
}
