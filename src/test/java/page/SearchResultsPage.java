package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchResultsPage extends AbstractPage {

    @FindBy(xpath = "//a/b[text()='Google Cloud Platform Pricing Calculator']")
    private WebElement searchResultsLink;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getSearchMessage() {
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[@class='devsite-search-title']")))
            .getText();
    }

    public CalculatorPage clickLink() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
            .until(ExpectedConditions.elementToBeClickable(searchResultsLink))
            .click();
        logger.info("Link to calculator page clicked.");
        return new CalculatorPage(driver);
    }
}
