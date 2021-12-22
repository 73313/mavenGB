package Lesson7;

import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import io.qameta.allure.TmsLink;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

import java.util.List;


public class LoginTest extends AbstractTest {
    @Test
    @Epic("Механизм авторизации")
    @DisplayName("Авторизация")

    void testAuthorization() {
        homePageNoLogin.goToLoginPage();
        Assertions.assertEquals(AbstractTest.driver.getCurrentUrl(), "https://www.livejournal.com/media/");
        loginPage.inputLogin("utka2021").inputPassword("Ghbvjxrf2021").clickSubmit();
        Assertions.assertEquals(homePageLogin.getUserName(), "UTKA2021");
        homePageLogin.entryMenu();
        Assertions.assertEquals(AbstractTest.driver.getTitle(),"Главное — ЖЖ");
        AbstractTest.driver.manage().deleteAllCookies();
    }

       @Test
       @Epic("Механизм записи нового поста")
       @DisplayName("Новая запись")

       void testCreateRecord(){

            homePageNoLogin.goToLoginPage();
            Assertions.assertEquals(driver.getCurrentUrl(), "https://www.livejournal.com/media/");
            loginPage.inputLogin("utka2021").inputPassword("Ghbvjxrf2021").clickSubmit();
            Assertions.assertEquals(homePageLogin.getUserName(), "UTKA2021");

            homePageLogin.writBloc();
            Assertions.assertEquals(driver.getCurrentUrl(),"https://www.livejournal.com/post");
            newPostPage.postMenu().writeNewPost().publishPost();

            Assertions.assertEquals(newPostPage.getPostText(),"Снег и гололёд");
           driver.manage().deleteAllCookies();
        }
    @Test
     @Epic("Механизм смены языка")
    @DisplayName("Выбор языка")
    @TmsLink("src/test/resources/Тест-кейсы дз6.doc")

    void  testLanguageSelection(){
        homePageNoLogin.langToMenu().langToLang();
      Assertions.assertEquals(homePageNoLogin.getLang(),"ENGLISH (EN)");

    }
    @Test
    @Epic("Механизм поиска контента")
    @DisplayName("Поиск контента")

    void testContentSearch(){
        homePageNoLogin.sendContent().transitionToNewWindow();
        contentPage.sortContent();
        Assertions.assertEquals(driver.getTitle(),"Поиск по ЖЖ");
    }
    /*@Test
    @DisplayName("logs")
    void testLogs(){
        LogEntries browserLogs = getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        //Assertions.assertTrue(allLogRows.isEmpty());
        if (allLogRows.size()>0){
            allLogRows.forEach(logEntry -> {
                System.out.println(logEntry.getMessage());
            });
        }Assertions.assertTrue(true);
    }*/
}





