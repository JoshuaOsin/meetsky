package net.meetsky.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.meetsky.pages.LoginPage;
import net.meetsky.pages.MainPage;
import net.meetsky.utilities.BrowserUtils;
import net.meetsky.utilities.ConfigurationReader;
import net.meetsky.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.Alert;

public class Login_StepDefinitions {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    @Given("user goes to login page")
    public void user_goes_to_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("web.url"));
    }
    @When("user enters valid {string} to the username box")
    public void user_enters_valid_to_the_username_box(String string) {
        string = ConfigurationReader.getProperty("username");
        loginPage.usernameBox.sendKeys(string);
    }
    @When("user enters valid {string} to the password box")
    public void user_enters_valid_to_the_password_box(String string) {
        string = ConfigurationReader.getProperty("password");
        loginPage.passwordBox.sendKeys(string);
    }
    @When("user clicks the log in button")
    public void user_clicks_the_log_in_button() {
        BrowserUtils.clickWithJS(loginPage.logInButton);
        //loginPage.logInButton.click();
    }
    @Then("user should be navigate to main page")
    public void user_should_be_navigate_to_main_page() {
        BrowserUtils.waitForVisibility(mainPage.mainHeader,10);
        Assert.assertTrue(mainPage.mainHeader.isDisplayed());
    }

    @When("user enters invalid username to username box")
    public void user_enters_invalid_username_to_username_box() {
        loginPage.usernameBox.sendKeys("invalid.username");
    }

    @Then("user should not be able navigate to main page")
    public void user_should_not_be_able_navigate_to_main_page() {
        Assert.assertTrue(loginPage.usernameBox.isDisplayed());
    }
    @Then("user should see please fill out this filed message in password box")
    public void user_should_see_please_fill_out_this_filed_message_in_password_box() {
        String message= loginPage.passwordBox.getAttribute("validationMessage");
        Assert.assertEquals("Lütfen bu alanı doldurun.",message);
    }

    @When("user enters invalid password to password box")
    public void user_enters_invalid_password_to_password_box() {
        loginPage.passwordBox.sendKeys("invalid.password");
    }

    @Then("user should see please fill out this filed message in the username box")
    public void user_should_see_please_fill_out_this_filed_message_in_the_username_box() {
        String message= loginPage.usernameBox.getAttribute("validationMessage");
        Assert.assertEquals("Lütfen bu alanı doldurun.",message);
    }

}
