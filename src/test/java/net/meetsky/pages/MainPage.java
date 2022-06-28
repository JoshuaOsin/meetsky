package net.meetsky.pages;

import net.meetsky.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class MainPage {
    public MainPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy (id = "header")
    public WebElement mainHeader;

}
