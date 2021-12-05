import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AppMyProject1 {
    public static void main( String[] args )
    {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options= new ChromeOptions();

        options.addArguments("--incognito");
        options.addArguments("start-maximized");


        WebDriver driver= new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://www.livejournal.com/");

        //WebElement webElement= driver.findElement(By.xpath("//a[contains(text(),'Войти')]"));
        WebElement webElement= driver.findElement(By.cssSelector(".s-header-item__link--login"));
        webElement.click();

        WebElement webElementName =driver.findElement(By.id("user"));
        webElementName.click();
        webElementName.sendKeys("utka2021");

        WebElement webElementPassword =driver.findElement(By.id("lj_loginwidget_password"));
        webElementPassword.click();
        webElementPassword.sendKeys("Ghbvjxrf2021");

        WebElement webElementEnter =driver.findElement(By.name("action:login"));
        webElementEnter.click();


        Actions builder = new Actions(driver);
        WebElement webElementMenu =driver.findElement(By.cssSelector(".s-header-item--user"));
        builder.moveToElement(webElementMenu).perform();
        builder.click(webElementMenu);

        WebElement webElementExit =driver.findElement(By.cssSelector(".s-header-sub-list-item__link--logout"));
        webElementExit.click();
        driver.quit();


    }
}
