package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class CommonConditions {

    protected WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterTest(alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }

}
