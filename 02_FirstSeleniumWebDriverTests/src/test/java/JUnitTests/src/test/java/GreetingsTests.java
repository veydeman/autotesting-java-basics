import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreetingsTests {

    private WebDriver driver;

    @Before
    public void SetUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void TearDown() {
        driver.quit();
    }

    @Test
    public void HelloVasyaTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
    }

    @Test
    public void EmptyNameTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        String result = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Неверный текст приветствия", "Привет, !", result);
    }

    @Test
    public void GreetingTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Людвиг Йозеф Витгенштейн");
        driver.findElement(By.name("email")).sendKeys("ludwig@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("89028348223");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, Людвиг Йозеф Витгенштейн.\n" +
                "На вашу почту (ludwig@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89028348223.";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Неверный текст приветствия", expected, actual);
    }

    @Test
    public void EmptyFieldsGreetingTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Неверный текст приветствия", expected, actual);
    }

    @Test
    public void EmptyNameGreetingTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("ludwig@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("89028348223");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, .\n" +
                "На вашу почту (ludwig@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89028348223.";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Неверный текст приветствия", expected, actual);
    }

    @Test
    public void EmptyMailGreetingTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Людвиг Йозеф Витгенштейн");
        driver.findElement(By.name("phone")).sendKeys("89028348223");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, Людвиг Йозеф Витгенштейн.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89028348223.";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Неверный текст приветствия", expected, actual);
    }

    @Test
    public void EmptyPhoneGreetingsTest() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Людвиг Йозеф Витгенштейн");
        driver.findElement(By.name("email")).sendKeys("ludwig@mail.ru");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, Людвиг Йозеф Витгенштейн.\n" +
                "На вашу почту (ludwig@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Неверный текст приветствия", expected, actual);
    }
}
