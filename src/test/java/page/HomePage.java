package page;

import model.Order;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;

    @FindBy(name = "q")
    private WebElement searchField;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public HomePage openPage(Order order) {
        driver.get(order.getHomePageUrl());
        new WebDriverWait(driver, 10)
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
