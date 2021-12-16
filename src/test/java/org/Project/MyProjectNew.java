package org.Project;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyProjectNew {
    static WebDriver driver;


    @BeforeEach
    void setDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");
        options.setPageLoadTimeout(Duration.ofSeconds(30));

        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Assertions.assertDoesNotThrow(() -> driver.navigate().to("https://www.livejournal.com/"), "Страница не доступна");
    }
    @DisplayName("Авторизация")
    @Test
    void testAuthorization(){

        WebElement enter1= driver.findElement(By.cssSelector(".s-header-item__link--login"));
        WebElement name =driver.findElement(By.id("user"));
        WebElement password =driver.findElement(By.id("lj_loginwidget_password"));
        WebElement enter2 =driver.findElement(By.name("action:login"));

        enter1.click();
        name.sendKeys("utka2021");
        password.click();
        password.sendKeys("Ghbvjxrf2021");
        enter2.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".s-header-item--user")))
                .build().perform();

        WebElement exit =driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        exit.click();

        assertEquals(driver.getCurrentUrl(),"https://www.livejournal.com/");

        driver.manage().deleteAllCookies();
    }
    @DisplayName("Новая запись")
    @Test
    void testCreateRecord(){

        WebElement enter1= driver.findElement(By.cssSelector(".s-header-item__link--login"));
        WebElement name =driver.findElement(By.id("user"));
        WebElement password =driver.findElement(By.id("lj_loginwidget_password"));
        WebElement enter2 =driver.findElement(By.name("action:login"));


        enter1.click();
        name.sendKeys("utka2021");
        password.click();
        password.sendKeys("Ghbvjxrf2021");
        enter2.click();

        WebElement writBloc =driver.findElement(By.cssSelector(".s-header-item__link--post"));
        writBloc.click();

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//span[contains(.,'utka2021')]"))).build().perform();


        WebElement newPost =driver.findElement(By.xpath("//a[contains(.,'Новый пост')]"));
        newPost.click();

        WebElement heading =driver.findElement(By.xpath("//textarea[@placeholder='Заголовок']"));
        heading.click();
        heading.sendKeys("Прогноз погоды");

        WebElement text =driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        text.click();
        text.sendKeys("Снег и гололёд");

        WebElement visibleToAll =driver.findElement(By.xpath("//span[contains(.,'Виден всем')]"));
        visibleToAll.click();

        WebElement onlyMy = driver.findElement(By.xpath("//label[contains(.,'Только я')]"));
        onlyMy.click();

        WebElement tune = driver.findElement(By.xpath("//button[contains(.,'Настроить и опубликовать')]"));
        tune.click();

        WebElement publish = driver.findElement(By.xpath("//span[contains(.,'Опубликовать')]"));
        publish.click();


        assertEquals(text.getText(),"Снег и гололёд");

        driver.manage().deleteAllCookies();

    }
    @DisplayName("Выбор языка")
    @Test
    void  testLanguageSelection(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.cssSelector(".s-header-item__link--lang"))).build().perform();

        WebElement lang =driver.findElement(By.xpath("//a[text()='English (en)']"));
        lang.click();

        assertEquals(driver.getCurrentUrl(),"https://www.livejournal.com/");
    }
    @DisplayName("Поиск контента")
    @Test
    void testContentSearch(){
        WebElement search =driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon"));
        search.click();


        WebElement inputText =driver.findElement(By.cssSelector(".s-header-search__input-wrapper > #SearchText"));
        inputText.click();
        inputText.sendKeys("животные");


        Set<String> oldWindowsSet = driver.getWindowHandles();
        driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon")).click();


        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();

        driver.switchTo().window(newWindowHandle);

        WebElement byTime =driver.findElement(By.xpath("//span[@data-content='По времени']"));
        byTime.click();

        assertEquals(driver.getCurrentUrl(),
                "https://www.livejournal.com/rsearch?q=%D0%B6%D0%B8%D0%B2%D0%BE%D1%82%D0%BD%D1%8B%D0%B5&searchArea=post");
    }


    @AfterEach
    void exit2(){
        driver.close();
    }

  @AfterAll
    static void exit() {
      driver.quit();
  }
}


