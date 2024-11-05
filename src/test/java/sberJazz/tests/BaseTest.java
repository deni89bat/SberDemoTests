package sberJazz.tests;

import com.codeborne.selenide.Screenshots;
import lombok.SneakyThrows;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import sberJazz.pages.SaluteJazzMainPage;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import sberJazz.utils.UIProps;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


public class BaseTest {
    protected WebDriver driver;
    protected SaluteJazzMainPage saluteJazzMainPage;
    UIProps props = ConfigFactory.create(UIProps.class);
    final String downloadFolder = System.getProperty("user.dir") + File.separator + "build" + File.separator + "downloadFiles";

    @SneakyThrows
    @BeforeEach
    void setUp() {
        ChromeOptions options = createChromeOptions();
        URL url = new URL(props.selenoidUrl());
        driver = new RemoteWebDriver(url, options);
        //driver = new ChromeDriver(options);      //Локальный запуск
        driver.manage().window().setSize(new Dimension(1920, 1080));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(props.pageLoadTimeout()));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(props.implicitWait()));
        driver.get(props.baseURL());

        saluteJazzMainPage = new SaluteJazzMainPage(driver);
    }

    private ChromeOptions createChromeOptions() {
        ChromeOptions options = new ChromeOptions();
        // Настройка папки загрузок
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("download.default_directory", downloadFolder);
        options.setExperimentalOption("prefs", prefs);
        options.addArguments("--accept-lang=ru");  // Язык для загружаемых страниц

        return options;
    }

    @AfterEach
    @Step("Сделать скриншот и закрыть драйвер")
    void tearDown() throws IOException {
        takeScreenshot(driver); // на большом кол-ве тестов убрать, чтобы не забивать память. А тут для демонстрации в отчёте
        driver.quit();
    }


    @Step("Сделать скриншот")
    @Attachment(value = "Скриншот", type = "image/png")
    public static byte[] takeScreenshot(WebDriver driver) {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }
}

