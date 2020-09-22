
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import java.util.concurrent.TimeUnit;

public class TestsUI {

    private WebDriver driver;
    private GoogleMainPage googleMainPage;
    private GoogleSearchResultPage googleSearchResultPage;
    private YandexMarketMainPage yaMarketMainPage;
    private YandexMarketVacuumCleanersPage vacuumCleanersPage;
    private AllFiltersPage allFiltersPage;

    private String driverPath = "C:\\Users\\Denis\\Desktop\\Automation\\ChromeDriver\\chromedriver.exe";
    private String googlePage = "https://www.google.com/";
    private String googleSearchValue = "яндекс маркет";
    private String yaMarketTitle = "market.yandex.ru";
    private String yaMarketLinkText = "Яндекс.Маркет — выбор и покупка товаров из ...";
    private String yaMarketURL = "https://market.yandex.ru/";
    private String titleVacuumCleaners = "«пылесосы» — Пылесосы — купить на Яндекс.Маркете";


    @BeforeMethod
    public void setUp() {

        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @Test
    public void testOne() {

        GoogleMainPage googleMainPage = new GoogleMainPage(driver);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(driver);

        driver.get(googlePage);
        Assert.assertEquals(driver.getCurrentUrl(), googlePage);

        googleMainPage.searchValue(googleSearchValue);
        Assert.assertEquals(googleSearchResultPage.getFirstLinkText(), yaMarketTitle);

        googleSearchResultPage.clickLink(yaMarketLinkText);
        Assert.assertEquals(driver.getCurrentUrl(), yaMarketURL);

    }

    @Test
    public void testTwo() throws InterruptedException {

        YandexMarketMainPage yandexMarketMainPage = new YandexMarketMainPage(driver);
        YandexMarketVacuumCleanersPage vacuumCleanersPage = new YandexMarketVacuumCleanersPage(driver);
        AllFiltersPage allFiltersPage = new AllFiltersPage(driver);
        WebDriverWait wait = new WebDriverWait(driver, 7);

        driver.get(yaMarketURL);
        Assert.assertEquals(driver.getCurrentUrl(), yaMarketURL);

        yandexMarketMainPage.executeSearch("пылесосы");
        wait.until(ExpectedConditions.elementToBeClickable(vacuumCleanersPage.vacuumCleanersLink));
        vacuumCleanersPage.getVacuumCleanersPage();
        wait.until(ExpectedConditions.titleContains(titleVacuumCleaners));
        Assert.assertEquals(driver.getTitle(), titleVacuumCleaners);

        vacuumCleanersPage.enableAllFilters();
        allFiltersPage.setMaxPrice("6000");
        allFiltersPage.scrollDown();
        allFiltersPage.chooseManufacturer("Polaris", "VITEK");
        allFiltersPage.showResults();

        Assert.assertEquals(vacuumCleanersPage.getCurrentMaxPrice(), "6000");
        Assert.assertTrue(vacuumCleanersPage.isManufacturerSelected("Polaris"));
        Assert.assertTrue(vacuumCleanersPage.isManufacturerSelected("VITEK"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
