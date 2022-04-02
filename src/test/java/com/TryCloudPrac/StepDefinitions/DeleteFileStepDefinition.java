package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.EditFilePage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DeleteFileStepDefinition {
    EditFilePage editFilePage= new EditFilePage();
    int random=0;
    String file="";
    String confirm="";
    @When("user click action-icon  from any file on the page")
    public void user_click_action_icon_from_any_file_on_the_page() {
        Faker faker= new Faker();
        random=faker.random().nextInt(0,6);
        file=editFilePage.actions.get(random).getAttribute("innerText");
        confirm=editFilePage.files.get(random).getText();
        editFilePage.actions.get(random).click();
    }
    @When("the user clicks the {string} sub-module on the left side")
    public void the_user_clicks_the_sub_module_on_the_left_side(String string) {
        BrowserUtil.sleep(3);
        WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
wait.until(ExpectedConditions.visibilityOf(editFilePage.deletedFile)).click();
        editFilePage.deletedFile.click();
    }
    @Then("Verify the deleted file is displayed on the page.")
    public void verify_the_deleted_file_is_displayed_on_the_page() {
BrowserUtil.sleep(5);
        Actions actions= new Actions(Driver.getDriver());
        actions.moveToElement(editFilePage.deleteSort).doubleClick().perform();

        for (WebElement deletedFile : editFilePage.deletedFiles) {
            if (deletedFile.getText().equals(confirm)){
                Assert.assertTrue(deletedFile.getText().equals(confirm));
                System.out.println("file found in deleted");
            }
        }


    }

}
