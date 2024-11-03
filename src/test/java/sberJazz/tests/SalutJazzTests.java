package sberJazz.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sberJazz.pages.NewVideoConferenceFormPage;

public class SalutJazzTests extends BaseTest {
    CustomAssertions customAssertions = new CustomAssertions();

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

        videoConferenceFormPage.createAndJoin();



    }
}
