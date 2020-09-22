import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class YandexMarketVacuumCleanersPage {

    private WebDriver driver;

    public YandexMarketVacuumCleanersPage(WebDriver driver) {
        this.driver = driver;
    }

    protected By vacuumCleanersLink = By.xpath("//span[text()='Пылесосы']");
    private By allFiltersButton = By.xpath("//span[text()='Все фильтры']");
    private String manufacturer = "//div[@class='_1DqdIFuq1G']/ul/li//span[text()='%s']";
    private By maxPriceField = By.xpath("//input[@name='Цена до']");
    private String manufacturerCheckbox = "//input[@name='Производитель %s']";

    public void getVacuumCleanersPage() {

        driver.findElement(vacuumCleanersLink).click();
    }

    public void enableAllFilters() {

        driver.findElement(allFiltersButton).click();
    }

    public YandexMarketVacuumCleanersPage selectManufacturer(String name) {
        driver.findElement(xpath(format(manufacturer, name))).click();
        return this;
    }

    public YandexMarketVacuumCleanersPage selectManufacturer(String name, String name2) {
        driver.findElement(xpath(format(manufacturer, name))).click();
        driver.findElement(xpath(format(manufacturer, name2))).click();
        return this;
    }

    public String getCurrentMaxPrice() {
        String maxPrice = driver.findElement(maxPriceField).getAttribute("value");
        return maxPrice;
    }

    public boolean isManufacturerSelected(String name) {
        boolean isSelected = driver.findElement(xpath(format(manufacturerCheckbox, name))).isSelected();
        return isSelected;
    }


}
