import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KittensSiteTests {

    private static WebDriver driver;

    private final By emailInputLocator = By.className("email");
    private final By buttonLocator = By.id("write-to-me");
    private final By emailResultLocator = By.className("result-email");
    private final String email = "test@test.com";

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    @Test
    public void testPositiveCase() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(emailInputLocator).sendKeys(email);
        driver.findElement(buttonLocator).click();
        Assert.assertTrue("Нет текста e-mail", driver.findElement(emailResultLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст e-mail", email, driver.findElement(emailResultLocator).getText());
    }

    @Test
    public void testNegativeCase() {
        driver.navigate().to("http://qajava.skillbox.ru/module04/lesson2/");
        driver.findElement(buttonLocator).click();
        Assert.assertEquals("Неправильный текст e-mail", "", driver.findElement(emailResultLocator).getText());
    }
}
