package net.meetsky.pages;

import net.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

   @FindBy(id="expand")  // (xpath = "//div[@id='expand']")
    public WebElement avatarButton;

    @FindBy (xpath = "//ul/li[@data-id='logout']")
    public WebElement logOutButton;

}
