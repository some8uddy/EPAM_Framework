package page;

import model.Order;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorPage {

    private WebDriver driver;

    @FindBy(xpath = "//*[@id='cloud-site']/devsite-iframe/iframe")
    private WebElement outerFrame;

    @FindBy(xpath = "//*[@id='myFrame']")
    private WebElement innerFrame;

    @FindBy(xpath = "//md-toolbar//h2")
    private WebElement frameHeader;

    @FindBy(xpath = "//input[@ng-model='listingCtrl.computeServer.quantity']")
    private WebElement instancesField;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.os']")
    private WebElement osDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.class']")
    private WebElement mashineClassDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.instance']")
    private WebElement instanceTypeDropDown;

    @FindBy(xpath = "//md-checkbox[@ng-model='listingCtrl.computeServer.addGPUs']")
    private WebElement addGpusCheckBox;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuCount']")
    private WebElement gpuCountDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.gpuType']")
    private WebElement gpuTypeDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.ssd']")
    private WebElement ssdDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.location']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement commitedUsageDropDown;

    @FindBy(xpath = "//button[@class='md-raised md-primary cpc-button md-button md-ink-ripple']")
    private WebElement addToEstimationButton;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getFrameName() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(outerFrame));
        wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(innerFrame));
        String frameName = frameHeader.getText();
        switchToDefaultContent();
        return frameName;
    }

    public CalculatorPage setNumberOfInstances(Order order) {
        switchToFrame();
        instancesField.sendKeys(order.getNumberOfInstances());
        switchToDefaultContent();
        return this;
    }

    public CalculatorPage selectOperatingSystem(Order order) {
        selectFromDropList(osDropDown, order.getOperatingSystem());
        return this;
    }

    public CalculatorPage selectVmClass(Order order) {
        selectFromDropList(mashineClassDropDown, order.getVmClass());
        return this;
    }

    public CalculatorPage selectInstanceType(Order order) {
        selectFromDropList(instanceTypeDropDown, order.getInstanceType());
        return this;
    }

    public CalculatorPage checkAddGpusBox() {
        switchToFrame();
        addGpusCheckBox.sendKeys(Keys.ENTER);
        switchToDefaultContent();
        return this;
    }

    public CalculatorPage selectNumberOfGpu(Order order) {
        selectFromDropList(gpuCountDropDown, order.getNumberOfGpu());
        return this;
    }

    public CalculatorPage selectGpuType(Order order) {
        selectFromDropList(gpuTypeDropDown, order.getGpuType());
        return this;
    }

    public CalculatorPage selectLocalSsd(Order order) {
        selectFromDropList(ssdDropDown, order.getLocalSsd());
        return this;
    }

    public CalculatorPage selectDatacentrLocation(Order order) {
        selectFromDropList(datacenterLocationDropDown, order.getDatacenterLocation());
        return this;
    }

    public CalculatorPage selectCommittedUsage(Order order) {
        selectFromDropList(commitedUsageDropDown, order.getCommitedUsage());
        return this;
    }

    public EstimationResultsPage submit() {
        switchToFrame();
        addToEstimationButton.sendKeys(Keys.ENTER);
        switchToDefaultContent();
        return new EstimationResultsPage(driver);
    }

    private void selectFromDropList(WebElement webElement, String selection) {
        switchToFrame();
        webElement.sendKeys(Keys.ENTER);
        String xpathLocator = String.format("//div[@class='md-select-menu-container md-active md-clickable']" +
            "//md-option[contains(.,'%s')]", selection);
        WebElement option = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
        option.sendKeys(Keys.ENTER);
        switchToDefaultContent();
    }

    private void switchToFrame() {
        driver.switchTo().frame(outerFrame).switchTo().frame(innerFrame);
    }

    private void switchToDefaultContent() {
        driver.switchTo().defaultContent();
    }
}
