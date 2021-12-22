package Lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePageLogin extends AbstractPage{

   Actions actions = new Actions(getDriver());

   // определение локатора меню пользователя
    @FindBy(css = ".s-header-item--user")
    private static WebElement userMenu;

    //определение локатора кнопки выхода из аккаунта
    @FindBy(css = ".s-header-sub-list-item__link--logout")
    private WebElement logoutBtn;

    @FindBy(css = ".s-header-item__link--post")
    private WebElement writBloc ;

    public HomePageLogin(WebDriver driver) {
        super(driver);
    }

    //метод для вызова  меню пользователя и выхода из аккаунта
    public HomePageLogin entryMenu() {
        actions.moveToElement(userMenu).build().perform();
        logoutBtn.click();
        return this;
    }
    //метод для нажатия кнопки выхода из аккаунта
    public HomePageLogin userLogout() {
         logoutBtn.click();
         return this;
     }
     //  метод для получения имени пользователя из меню пользователя
     public String getUserName() {
        String userName = userMenu.findElement(By.cssSelector(".s-header-item .s-nav-item__name")).getText();
        return userName;
    }
    public HomePageLogin writBloc(){
        writBloc.click();
        return this;
    }
}





