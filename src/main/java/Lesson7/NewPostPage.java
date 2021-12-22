package Lesson7;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class NewPostPage extends AbstractPage{
    Actions actions = new Actions(getDriver());

    @FindBy(xpath = "//span[contains(.,'utka2021')]")
    private WebElement postMenu;

    @FindBy(xpath = "//a[contains(.,'Новый пост')]")
    private WebElement newPost;

    @FindBy(xpath = "//textarea[@placeholder='Заголовок']")
    private WebElement heading;

    @FindBy(css = ".public-DraftStyleDefault-block")
    private WebElement  text;

    @FindBy(xpath = "//span[contains(.,'Виден всем')]")
    private WebElement  visibleToAll;

    @FindBy(xpath = "//label[contains(.,'Только я')]")
    private WebElement  onlyMy;

    @FindBy(xpath ="//button[contains(.,'Настроить и опубликовать')]" )
    private WebElement  tune;

    @FindBy(xpath ="//span[contains(.,'Опубликовать')]")
    private WebElement publish ;

    public NewPostPage(WebDriver driver) {
        super(driver);
    }

    public NewPostPage postMenu(){
        actions.moveToElement(postMenu).click(getDriver().findElement(By.xpath("//a[contains(.,'Новый пост')]")))
                    .build().perform();
        return this;
    }
    public NewPostPage writeNewPost(){
        actions.click(heading).sendKeys("Прогноз погоды").click(text).sendKeys("Снег и гололёд").build().perform();
        return this;

    }
    public NewPostPage publishPost(){
        visibleToAll.click();
        onlyMy.click();
        tune.click();
        publish.click();
        return this;

    }
    public String getPostText() {
        String tx= text.getText();
        return tx;
    }
}
