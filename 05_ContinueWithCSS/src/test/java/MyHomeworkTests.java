import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyHomeworkTests {

    private WebDriver driver;

    //Локаторы на главной странице для элемента <a href="" test-info="about-us">О магазине</a>.
    // Осуществите поиск только по атрибуту test-info, равному about-us.
    By cssSelector1 = By.cssSelector("div>a[test-info='about-us']");

    // Локатор на главной странице для всех элементов с тегом a и с атрибутом href с пустым значением, то есть равным «».
    By cssSelector2 = By.cssSelector("a[href='']");

    //Локатор на странице поиска для всех элементов с тегом option и с атрибутом selected.
    // Осуществите поиск только по атрибуту selected.
    By cssSelector3 = By.cssSelector("[selected='']");

    //Локатор на главной странице для элемента <div class="book-price">.
    // Осуществите поиск одновременно по тегу и классу, равному book-price.
    By cssSelector4 = By.cssSelector("div.book-price");

    //Локатор на главной странице  для всех элементов с тегом button и с атрибутом class, начинающимся на book.
    By cssSelector5 = By.cssSelector("button[class^='book']");

    //Локатор на главной странице для всех элементов, у которых атрибут class заканчивается на main.
    By cssSelector6 = By.cssSelector("[class$='main']");

    //Локатор на главной странице для всех элементов с тегом a и с атрибутом class, содержащим в себе слово menu.
    By cssSelector7 = By.cssSelector("a[class*='menu']");

    //На главной странице найдите все теги div, которые являются дочерними элементами первого уровня у элемента
    // <footer id="footer">.
    By cssSelector8 = By.cssSelector("footer#footer>div");

    //На главной странице найдите любой тег, который расположен сразу после <li id="genres">.
    By cssSelector9 = By.cssSelector("ul > li#genres + *");

    //На странице поиска найдите любые теги, которые расположены после <div class="filter-container">
    // (необязательно ближайший сосед).
    By cssSelector10 = By.cssSelector("body > div.filter-container ~ *");

    //Первый тег h1, находящийся сразу на первом уровне вложенности внутри
    // <section class="important-section-block" for="main-header-page">. Используйте поиск по первому child.
    By cssSelector11 = By.cssSelector("section.important-section-block[for='main-header-page']>h1:nth-child(1)");

    //Последний тег p, находящийся сразу на первом уровне вложенности внутри <form class="form" id="login-form">.
    // Используйте поиск по child.
    By cssSelector12 = By.cssSelector("form.form#login-form > p:last-child");

    //Любой тег, который является третьим дочерним элементом первого уровня тега <body>. Используйте поиск по child.
    By cssSelector13 = By.cssSelector("body>*:nth-child(3)");

    //Все элементы с тегом <a>, которые являются первым элементом своего родителя <div class="footer__menuList">.
    // Используйте поиск по type.
    By cssSelector14 = By.cssSelector("div.footer__menuList > a:nth-of-type(1)");

    //По желанию: найдите элемент с тегом <a>, который является первым дочерним элементом данного типа у своего родителя
    //<div class="footer__menuList">, при этом <div class="footer__menuList">
    // является первым дочерним элементом у своего родителя <div class="footer__menu">.
    // Составленный поиск должен вернуть ровно один найденный элемент.
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
