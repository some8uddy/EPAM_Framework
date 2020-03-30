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

import static utils.PageUtils.switchToDefaultContent;
import static utils.PageUtils.switchToFrame;

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
    private WebElement machineClassDropDown;

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
    private WebElement dataCenterLocationDropDown;

    @FindBy(xpath = "//md-select[@ng-model='listingCtrl.computeServer.cud']")
    private WebElement committedUsageDropDown;

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
        switchToDefaultContent(driver);
        return frameName;
    }

    public CalculatorPage setNumberOfInstances(Order order) {
        switchToFrame(driver, outerFrame, innerFrame);
        instancesField.sendKeys(order.getNumberOfInstances());
        switchToDefaultContent(driver);
        return this;
    }

    public CalculatorPage selectOperatingSystem(Order order) {
        selectFromDropList(osDropDown, order.getOperatingSystem());
        return this;
    }

    public CalculatorPage selectVmClass(Order order) {
        selectFromDropList(machineClassDropDown, order.getVmClass());
        return this;
    }

    public CalculatorPage selectInstanceType(Order order) {
        selectFromDropList(instanceTypeDropDown, order.getInstanceType());
        return this;
    }

    public CalculatorPage checkAddGpusBox() {
        switchToFrame(driver, outerFrame, innerFrame);
        addGpusCheckBox.sendKeys(Keys.ENTER);
        switchToDefaultContent(driver);
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

    public CalculatorPage selectDataCenterLocation(Order order) {
        selectFromDropList(dataCenterLocationDropDown, order.getDatacenterLocation());
        return this;
    }

    public CalculatorPage selectCommittedUsage(Order order) {
        selectFromDropList(committedUsageDropDown, order.getCommitedUsage());
        return this;
    }

    public EstimationResultsPage submit() {
        switchToFrame(driver, outerFrame, innerFrame);
        addToEstimationButton.sendKeys(Keys.ENTER);
        switchToDefaultContent(driver);
        return new EstimationResultsPage(driver);
    }

    private void selectFromDropList(WebElement webElement, String selection) {
        switchToFrame(driver, outerFrame, innerFrame);
        webElement.sendKeys(Keys.ENTER);
        String xpathLocator = String.format("//div[@class='md-select-menu-container md-active md-clickable']" +
            "//md-option[contains(.,'%s')]", selection);
        WebElement option = new WebDriverWait(driver, 10)
            .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpathLocator)));
        option.sendKeys(Keys.ENTER);
        switchToDefaultContent(driver);
    }
}
