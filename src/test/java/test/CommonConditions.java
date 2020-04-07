package test;

import driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterGroups;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Listeners;
import utils.TestListener;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;

    @BeforeGroups(value = {"smoke", "main"}, alwaysRun = true)
    public void browserSetUp() {
        driver = DriverSingleton.getDriver();
    }

    @AfterGroups(value = {"smoke", "main"}, alwaysRun = true)
    public void browserTearDown() {
        DriverSingleton.closeDriver();
    }
}
