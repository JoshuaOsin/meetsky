package net.meetsky.pages;

import net.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends MainPage{
    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id ="user")
    public WebElement usernameBox;

    @FindBy (xpath = "//input[@id='password']")
    public WebElement passwordBox;

    @FindBy (id ="submit-form")
    public WebElement logInButton;

}
