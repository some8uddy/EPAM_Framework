package test;

import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.CalculatorPage;
import page.EstimationResultsPage;
import page.HomePage;
import page.SearchResultsPage;
import service.OrderCreator;
import utils.EmailHandler;

public class PageTest extends CommonConditions {

    private SearchResultsPage searchResultsPage;
    private CalculatorPage calculatorPage;
    private EstimationResultsPage estimationsResultPage;
    private Order testOrder;

    @Test(priority = 1)
    public void testSubmitSearchQuery() {
        testOrder = OrderCreator.withCredentialsFromProperty();
        String expectedMessage = testOrder.getSearchQuery();
        searchResultsPage = new HomePage(driver)
            .openPage(testOrder)
            .pasteSearchQuery(testOrder)
            .submitQuery();
        String actualSearchMessage = searchResultsPage.getSearchMessage();
        Assert.assertTrue(actualSearchMessage.contains(expectedMessage));
    }

    @Test(priority = 2)
    public void testOpenCalculatorPage() {
        calculatorPage = searchResultsPage.clickLink();
        String expectedMessage = testOrder.getSearchQuery();
        String actualFormName = calculatorPage.getFrameName();
        Assert.assertTrue(actualFormName.contains(expectedMessage));
    }

    @Test(priority = 3)
    public void testSetData() {
        String expectedMessage = testOrder.getExpectedEstimateHeaderName();
        estimationsResultPage = calculatorPage
            .setNumberOfInstances(testOrder)
            .selectOperatingSystem(testOrder)
            .selectVmClass(testOrder)
            .selectInstanceType(testOrder)
            .checkAddGpusBox()
            .selectNumberOfGpu(testOrder)
            .selectGpuType(testOrder)
            .selectLocalSsd(testOrder)
            .selectDataCenterLocation(testOrder)
            .selectCommittedUsage(testOrder)
            .submit();
        Assert.assertTrue(estimationsResultPage.isEstimateHeaderTextEqualTo(expectedMessage));
    }

    @Test(priority = 4)
    public void testGetEstimateThroughEmail() {
        String estimatedCost = estimationsResultPage.getEstimatedCost();
        EmailHandler emailHandler = new EmailHandler(driver, estimationsResultPage);
        String estimatedCostFromEmail = emailHandler.openTargetEmailPage()
                                                    .copyEmailAddress()
                                                    .pasteEmailAddressToEstimationResultsForm()
                                                    .sendEstimationsToEmail()
                                                    .getEstimatedCostFromEmail();
        Assert.assertTrue(estimatedCost.contains(estimatedCostFromEmail));
    }
}