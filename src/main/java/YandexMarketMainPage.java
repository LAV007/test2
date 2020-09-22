import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class YandexMarketMainPage {
    private WebDriver driver;

    public YandexMarketMainPage(WebDriver driver) {
        this.driver = driver;
    }

    private By searchBox = By.xpath("//input[@id='header-search']");

    public YandexMarketMainPage executeSearch(String searchValue) {
        driver.findElement(searchBox).sendKeys(searchValue);
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
        return this;
    }
}
