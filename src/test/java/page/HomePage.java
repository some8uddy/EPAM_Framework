package page;

import model.Order;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage {

    @FindBy(name = "q")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(Order order) {
        driver.get(order.getHomePageUrl());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(searchField));
        logger.info("Home page opened.");
        return this;
    }

    public HomePage pasteSearchQuery(Order order) {
        searchField.click();
        searchField.sendKeys(order.getSearchQuery());
        return this;
    }

    public SearchResultsPage submitQuery() {
        searchField.submit();
        logger.info("Search query submitted.");
        return new SearchResultsPage(driver);
    }
}
