package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.LoginPage;
import com.TryCloudPrac.Utilities.ConfigurationReader;
import com.TryCloudPrac.Utilities.Driver;
import com.TryCloudPrac.Utilities.ExplicitWaitMethod;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginStepDefinition {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void userOnTheLoginPage() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user use username {string} and password {string}")
    public void userUseUsernameAndPassword(String arg0, String arg1) {
        loginPage.user.sendKeys(arg0);
        loginPage.password.sendKeys(arg1);
    }

    @When("user click the login button")
    public void user_click_the_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Dashboard"));
    }


    @When("user enter invalid {string} and enters {string}")
    public void userEnterInvalidAndEnters(String arg0, String arg1) {
        loginPage.user.sendKeys(arg0);
        loginPage.password.sendKeys(arg1);
    }

    @Then("verify {string} message should be displayed")
    public void verifyMessageShouldBeDisplayed(String arg0) {
      //  ExplicitWaitMethod.explicitWait().until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),10);
wait.until(ExpectedConditions.visibilityOf(loginPage.errorMessage));
        Assert.assertEquals("not equal",arg0 ,loginPage.errorMessage.getText());

    }
}
