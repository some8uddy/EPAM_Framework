package test;

import calculator.CalculatorPage;
import calculator.EstimationResultsPage;
import calculator.HomePage;
import calculator.SearchResultsPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.EmailHandler;

public class PageTest extends CommonConditions{

    private static final String HOMEPAGE_URL = "https://cloud.google.com/";
    private static final String SEARCH_QUERY = "Google Cloud Platform Pricing Calculator";
    private static final String NUMBER_OF_INSTANCES = "4";
    private static final String OPERATING_SYSTEM = "Free: Debian, CentOS, CoreOS, Ubuntu, or other User Provided OS";
    private static final String VM_CLASS = "Regular";
    private static final String INSTANCE_TYPE = "n1-standard-8";
    private static final String NUMBER_OF_GPU = "1";
    private static final String GPU_TYPE = "NVIDIA Tesla V100";
    private static final String LOCAL_SSD = "2x375 GB";
    private static final String DATACENTER_LOCATION = "Frankfurt";
    private static final String COMMITED_USAGE = "1 Year";
    private static final String EXPECTED_ESTIMATE_HEADER_NAME = "Compute Engine";

    private SearchResultsPage searchResultsPage;
    private CalculatorPage calculatorPage;
    private EstimationResultsPage estimationsResultPage;

    @Test(priority = 1)
    public void testSubmitSearchQuery() {
        searchResultsPage = new HomePage(driver)
            .openPage(HOMEPAGE_URL)
            .pasteSearchQuery(SEARCH_QUERY)
            .submitQuery();
        String actualSearchMessage = searchResultsPage.getSearchMessage();
        Assert.assertTrue(actualSearchMessage.contains(SEARCH_QUERY));
    }

    @Test(priority = 2)
    public void testOpenCalculatorPage() {
        calculatorPage = searchResultsPage.clickLink();
        String actualFormName = calculatorPage.getFrameName();
        Assert.assertTrue(actualFormName.contains(SEARCH_QUERY));
    }

    @Test(priority = 3)
    public void testSetData() {
        estimationsResultPage = calculatorPage
            .setNumberOfInstances(NUMBER_OF_INSTANCES)
            .selectOperatingSystem(OPERATING_SYSTEM)
            .selectVmClass(VM_CLASS)
            .selectInstanceType(INSTANCE_TYPE)
            .checkAddGpusBox()
            .selectNumberOfGpu(NUMBER_OF_GPU)
            .selectGpuType(GPU_TYPE)
            .selectLocalSsd(LOCAL_SSD)
            .selectDatacentrLocation(DATACENTER_LOCATION)
            .selectCommittedUsage(COMMITED_USAGE)
            .submit();
        Assert.assertTrue(estimationsResultPage.isEstimateHeaderTextEqualTo(EXPECTED_ESTIMATE_HEADER_NAME));
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