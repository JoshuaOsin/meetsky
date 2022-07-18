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
        Assert.assertTrue(mainPage.avatarButton.isDisplayed());
        //Assert.assertFalse(loginPage.usernameBox.isDisplayed());
    }

    @When("user enters invalid username to username box")
    public void user_enters_invalid_username_to_username_box() {
        loginPage.usernameBox.sendKeys("invalid.username");
    }

    @Then("user should not be able navigate to main page")
    public void user_should_not_be_able_navigate_to_main_page() {
        Assert.assertTrue(loginPage.usernameBox.isDisplayed());
        //Assert.assertFalse(mainPage.mainHeader.isDisplayed());
    }

    @Then("user should see Wrong username or password")
    public void user_should_see_wrong_username_or_password() {
        String message =loginPage.wrongUsernamePasswordMessage.getText();
        Assert.assertEquals( "Kullanıcı adı ya da parola hatalı.", message);
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

    @Then("user can see the password in a form of dots by default")
    public void user_can_see_the_password_in_a_form_of_dots_by_default() {
        Assert.assertEquals(loginPage.passwordBox.getAttribute("type"), "password");
    }

    @When("user click eye icon next to password")
    public void user_click_eye_icon_next_to_password() {
        loginPage.showPasswordExplicitlyIcon.click();
    }
    @Then("user can see the password explicitly if needed")
    public void user_can_see_the_password_explicitly_if_needed() {
        Assert.assertEquals(loginPage.passwordBox.getAttribute("type"), "text");
    }

    @When("user clicks Forgot password link on the login page")
    public void user_clicks_forgot_password_link_on_the_login_page() {
        loginPage.forgotPasswordLink.click();
    }
    @Then("user can see Reset Password button on the next page")
    public void user_can_see_reset_password_button_on_the_next_page() {
        BrowserUtils.waitForVisibility(loginPage.resetPasswordButton,5);
        Assert.assertTrue(loginPage.resetPasswordButton.isDisplayed());
    }

    @Then("user can see valid placeholders on username")
    public void user_can_see_valid_placeholders_on_username() {
        String placeholder = loginPage.usernameBox.getAttribute("placeholder");
        Assert.assertEquals("Kullanıcı adı ya da e-posta", placeholder);
    }

    @Then("user can see valid placeholders on password")
    public void user_can_see_valid_placeholders_on_password() {
        String placeholder = loginPage.passwordBox.getAttribute("placeholder");
        Assert.assertEquals("Parola", placeholder);
    }
}
