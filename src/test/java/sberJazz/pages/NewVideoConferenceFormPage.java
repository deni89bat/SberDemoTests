package sberJazz.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static sberJazz.utils.CustomLocators.byDataTestId;

public class NewVideoConferenceFormPage {
    protected final WebDriver driver;
    protected static final By formTitle = byDataTestId("title");
    protected static final By userNameInput = byDataTestId("name");
    protected static final By conferenceName = byDataTestId("confName");
    protected static final By createConferenceBtn = byDataTestId("createConf");


    public NewVideoConferenceFormPage(WebDriver driver) {
        this.driver = driver;
    }

    //@Step("Получаем заголовок формы")
    public String getFormTitle() {
        return driver.findElement(formTitle).getText();
    }

    @Step("Пользователь вводит в поле 'Ваше имя' : {name}")
    public NewVideoConferenceFormPage setUserName(String name) {
        driver.findElement(userNameInput).clear();
        driver.findElement(userNameInput).sendKeys(name);
        return this;
    }

    //@Step("Получаем значение из поля 'Ваше имя'")
    public String getUserName() {
        return driver.findElement(userNameInput).getAttribute("value");
    }

    @Step("Пользователь вводит в поле 'Название конференции': {name}")
    public NewVideoConferenceFormPage setConferenceName(String name) {
        driver.findElement(conferenceName).clear();
        driver.findElement(conferenceName).sendKeys(name);
        return this;
    }

    //@Step("Получаем значение из поля 'Название конференции'")
    public String getConferenceName() {
        return driver.findElement(conferenceName).getAttribute("value");
    }

    @Step("Пользователь нажимает кнопку 'Создать и присоединиться'")
    public VideoConferencePage createAndJoin() {
        driver.findElement(createConferenceBtn).click();
        return new VideoConferencePage(driver);
    }

    public WebElement getCreateConfBtnElem() {
        return driver.findElement(createConferenceBtn);
    }
}
