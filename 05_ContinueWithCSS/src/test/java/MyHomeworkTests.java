import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    private WebDriver driver;

    By cssSelector1 = By.cssSelector("div>a[test-info='about-us']");
    By cssSelector2 = By.cssSelector("a[href='']");
    By cssSelector3 = By.cssSelector("[selected='']");
    By cssSelector4 = By.cssSelector("div.book-price");
    By cssSelector5 = By.cssSelector("button[class^='book']");
    By cssSelector6 = By.cssSelector("[class$='main']");
    By cssSelector7 = By.cssSelector("a[class*='menu']");
    By cssSelector8 = By.cssSelector("footer#footer>div");
    By cssSelector9 = By.cssSelector("ul > li#genres + *");
    By cssSelector10 = By.cssSelector("body > div.filter-container ~ *");
    By cssSelector11 = By.cssSelector("section.important-section-block[for='main-header-page']>h1:nth-child(1)");
    By cssSelector12 = By.cssSelector("form.form#login-form > p:last-child");
    By cssSelector13 = By.cssSelector("body>*:nth-child(3)");
    By cssSelector14 = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");
    By cssSelector15 = By.cssSelector("div.footer__menu>div.footer__menuList:nth-of-type(1)>a:nth-of-type(1)");

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
