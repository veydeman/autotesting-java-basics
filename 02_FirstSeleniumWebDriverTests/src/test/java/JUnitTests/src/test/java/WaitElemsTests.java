import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class WaitElemsTests {
    private static WebDriver driver;
    private static WebDriverWait wait;

    @BeforeClass
    public static void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        wait = new WebDriverWait(driver, 5);
    }

    @AfterClass
    public static void tearDown()
    {
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        By articleLocator = By.cssSelector("button.articlePreview__link");
        By titleArticlePreviewLocator = By.cssSelector("div.vb-content > div:nth-child(1) > div.articlePreview__content > p.articlePreview__title");
        By textArticlePreviewLocator = By.cssSelector("div.vb-content > div:nth-child(1) > div.articlePreview__content > p.articlePreview__text");
        By articlePreviewLocator = By.cssSelector("div.vb-content > div:nth-child(1) > button");
        By centralDeleteLocator = By.cssSelector("button.pageArticle__button:nth-child(2)");
        By rightDeleteLocator = By.cssSelector("div.vb-content > div:nth-child(1) > div.articlePreview__buttons > button:nth-child(2)");
        By centralTitleLocator = By.cssSelector("input.baseInput__field");
        By centralTextLocator = By.cssSelector("textarea.baseTextarea__text");

        driver.navigate().to("http://qa.skillbox.ru/module15/bignotes/#/statistic");
        driver.findElement(articleLocator).click();
        Assert.assertTrue(driver.findElement(centralTitleLocator).isDisplayed());
        Assert.assertTrue(driver.findElement(titleArticlePreviewLocator).isDisplayed());
        Assert.assertEquals("План на следующий месяц", driver.findElement(titleArticlePreviewLocator).getText());
        Assert.assertEquals("Прочитать книгу «Искусство цвета».", driver.findElement(textArticlePreviewLocator).getText());
        driver.findElement(centralDeleteLocator).click();
        driver.findElement(articlePreviewLocator).click();
        driver.findElement(centralDeleteLocator).click();
        wait.until(ExpectedConditions.invisibilityOfElementLocated(articlePreviewLocator));
        Assert.assertEquals(driver.findElements(By.cssSelector("div.vb-content *")).size(), 0);
    }
}
