import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OnlineMovieRegistrationTests {

    private WebDriver driver;

    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void registrationPositiveTest(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.name("name")).sendKeys("Ivan");
        driver.findElement(By.name("email")).sendKeys("skillbox@test.ru");
        driver.findElement(By.name("password")).sendKeys("qwerty!123");
        driver.findElement(By.className("form-submit")).click();
        var actual = driver.findElement(By.className("form-result")).getText();
        var expected = "Вам на почту skillbox@test.ru отправлено письмо";
        Assert.assertEquals("Неправильный текст", expected, actual);
    }

    @Test
    public void registrationNegativeTest(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module06/register/");
        driver.findElement(By.className("form-submit")).click();
        var actual = driver.findElement(By.className("form-error")).getText();
        var expected = "Введите имя";
        Assert.assertEquals("Неправильный текст", expected, actual);
    }

    @Test
    public void testOnlineMovieReg(){
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module05/practice1/");
        var emailElement = driver.findElement(By.className("form-input"));
        var password = driver.findElement(By.id("password"));
        var confirmationPass = driver.findElement(By.name("confirm_password"));
    }
}
