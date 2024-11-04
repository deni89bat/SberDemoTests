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

        customAssertions.assertPageTitle("SaluteJazz",
                saluteJazzMainPage.getTitle());

        videoConferenceFormPage = saluteJazzMainPage.startVideoConference();
        customAssertions.assertFormTitle("Новая видеовстреча",
                videoConferenceFormPage.getFormTitle());
        customAssertions.assertButtonIsDisabled(videoConferenceFormPage.getCreateConfBtnElem(),
                "Создать и присоединиться");

        videoConferenceFormPage.setUserName(expectedUserName)
                .setConferenceName(expectedConferenceName);
        customAssertions.assertUserName(expectedUserName,
                videoConferenceFormPage.getUserName());
        customAssertions.assertConferenceName(expectedConferenceName,
                videoConferenceFormPage.getConferenceName());
        customAssertions.assertButtonIsEnabled(videoConferenceFormPage.getCreateConfBtnElem(),
                "Создать и присоединиться");

        videoConferencePage = videoConferenceFormPage.createAndJoin();
        customAssertions.assertElementText(expectedConferenceName,
                videoConferencePage.getConferenceName());
        customAssertions.assertElementContainText(expectedUserName,
                videoConferencePage.getUserName());
        takeScreenshot(driver);

        isConferenceCreated = true;
    }


    @AfterEach
    void exitConference() {
        if (isConferenceCreated) {
            if (videoConferencePage != null) {
                videoConferencePage.endConference()
                        .confirmEndConference();
            }
            isConferenceCreated = false;
        }
        // Задержка после выполнения exitConference
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(saluteJazzMainPage.getVideoConferenceBtnLoc()));
    }
}
