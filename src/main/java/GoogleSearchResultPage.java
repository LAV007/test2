import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import static java.lang.String.format;
import java.util.List;

import static org.openqa.selenium.By.xpath;

public class GoogleSearchResultPage {

    private WebDriver driver;

    public GoogleSearchResultPage(WebDriver driver) {
        this.driver = driver;
    }


    private String linkValue = "//h3[text()='%s']";

    public String getFirstLinkText() {
        List<WebElement> links = driver.findElements(xpath("//cite"));
        String linkText = links.get(0).getText();
        return linkText;
    }

    public GoogleSearchResultPage clickLink(String linkName) {
        driver.findElement(xpath(format(linkValue, linkName))).click();
        return this;
    }

}
