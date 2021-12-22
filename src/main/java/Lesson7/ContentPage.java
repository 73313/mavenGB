package Lesson7;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentPage extends AbstractPage{

    @FindBy(xpath = "//span[@data-content='По времени']")
    private WebElement byTime;

    public ContentPage(WebDriver driver) {
        super(driver);
    }

    public ContentPage sortContent(){
        byTime.click();
        return this;
    }
}


