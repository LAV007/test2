import org.openqa.selenium.*;
import org.openqa.selenium.WebDriver;

public class GoogleMainPage {

    private WebDriver driver;

    public GoogleMainPage(WebDriver driver) {
        this.driver = driver;
    }


    private By searchInput = By.xpath("//input[@class='gLFyf gsfi']");

    public GoogleMainPage searchValue (String value) {
        driver.findElement(searchInput).sendKeys(value);
        driver.findElement(searchInput).sendKeys(Keys.ENTER);
        return this;
    }

}
