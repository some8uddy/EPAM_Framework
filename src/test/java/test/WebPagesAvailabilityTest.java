package test;

import model.Order;
import org.testng.Assert;
import org.testng.annotations.Test;
import page.EstimationResultsPage;
import page.HomePage;
import service.OrderCreator;
import utils.EmailHandler;

public class WebPagesAvailabilityTest extends CommonConditions {

    @Test(priority = 1, groups = "smoke")
    public void testHomePageIsAccessible() {
        Order testOrder = OrderCreator.withCredentialsFromProperty();
        HomePage searchResultsPage = new HomePage(driver)
            .openPage(testOrder);
        Assert.assertNotNull(searchResultsPage);
    }

    @Test(priority = 2, groups = "smoke")
    public void testEmailPageIsAccessible() {
        EmailHandler emailHandler = new EmailHandler(driver, new EstimationResultsPage(driver));
        String targetEmailAddress = emailHandler.openTargetEmailPage()
                                                .copyEmailAddress().getTargetEmailAddress();
        Assert.assertNotNull(targetEmailAddress);
    }
}
