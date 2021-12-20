package Lesson6;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest extends AbstractTest {

    @DisplayName("Авторизация")
    @Test
    void testAuthorization() {
        homePageNoLogin.goToLoginPage();
        Assertions.assertEquals(driver.getCurrentUrl(), "https://www.livejournal.com/media/");
        loginPage.inputLogin("utka2021").inputPassword("Ghbvjxrf2021").clickSubmit();
        Assertions.assertEquals(homePageLogin.getUserName(), "UTKA2021");
        homePageLogin.entryMenu();
        Assertions.assertEquals(driver.getTitle(),"Главное — ЖЖ");
        driver.manage().deleteAllCookies();
    }


       @DisplayName("Новая запись")
        @Test
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

    @DisplayName("Выбор языка")
    @Test
    void  testLanguageSelection(){
        homePageNoLogin.langToMenu().langToLang();
      Assertions.assertEquals(homePageNoLogin.getLang(),"ENGLISH (EN)");

    }
    @DisplayName("Поиск контента")
    @Test
    void testContentSearch(){
        homePageNoLogin.sendContent().transitionToNewWindow();
        contentPage.sortContent();
        Assertions.assertEquals(driver.getTitle(),"Поиск по ЖЖ");
    }
}





