import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    private WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void testPositiveCase() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var inputMovieElement = driver.findElement(By.tagName("input"));
        var inputSerialElement = driver.findElement(By.name("serials"));
        var enterButtonElement = driver.findElement(By.className("section__button"));
        var buttonPageTwoSelect = driver.findElement(By.id("two"));
        inputMovieElement.sendKeys("Фильм1");
        inputSerialElement.sendKeys("Сериал1");
        enterButtonElement.click();
        buttonPageTwoSelect.click();
        var buttonConfirmation = driver.findElement(By.id("ok"));
        enterButtonElement.click();
        buttonConfirmation.click();
        var expectedFilm = "Фильм1";
        var expectedSerial = "Сериал1";
        var bestFilmsElement = driver.findElement(By.id("best_films"));
        var bestSerialsElement = driver.findElement(By.id("best_serials"));
        Assert.assertEquals("Неправильный текст фильма", expectedFilm, bestFilmsElement.getText());
        Assert.assertEquals("Неправильный текст сериала", expectedSerial, bestSerialsElement.getText());
    }

    @Test
    public void testEmptyInput() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var inputMovieElement = driver.findElement(By.tagName("input"));
        var inputSerialElement = driver.findElement(By.name("serials"));
        var enterButtonElement = driver.findElement(By.className("section__button"));
        var buttonPageTwoSelect = driver.findElement(By.id("two"));
        inputMovieElement.sendKeys("");
        inputSerialElement.sendKeys("");
        enterButtonElement.click();
        buttonPageTwoSelect.click();
        var buttonConfirmation = driver.findElement(By.id("ok"));
        enterButtonElement.click();
        buttonConfirmation.click();
        var expectedFilm = "";
        var expectedSerial = "";
        var bestFilmsElement = driver.findElement(By.id("best_films"));
        var bestSerialsElement = driver.findElement(By.id("best_serials"));
        Assert.assertEquals("Неправильный текст фильма", expectedFilm, bestFilmsElement.getText());
        Assert.assertEquals("Неправильный текст сериала", expectedSerial, bestSerialsElement.getText());
    }

    @Test
    public void testEmptySerialsInput() {
        driver.navigate().to("https://lm.skillbox.cc/qa_tester/module07/practice3/");
        var inputMovieElement = driver.findElement(By.tagName("input"));
        var inputSerialElement = driver.findElement(By.name("serials"));
        var enterButtonElement = driver.findElement(By.className("section__button"));
        var buttonPageTwoSelect = driver.findElement(By.id("two"));
        inputMovieElement.sendKeys("Фильм1");
        inputSerialElement.sendKeys("");
        enterButtonElement.click();
        buttonPageTwoSelect.click();
        var buttonConfirmation = driver.findElement(By.id("ok"));
        enterButtonElement.click();
        buttonConfirmation.click();
        var expectedFilm = "Фильм1";
        var expectedSerial = "";
        var bestFilmsElement = driver.findElement(By.id("best_films"));
        var bestSerialsElement = driver.findElement(By.id("best_serials"));
        Assert.assertEquals("Неправильный текст фильма", expectedFilm, bestFilmsElement.getText());
        Assert.assertEquals("Неправильный текст сериала", expectedSerial, bestSerialsElement.getText());
    }
}

