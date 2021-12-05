import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppMyProject2 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.livejournal.com/");
        WebElement webElement= driver.findElement(By.cssSelector(".s-header-item__link--login"));
      //  WebElement webElement= driver.findElement(By.xpath("//a[contains(text(),'Войти')]"));
        webElement.click();

        WebElement webElementName =driver.findElement(By.id("user"));
        webElementName.click();
        webElementName.sendKeys("utka2021");

        WebElement webElementPassword =driver.findElement(By.id("lj_loginwidget_password"));
        webElementPassword.click();
        webElementPassword.sendKeys("Ghbvjxrf2021");

        WebElement webElementEnter =driver.findElement(By.name("action:login"));
        webElementEnter.click();


        WebElement webElementWritBloc =driver.findElement(By.cssSelector(".s-header-item__link--post"));
        webElementWritBloc.click();


        Actions builder = new Actions(driver);
        WebElement webElementMenu =driver.findElement(By.xpath("//span[contains(.,'utka2021')]"));
        builder.moveToElement(webElementMenu).perform();
        builder.click(webElementMenu);


        WebElement webElementNewPost =driver.findElement(By.xpath("//a[contains(.,'Новый пост')]"));
        webElementNewPost.click();

        WebElement webElementHeading =driver.findElement(By.xpath("//textarea[@class='_xt']"));
        webElementHeading.click();
        webElementHeading.sendKeys("Прогноз погоды");

        WebElement webElementText =driver.findElement(By.cssSelector(".public-DraftStyleDefault-block"));
        webElementText.click();
        webElementText.sendKeys("Снег и гололёд");


        WebElement webElement1 =driver.findElement(By.xpath("//span[contains(.,'Виден всем')]"));
        webElement1.click();
        new WebDriverWait(driver, 5)
        .until(ExpectedConditions.visibilityOf(webElement1));

        WebElement webElement2 = driver.findElement(By.xpath("//label[contains(.,'Только я')]"));
        webElement2.click();


        WebElement webElement3 = driver.findElement(By.xpath("//button[contains(.,'Настроить и опубликовать')]"));
        webElement3.click();


        WebElement webElement4 = driver.findElement(By.xpath("//span[contains(.,'Опубликовать')]"));
        webElement4.click();




        //driver.quit();




    }
}

