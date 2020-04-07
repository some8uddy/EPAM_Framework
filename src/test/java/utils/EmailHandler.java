package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import page.EstimationResultsPage;
import page.TargetEmailHomePage;

import java.util.ArrayList;

public class EmailHandler {

    private final Logger logger = LogManager.getRootLogger();
    private WebDriver driver;
    private EstimationResultsPage estimationResultsPage;
    private TargetEmailHomePage targetEmailHomePage;
    private String estimationWindowHandler;
    private String targetEmailWindowHandler;
    private String targetEmailAddress;

    public EmailHandler(WebDriver driver, EstimationResultsPage estimationResultsPage) {
        this.driver = driver;
        this.estimationResultsPage = estimationResultsPage;
    }

    public EmailHandler openTargetEmailPage() {
        estimationWindowHandler = driver.getWindowHandle();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('https://10minutemail.com','_blank');");
        ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
        for (String handler : tabs) {
            if (!estimationWindowHandler.equals(handler)) {
                targetEmailWindowHandler = handler;
            }
        }
        switchToEmailTab();
        targetEmailHomePage = new TargetEmailHomePage(driver);
        logger.info("Target email page opened.");
        return this;
    }

    public EmailHandler copyEmailAddress() {
        switchToEmailTab();
        targetEmailAddress = targetEmailHomePage.getEmailAddress();
        logger.info("Target email address acquired.");
        return this;
    }

    public EmailHandler pasteEmailAddressToEstimationResultsForm() {
        switchToEstimationTab();
        estimationResultsPage.openEmailEstimateForm();
        estimationResultsPage.pasteTargetEmail(targetEmailAddress);
        return this;
    }

    public EmailHandler sendEstimationsToEmail() {
        switchToEstimationTab();
        estimationResultsPage.sendEmail();
        logger.info("Estimation info was sent to target email address.");
        return this;
    }

    public String getEstimatedCostFromEmail() {
        switchToEmailTab();
        return targetEmailHomePage.getEstimatedCost();
    }

    public String getTargetEmailAddress() {
        return targetEmailAddress;
    }

    private void switchToEmailTab() {
        driver.switchTo().window(targetEmailWindowHandler);
    }

    private void switchToEstimationTab() {
        driver.switchTo().window(estimationWindowHandler);
    }
}
