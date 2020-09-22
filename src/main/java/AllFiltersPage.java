import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static java.lang.String.format;
import static org.openqa.selenium.By.xpath;

public class AllFiltersPage {
    private WebDriver driver;

    public AllFiltersPage(WebDriver driver) {
        this.driver = driver;
    }

    private By maxPriceBox = xpath("//input[@placeholder='62 490']");
    private String manufacturerXpath = "//div[@class='_8yOdX16rYb']/label/div[text()='%s']";
    protected By showMoreButton = By.xpath("//span[@class='_14Uuc5WvKg'][text()='Показать ещё']");
    private By showOffersButton = By.xpath("//a[@class='_2qvOOvezty _3qN-vKmEan _1Rc6LxE3Tr']");

    public void setMaxPrice(String price) {
        driver.findElement(maxPriceBox).sendKeys(price);
    }

    public void showMore() {

        driver.findElement(showMoreButton).click();
    }

    public void showResults() {

        driver.findElement(showOffersButton).click();
    }

    public AllFiltersPage chooseManufacturer(String name, String name2) {
        driver.findElement(xpath(format(manufacturerXpath, name))).click();
        driver.findElement(xpath(format(manufacturerXpath, name2))).click();
        return this;
    }

    public void scrollDown() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,300)");
    }




}
