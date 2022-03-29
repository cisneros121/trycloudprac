package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.LoginPage;
import com.TryCloudPrac.Pages.ModulesPage;
import com.TryCloudPrac.Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.math.raw.Mod;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModulesStepDefinition {

    LoginPage loginPage= new LoginPage();
    ModulesPage modulesPage=new ModulesPage();
    @When("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
        loginPage.user.sendKeys("user7");
        loginPage.password.sendKeys("Userpass123");
        loginPage.loginButton.click();
    }
    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> dataTable) {
List<WebElement> span= Driver.getDriver().findElements(By.xpath("//span"));
        System.out.println(Driver.getDriver().findElement(By.xpath("//span")).getText());
int count=0;
//,Driver.getDriver().findElement(By.xpath("//a[@href='/index.php/apps/"+lower+"/']/span")).getText()
        System.out.println(span.get(0));
        for (String each : dataTable) {
            String lower = each.toLowerCase();
Assert.assertEquals(each+" is not equal to module",each,span.get(count).getAttribute("innerText"));
            count++;

        }


    }


}
