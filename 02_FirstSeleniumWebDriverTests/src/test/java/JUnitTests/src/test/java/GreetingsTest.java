import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GreetingsTest {

    @Test
    public void HelloVasyaTest() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.name("name")).sendKeys("Вася");
        driver.findElement(By.className("button")).click();
        driver.quit();
    }

    @Test
    public void EmptyNameTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module01/");
        driver.findElement(By.className("button")).click();
        String result = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals("Привет, !", result);
        driver.quit();
    }

    @Test
    public void GreetingTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Людвиг Йозеф Витгенштейн");
        driver.findElement(By.name("email")).sendKeys("ludwig@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("89028348223");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, Людвиг Йозеф Витгенштейн.\n" +
                "На вашу почту (ludwig@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89028348223.";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void EmptyFieldsGreetingTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, .\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void EmptyNameGreetingTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("email")).sendKeys("ludwig@mail.ru");
        driver.findElement(By.name("phone")).sendKeys("89028348223");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, .\n" +
                "На вашу почту (ludwig@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89028348223.";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void EmptyMailGreetingTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Людвиг Йозеф Витгенштейн");
        driver.findElement(By.name("phone")).sendKeys("89028348223");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, Людвиг Йозеф Витгенштейн.\n" +
                "На вашу почту () отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: 89028348223.";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals(expected, actual);
        driver.quit();
    }

    @Test
    public void EmptyPhoneGreetingsTest(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module02/homework1/");
        driver.findElement(By.name("name")).sendKeys("Людвиг Йозеф Витгенштейн");
        driver.findElement(By.name("email")).sendKeys("ludwig@mail.ru");
        driver.findElement(By.className("button")).click();
        String expected = "Здравствуйте, Людвиг Йозеф Витгенштейн.\n" +
                "На вашу почту (ludwig@mail.ru) отправлено письмо.\n" +
                "Наш сотрудник свяжется с вами по телефону: .";
        String actual = driver.findElement(By.className("start-screen__res")).getText();
        Assert.assertEquals(expected, actual);
        driver.quit();
    }
}
