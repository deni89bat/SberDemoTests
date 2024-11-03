package sberJazz.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

public class CustomAssertions {
    @Step("Проверка, что заголовок страницы: {expectedTitle}")
    protected void assertPageTitle(String expectedTitle, String actualTitle) {
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок страницы не совпадает");
    }

    @Step("Проверка, что элемент с текстом '{expectedText}' присутствует на странице")
    protected void assertElementText(String expectedText, String actualText) {
        Assertions.assertEquals(expectedText, actualText, "Текст элемента не совпадает");
    }

    @Step("Проверка, что значение поля '{fieldName}' равно '{expectedValue}'")
    protected void assertFieldValue(String fieldName, String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue, "Значение поля " + fieldName + " не совпадает");
    }

    @Step("Проверка, что элемент {elementName} отображается на странице")
    protected void assertElementIsDisplayed(String elementName, boolean isDisplayed) {
        Assertions.assertTrue(isDisplayed, "Элемент " + elementName + " не отображается на странице");
    }

    @Step("Проверка, что список содержит {expectedCount} элементов")
    protected void assertListSize(int expectedCount, int actualCount) {
        Assertions.assertEquals(expectedCount, actualCount, "Количество элементов в списке не совпадает");
    }

    @Step("Проверка, что значение {actualValue} не равно {unexpectedValue}")
    protected void assertValueIsNotEqual(String actualValue, String unexpectedValue) {
        Assertions.assertNotEquals(unexpectedValue, actualValue, "Значение не должно совпадать с " + unexpectedValue);
    }

    @Step("Проверка, что значение в поле 'Ваше имя' равно '{expectedName}'")
    protected void assertUserName(String expectedName, String actualName) {
        Assertions.assertEquals(expectedName, actualName,
                "В поле 'Ваше имя' отображается неверное значение: " + actualName);
    }

    @Step("Проверка, что значение в поле 'Название встречи' равно '{expectedConferenceName}'")
    protected void assertConferenceName(String expectedConferenceName, String actualConferenceName) {
        Assertions.assertEquals(expectedConferenceName, actualConferenceName,
                "В поле 'Название встречи' отображается неверное значение: " + actualConferenceName);
    }

    @Step("Проверка, что заголовок формы равен '{expectedFormTitle}'")
    protected void assertFormTitle(String expectedFormTitle, String actualFormTitle) {
        Assertions.assertEquals(expectedFormTitle, actualFormTitle,
                "Пользователь видит неверный заголовок формы: " + actualFormTitle);
    }

    @Step("Проверка, что кнопка '{buttonName}' доступна")
    protected void assertButtonIsEnabled(WebElement button, String buttonName) {
        Assertions.assertFalse(button.getAttribute("disabled") != null,
                "Кнопка '" + buttonName + "' должна быть доступна для нажатия");
    }

    @Step("Проверка, что кнопка '{buttonName}' недоступна")
    protected void assertButtonIsDisabled(WebElement button, String buttonName) {
        Assertions.assertTrue(button.getAttribute("disabled") != null,
                "Кнопка '" + buttonName + "' должна быть недоступна для нажатия");
    }
}
