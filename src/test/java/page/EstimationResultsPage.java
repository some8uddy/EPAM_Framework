package page;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static utils.PageUtils.switchToDefaultContent;
import static utils.PageUtils.switchToFrame;

public class EstimationResultsPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement outerFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement innerFrame;

    @FindBy(xpath = "//*[@id='compute']/md-toolbar/h2")
    private WebElement estimateHeader;

    @FindBy(xpath = "//*[@id=\"resultBlock\"]//h2[contains(.,'Total Estimated Cost')]")
    private WebElement estimatedCostField;

    @FindBy(xpath = "//*[@id='email_quote']")
    private WebElement emailEstimateButton;

    @FindBy(xpath = "//form[@name='emailForm']//h2")
    private WebElement emailEstimateForm;

    @FindBy(xpath = "//input[@ng-model='emailQuote.user.email']")
    private WebElement targetEmailField;

    @FindBy(xpath = "//form[@name='emailForm']//button[contains(.,'Send')]")
    private WebElement sendEmailButton;

    public EstimationResultsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getOuterFrame() {
        return outerFrame;
    }

    public WebElement getInnerFrame() {
        return innerFrame;
    }

    public boolean isEstimateHeaderTextEqualTo(String expectedHeaderName) {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(outerFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(innerFrame));
        wait.until(ExpectedConditions.textToBePresentInElement(estimateHeader, expectedHeaderName));
        switchToDefaultContent(driver);
        return true;
    }

    public String getEstimatedCost() {
        switchToFrame(driver, outerFrame, innerFrame);
        String estimatedCost = estimatedCostField.getText();
        switchToDefaultContent(driver);
        return estimatedCost;
    }

    public EstimationResultsPage openEmailEstimateForm() {
        switchToFrame(driver, outerFrame, innerFrame);
        emailEstimateButton.sendKeys(Keys.ENTER);
        new WebDriverWait(driver, 10)
            .until(ExpectedConditions.textToBePresentInElement(emailEstimateForm, "Email Your Estimate"));
        switchToDefaultContent(driver);
        return this;
    }

    public void pasteTargetEmail(String targetEmailAddress) {
        switchToFrame(driver, outerFrame, innerFrame);
        targetEmailField.sendKeys(targetEmailAddress);
        switchToDefaultContent(driver);
    }

    public void sendEmail() {
        switchToFrame(driver, outerFrame, innerFrame);
        sendEmailButton.sendKeys(Keys.ENTER);
        switchToDefaultContent(driver);
    }
}
