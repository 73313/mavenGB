package Lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.time.Duration;
import java.util.List;

public class AbstractTest {
    static WebDriver driver;
    public static HomePageLogin homePageLogin;
    public static HomePageNoLogin homePageNoLogin;
    public static LoginPage loginPage;
    public static NewPostPage newPostPage;
    public static ContentPage contentPage;

    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(40));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));


        homePageLogin=new HomePageLogin(getDriver());
        homePageNoLogin=new HomePageNoLogin(getDriver());
        loginPage=new LoginPage(getDriver());
        newPostPage=new NewPostPage(getDriver());
        contentPage=new ContentPage(getDriver());

        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.livejournal.com/media/"), "Страница не доступна");
    }

    @AfterEach
    void exit2(){
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size()>0){
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }Assertions.assertTrue(true);
        driver.quit();
    }

    @AfterAll
    static void exit() {
        driver.quit();
    }
    public WebDriver getDriver(){
        return this.driver;
    }
}
