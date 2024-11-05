package sberJazz.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static sberJazz.utils.CustomLocators.byDataTestId;

public class VideoConferencePage {
    protected final WebDriver driver;

    private final By conferenceName = byDataTestId("headerTitle");
    private final By userName = byDataTestId("participantItem-0");
    private final By exitConferenceBtn = byDataTestId("endButton");
    private final By exitConfirmBtn = byDataTestId("exitMeeting");

    public VideoConferencePage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Пользователь нажимает кнопку 'Выйти'")
    public VideoConferencePage endConference() {
        driver.findElement(exitConferenceBtn).click();
        return this;
    }

    @Step("Пользователь подтверждает выход из конференции нажатием на кнопку 'Выйти из встречи'")
    public VideoConferencePage confirmEndConference() {
        driver.findElement(exitConfirmBtn).click();
        return this;
    }

    public WebElement getExitConferenceBtnElem() {
        return driver.findElement(exitConferenceBtn);
    }

    public String getConferenceName() {
        return driver.findElement(conferenceName).getText();
    }

    public String getUserName() {
        return driver.findElement(userName).getText();
    }

}
