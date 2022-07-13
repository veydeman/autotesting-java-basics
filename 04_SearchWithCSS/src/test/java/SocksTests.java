import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SocksTests {
    private static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/index.html");
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }

    @Test
    public void testNegativeCase() {

        By emailInputLocator = By.tagName("input");
        By passInputLocator = By.name("password");
        By enterButtonLocator = By.className("form-submit");
        By errorTextLocator = By.id("error");

        driver.findElement(emailInputLocator).sendKeys("@");
        driver.findElement(passInputLocator).sendKeys("123");
        driver.findElement(enterButtonLocator).click();
        Assert.assertTrue("Нет текста с ошибкой", driver.findElement(errorTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст с ошибкой", "Некорректный email или пароль",
                driver.findElement(errorTextLocator).getText());
    }

    @Test
    public void testNegativeCaseWithCssLocators() {

        By emailInputLocator = By.cssSelector(".form-input");
        By passInputLocator = By.cssSelector(".form-input.password");
        By enterButtonLocator = By.cssSelector(".form-submit");
        By errorTextLocator = By.cssSelector(".form-error-password-email");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");

        driver.findElement(emailInputLocator).sendKeys("@");
        driver.findElement(passInputLocator).sendKeys("123");
        driver.findElement(enterButtonLocator).click();
        Assert.assertTrue("Нет текста с ошибкой", driver.findElement(errorTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст с ошибкой", "Некорректный email или пароль",
                driver.findElement(errorTextLocator).getText());
    }

    @Test
    public void testNegativeCaseWithCssLocators2() {

        By emailInputLocator = By.cssSelector("input.form-input.input-data");
        By passInputLocator = By.cssSelector("input.form-input.password");
        By enterButtonLocator = By.cssSelector("button.form-submit");
        By errorTextLocator = By.cssSelector("pre.form-error-password-email");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");

        driver.findElement(emailInputLocator).sendKeys("@");
        driver.findElement(passInputLocator).sendKeys("123");
        driver.findElement(enterButtonLocator).click();
        Assert.assertTrue("Нет текста с ошибкой", driver.findElement(errorTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст с ошибкой", "Некорректный email или пароль",
                driver.findElement(errorTextLocator).getText());
    }

    @Test
    public void testNegativeCaseWithCssLocators3() {

        By emailInputLocator = By.cssSelector("input#email");
        By passInputLocator = By.cssSelector("input#password");
        By enterButtonLocator = By.cssSelector("button#submit");
        By errorTextLocator = By.cssSelector("pre#error");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");

        driver.findElement(emailInputLocator).sendKeys("@");
        driver.findElement(passInputLocator).sendKeys("123");
        driver.findElement(enterButtonLocator).click();
        Assert.assertTrue("Нет текста с ошибкой", driver.findElement(errorTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст с ошибкой", "Некорректный email или пароль",
                driver.findElement(errorTextLocator).getText());
    }

    @Test
    public void testNegativeCaseWithCssLocators4() {

        By emailInputLocator = By.cssSelector("input.form-input.input-data#email");
        By passInputLocator = By.cssSelector("input.form-input.password#password");
        By enterButtonLocator = By.cssSelector("button.form-submit#submit");
        By errorTextLocator = By.cssSelector("pre.form-error-password-email#error");

        driver.navigate().to("http://qajava.skillbox.ru/module04/homework/auth/changed.html");

        driver.findElement(emailInputLocator).sendKeys("@");
        driver.findElement(passInputLocator).sendKeys("123");
        driver.findElement(enterButtonLocator).click();
        Assert.assertTrue("Нет текста с ошибкой", driver.findElement(errorTextLocator).isDisplayed());
        Assert.assertEquals("Неправильный текст с ошибкой", "Некорректный email или пароль",
                driver.findElement(errorTextLocator).getText());
    }
}
