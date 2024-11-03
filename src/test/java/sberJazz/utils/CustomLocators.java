package sberJazz.utils;

import org.openqa.selenium.By;

public class CustomLocators {
    public static By byDataTestId(String testId) {
        return By.xpath(String.format("//*[@data-testid='%s']", testId));
    }
}
