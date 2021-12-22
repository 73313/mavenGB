package Lesson7;

import io.qameta.allure.Severity;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.Set;

public class HomePageNoLogin extends AbstractPage {
    //определение локатора кнопки входа для начала авторизации
    @FindBy(css = ".s-header-item__link--login")
    private WebElement enter1;

    @FindBy(css = ".s-header-item__link--lang")
    private WebElement langMenu;

    @FindBy(xpath = "//a[text()='English (en)']")
    private WebElement lang;

    @FindBy(css = ".s-do-item-search-btn .svgicon")
    private WebElement search;

    @FindBy(css = ".s-header-search__input-wrapper > #SearchText")
    private WebElement inputContent;



    public HomePageNoLogin(WebDriver driver) {
        super(driver);
    }
  // @Step("метод для входа на форму авторизации")
    public HomePageNoLogin goToLoginPage() {
        enter1.click();
        return this;
    }

    public HomePageNoLogin langToMenu() {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(langMenu).build().perform();
        return this;
    }

    public HomePageNoLogin langToLang() {
        lang.click();
        return this;
    }

    public String getLang() {
       String ln = driver.findElement(By.xpath("//a[text()='English (en)']")).getText();
     //   String ln = driver.findElement(By.cssSelector(".s-header-item__link--lang")).getText();

        return ln;
    }

    public HomePageNoLogin sendContent() {
        search.click();
        inputContent.sendKeys("животные");
        return this;
    }

    public HomePageNoLogin transitionToNewWindow() {
        Set<String> oldWindowsSet = driver.getWindowHandles();
        driver.findElement(By.cssSelector(".s-do-item-search-btn .svgicon")).click();
        Set<String> newWindowsSet = driver.getWindowHandles();
        newWindowsSet.removeAll(oldWindowsSet);
        String newWindowHandle = newWindowsSet.iterator().next();
        driver.switchTo().window(newWindowHandle);
        return this;
    }
}
