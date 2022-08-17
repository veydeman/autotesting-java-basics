import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    // задание 1

    var firstLocator = By.xpath("//*[@class='da-arrows-prev']");
    var secondLocator = By.xpath("//a[@href='#'][@class='da-link button']");
    var thirdLocator = By.xpath("//li[@class='filter']");
    var forthLocator = By.xpath("//*[starts-with(@class,'button')]");
    var fifthLocator = By.xpath("//*[text()='Подписаться сейчас']");
    var sixthLocator = By.xpath("//img[@class='centered']");
    var seventhLocator = By.xpath("//div[@class='span4 price-column animated fadeInDown'][1]/following-sibling::*//li[@class='price']");
    var eightsLocator = By.xpath("//input[@class='span12']");

    // задание 2

    var firstLocator = By.xpath("(//span[@class='baseCard__title'])[5]");// или "//*[text()='Алфавит для взрослых (обновлённый материал)']"
    var secondLocator = By.xpath("(//p[text()='7 месяцев'])[last()]");
    var thirdLocator = By.xpath("//*[@href]/ancestor::div");
    var forthLocator = By.xpath("(//*[@href]/ancestor::div)[5]");
    var fifthLocator = By.xpath("//div[@class='pageCreate__title']/ancestor::*");

    // задание 3

    var firstLocator = By.xpath("//a[@test-info='about-us']");
    var secondLocator = By.xpath("//li/a[text()='Бестселлеры']");
    var thirdLocator = By.xpath("//*[@id='search-input']");
    var forthLocator = By.xpath("//div[@id='total']");
    var fifthLocator = By.xpath("//*[text()='Ваш заказ: ']");
    var sixthLocator = By.xpath("//button[@class='filter-button']");

    private WebDriver driver;

    @Before
    public void setUp()
    {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown()
    {
        driver.quit();
    }
}
