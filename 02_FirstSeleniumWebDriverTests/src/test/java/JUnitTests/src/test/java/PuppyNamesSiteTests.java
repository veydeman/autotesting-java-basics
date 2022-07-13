import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PuppyNamesSiteTests {

    private static WebDriver driver;

    private final By radioButtonMaleLocator = By.id("boy");
    private final By radioButtonFemaleLocator = By.id("girl");
    private final By inputEmailLocator = By.name("email");
    private final By sendMeButtonLocator = By.id("sendMe");
    private final By emailTextLocator = By.className("your-email");
    private final String email = "test@test.ru";

    @BeforeClass
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
    }

    @AfterClass
    public static void tearDown(){
        driver.close();
    }

    @Test
    public void testCase1(){
        driver.findElement(radioButtonFemaleLocator).click();
        driver.findElement(inputEmailLocator).sendKeys(email);
        driver.findElement(sendMeButtonLocator).click();
        Assert.assertTrue("Нет текста e-mail", driver.findElement(emailTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст e-mail", email, driver.findElement(emailTextLocator).getText());
    }

    @Test
    public void testCase2(){
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/practice/");
        driver.findElement(radioButtonMaleLocator).click();
        driver.findElement(inputEmailLocator).sendKeys(email);
        driver.findElement(sendMeButtonLocator).click();
        Assert.assertTrue("Нет текста e-mail", driver.findElement(emailTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст e-mail", email, driver.findElement(emailTextLocator).getText());
    }
}
