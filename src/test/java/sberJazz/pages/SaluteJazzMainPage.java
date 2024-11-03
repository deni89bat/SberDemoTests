package sberJazz.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static sberJazz.utils.CustomLocators.byDataTestId;

public class SaluteJazzMainPage {
    protected final WebDriver driver;
    protected final By videoConferenceBtn = byDataTestId("startConf");
    protected final By planConferenceBtn = byDataTestId("planConf");
    protected final By joinToConferenceBtn = byDataTestId("joinConf");

    public SaluteJazzMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getTitle() {
        return driver.getTitle();
    }

    @Step("Пользователь нажимает кнопку 'Создать новую видеовстречу'")
    public NewVideoConferenceFormPage startVideoConference() {
                driver.findElement(videoConferenceBtn).click();

        return new NewVideoConferenceFormPage(driver);
    }
    public SaluteJazzMainPage planVideoConference() {
        driver.findElement(planConferenceBtn).click();
        return this;
    }

    public SaluteJazzMainPage joinToVideoConference() {
        driver.findElement(joinToConferenceBtn).click();
        return this;
    }




}
