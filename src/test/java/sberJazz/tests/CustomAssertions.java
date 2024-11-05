package sberJazz.tests;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;

// когда будет много тестов, то планирую разбивать на подклассы buttons, fields и т.п. чтобы избежать антипаттерна God object (очень большой класс)
public class CustomAssertions {
    @Step("Проверка, что заголовок страницы: {expectedTitle}")
    public void assertPageTitle(String expectedTitle, String actualTitle) {
        Assertions.assertEquals(expectedTitle, actualTitle, "Заголовок страницы не совпадает");
    }

    @Step("Проверка, что элемент с текстом '{expectedText}' присутствует на странице")
    public void assertElementText(String expectedText, String actualText) {
        Assertions.assertEquals(expectedText, actualText, "Текст элемента не совпадает");
    }

    @Step("Проверка, что элемент содержит текст '{expectedText}'")
    public void assertElementContainText(String expectedText, String actualText) {
        Assertions.assertTrue(actualText.contains(expectedText), "Элемент должен содержать текст: '" + expectedText + "', но фактический текст: '" + actualText + "'");
    }

    @Step("Проверка, что значение поля '{fieldName}' равно '{expectedValue}'")
    public void assertFieldValue(String fieldName, String expectedValue, String actualValue) {
        Assertions.assertEquals(expectedValue, actualValue, "Значение поля " + fieldName + " не совпадает");
    }

    @Step("Проверка, что элемент {element} отображается на странице {pageName}")
    public void assertElementIsDisplayed(WebElement element, String pageName) {
        Assertions.assertTrue(element.isDisplayed(), "Элемент " + element.getText() + " не отображается на странице");
    }

    @Step("Проверка, что список содержит {expectedCount} элементов")
    public void assertListSize(int expectedCount, int actualCount) {
        Assertions.assertEquals(expectedCount, actualCount, "Количество элементов в списке не совпадает");
    }

    @Step("Проверка, что значение {actualValue} не равно {unexpectedValue}")
    public void assertValueIsNotEqual(String actualValue, String unexpectedValue) {
        Assertions.assertNotEquals(unexpectedValue, actualValue, "Значение не должно совпадать с " + unexpectedValue);
    }

    @Step("Проверка, что значение в поле 'Ваше имя' равно '{expectedName}'")
    public void assertUserName(String expectedName, String actualName) {
        Assertions.assertEquals(expectedName, actualName, "В поле 'Ваше имя' отображается неверное значение: " + actualName);
    }

    @Step("Проверка, что значение в поле 'Название встречи' равно '{expectedConferenceName}'")
    public void assertConferenceName(String expectedConferenceName, String actualConferenceName) {
        Assertions.assertEquals(expectedConferenceName, actualConferenceName, "В поле 'Название встречи' отображается неверное значение: " + actualConferenceName);
    }

    @Step("Проверка, что заголовок формы: '{expectedFormTitle}'")
    public void assertFormTitle(String expectedFormTitle, String actualFormTitle) {
        Assertions.assertEquals(expectedFormTitle, actualFormTitle, "Пользователь видит неверный заголовок формы: " + actualFormTitle);
    }

    @Step("Проверка, что кнопка '{buttonName}' доступна")
    public void assertButtonIsEnabled(WebElement button, String buttonName) {
        Assertions.assertFalse(button.getAttribute("disabled") != null, "Кнопка '" + buttonName + "' должна быть доступна для нажатия");
    }

    @Step("Проверка, что кнопка '{buttonName}' недоступна")
    public void assertButtonIsDisabled(WebElement button, String buttonName) {
        Assertions.assertTrue(button.getAttribute("disabled") != null, "Кнопка '" + buttonName + "' должна быть недоступна для нажатия");
    }
}
