import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BookStoreTests {
    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("http://qajava.skillbox.ru/");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testLocators() {
        driver.findElement(By.linkText("Обратная связь"));
        driver.findElement(By.linkText("Предзаказы"));
        driver.findElement(By.className("book-add"));
        driver.findElement(By.id("cart_count"));
        driver.findElement(By.id("genres"));
        driver.findElement(By.tagName("input"));
    }

    @Test
    public void testElementsCount(){
        var elements = driver.findElements(By.className("book-info"));
        Assert.assertEquals("Неверное количество элементов", 15, elements.size());
    }


}
