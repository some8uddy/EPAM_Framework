package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TargetEmailHomePage extends AbstractPage {

    @FindBy(xpath = "//*[@id='mail_address']")
    private WebElement emailAddress;

    @FindBy(xpath = "//span[contains(.,'Google Cloud Platform Price Estimate')]//preceding::div[@class='small_message_icon_box']")
    private WebElement googleEmailHeader;

    @FindBy(xpath = "//*[@id='mobilepadding']//td[2]//h3[1]")
    private WebElement estimatedCostField;

    public TargetEmailHomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getEmailAddress() {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.attributeToBeNotEmpty(emailAddress, "value"));
        logger.info("Target email created.");
        return emailAddress.getAttribute("value");
    }

    public String getEstimatedCost() {
        new WebDriverWait(driver, 60 * 10, 1000).until(ExpectedConditions.elementToBeClickable(googleEmailHeader));
        googleEmailHeader.click();
        logger.info("Order estimation info received.");
        return estimatedCostField.getText();
    }
}
