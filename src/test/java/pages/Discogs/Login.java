package pages.Discogs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.BasePage;

public class Login extends BasePage {

    private By userNameTextBox = By.id("username");
    private By passwordTextBox = By.id("password");
    private By loginButton = By.name("login_button");

    public Login(WebDriver driver) {
        super(driver);
    }


    public Login waitForUserName(){
        wait.until(ExpectedConditions.presenceOfElementLocated(userNameTextBox));
        return this;
    }

    public Login sendKeysToUserName(String userName){
        driver.findElement(userNameTextBox).sendKeys(userName);
        return this;
    }
    public Login sendKeysToPassword(String password){
        driver.findElement(passwordTextBox).sendKeys(password);
        return this;
    }

    public Collection clickLoginButton(){
        driver.findElement(loginButton).click();
        Collection collection = new Collection(driver);
        waitForPageToLoad(10);
        return collection;
    }
}
