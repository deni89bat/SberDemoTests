package sberJazz.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sberJazz.pages.NewVideoConferenceFormPage;
import sberJazz.pages.VideoConferencePage;

import java.time.Duration;

public class SalutJazzTests extends BaseTest {
    CustomAssertions customAssertions = new CustomAssertions();
    private VideoConferencePage videoConferencePage;
    private boolean isConferenceCreated = false; // Флаг для отслеживания создания конференции


    @Test
    @DisplayName("Создание новой видеоконференции")
    void successfulNewConferenceTest() {
        String expectedUserName = "Денис который хочет работать в Сбере";
        String expectedConferenceName = "Встреча для теста";
        NewVideoConferenceFormPage videoConferenceFormPage;

        String actualPageTitle = saluteJazzMainPage.getTitle();
        customAssertions.assertPageTitle("SaluteJazz", actualPageTitle);

        videoConferenceFormPage = saluteJazzMainPage.startVideoConference();

        String actualFormTitle = videoConferenceFormPage.getFormTitle();
        customAssertions.assertFormTitle("Новая видеовстреча", actualFormTitle);
        customAssertions.assertButtonIsDisabled(videoConferenceFormPage.getCreateConfBtnElem(), "Создать и присоединиться");

        videoConferenceFormPage.setUserName(expectedUserName);
        videoConferenceFormPage.setConferenceName(expectedConferenceName);

        String actualUserNameText = videoConferenceFormPage.getUserName();
        customAssertions.assertUserName(expectedUserName, actualUserNameText);
        String actualConferenceNameText = videoConferenceFormPage.getConferenceName();
        customAssertions.assertConferenceName(expectedConferenceName, actualConferenceNameText);
        customAssertions.assertButtonIsEnabled(videoConferenceFormPage.getCreateConfBtnElem(), "Создать и присоединиться");

        videoConferencePage = videoConferenceFormPage.createAndJoin();
        actualUserNameText = videoConferencePage.getUserName();
        actualConferenceNameText = videoConferencePage.getConferenceName();
        customAssertions.assertElementContainText(expectedUserName, actualUserNameText);
        customAssertions.assertElementText(expectedConferenceName, actualConferenceNameText);

        isConferenceCreated = true;
    }


    @AfterEach
    void exitConference() {
        if (isConferenceCreated) {
            if (videoConferencePage != null) {
                videoConferencePage.endConference().confirmEndConference();
            }
            isConferenceCreated = false;
        }
        // Задержка после выполнения exitConference
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(saluteJazzMainPage.getVideoConferenceBtnLoc()));
    }
}
