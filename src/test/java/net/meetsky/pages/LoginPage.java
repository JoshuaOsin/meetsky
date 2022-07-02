package net.meetsky.pages;

import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id ="user")
    public WebElement usernameBox;

    @FindBy(id ="password")
    public WebElement passwordBox;

    @FindBy(id ="submit-form")
    public WebElement logInButton;

    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
        usernameBox.sendKeys(ConfigurationReader.getProperty("username"));
        passwordBox.sendKeys(ConfigurationReader.getProperty("password"));
        //loginPage.logInButton.click();
        BrowserUtils.clickWithJS(logInButton);
        BrowserUtils.waitFor(5);
    }

}
