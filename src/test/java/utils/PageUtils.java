package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageUtils {
    public static void switchToFrame(WebDriver driver, WebElement outerFrame, WebElement innerFrame) {
        driver.switchTo().frame(outerFrame).switchTo().frame(innerFrame);
    }

    public static void switchToDefaultContent(WebDriver driver) {
        driver.switchTo().defaultContent();
    }
}
