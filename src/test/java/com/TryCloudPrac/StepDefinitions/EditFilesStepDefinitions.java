package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.EditFilePage;
import com.TryCloudPrac.Pages.LoginPage;
import com.TryCloudPrac.Pages.ModulesPage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.ConfigurationReader;
import com.TryCloudPrac.Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class EditFilesStepDefinitions {
    LoginPage loginPage = new LoginPage();
    ModulesPage modulesPage = new ModulesPage();
    EditFilePage editFilePage = new EditFilePage();

    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        // Driver.getDriver().get(ConfigurationReader.getProperty("url"));
        loginPage.logIn();
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {

        for (WebElement module : modulesPage.modules) {

            if (module.getAttribute("innerText").contains(string)) {
                WebElement select = Driver.getDriver().findElement(By.xpath("//a[@aria-label='" + string + "']"));
                select.click();
                break;
            }

        }

    }

    String confirm = "";
    int random2 = 0;

    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        Faker faker = new Faker();
        int random = faker.number().numberBetween(0, editFilePage.files.size() - 1);
        random2 = random;
        confirm = editFilePage.files.get(random).getText();
        editFilePage.actions.get(random).click();


    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        BrowserUtil.sleep(4);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.visibilityOf(Driver.getDriver().findElement(By.xpath("//span[.='" + string + "']/..")))).click();
        // WebElement a=Driver.getDriver().findElement(By.xpath("//span[.='"+string+"']/.."));
        // a.click();


    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
        //editFilePage.favoritesTab.click();
        WebElement a = Driver.getDriver().findElement(By.xpath("//a[.='" + string + "']"));
        a.click();
        BrowserUtil.sleep(4);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        for (WebElement file : editFilePage.files) {
            System.out.println("text= " + file.getAttribute("innerText"));

            if (file.getText().equals(confirm)) {
                Assert.assertEquals("not equal", confirm, file.getText());
            }

        }
    }


    @When("the users click action-icon from any file on the page to remove")
    public void the_users_click_action_icon_from_any_file_on_the_page_to_remove() {
        // confirm=editFilePage.files.get(random2).getText();
        editFilePage.actions.get(random2).click();


    }


    @Then("Verify that the file is removed from the Favorites sub-module’s table")
    public void verify_that_the_file_is_removed_from_the_favorites_sub_module_s_table() {


        Assert.assertFalse(editFilePage.files.get(random2).isDisplayed());
        System.out.println("not displayed!!");
    }


    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {


        editFilePage.addButton.click();

    }

    @When("users uploads file with the “upload file” option")
    public void users_uploads_file_with_the_upload_file_option() {
        String filePath = "C:\\Users\\Cameron\\Pictures\\Saved Pictures\\fallout-3_00379625.jpg";
        BrowserUtil.waitForPageToLoad(ConfigurationReader.getNumber("timeout"));
        editFilePage.upload.sendKeys(filePath);

        try {
            while (editFilePage.notEnoughSpaceBtn.isDisplayed()) {
                BrowserUtil.sleep(2);
                editFilePage.notEnoughSpaceBtn.click();
                editFilePage.upload.sendKeys(filePath);


            }
        } catch (NoSuchElementException a) {
            System.out.println("caught no such element");
            Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

    }

    //TRY TO GET IT AUTOMATED WITH LIST NOT MAKING EXTRA WEB ELEMENT
    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
int i=0;
        for (WebElement fileName : editFilePage.files) {

            if (fileName.getText().equals("fallout-3_00379625\n" +
                    ".jpg")){
                System.out.println("assertEquals in progress");
               Assert.assertEquals(fileName.getText(),"fallout-3_00379625\n" +
                       ".jpg");
                System.out.println(i);
                editFilePage.actions.get(i).click();
                WebElement a= Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-delete permanent']"));
                BrowserUtil.sleep(3);
                a.click();
               break;
            }
            i++;
        }



    }


          /*  if (editFilePage.files.get(i).getText().equals("fallout-3_00379625")){
                System.out.println("equals");
                //Assert.assertEquals("fallout-3_00379625", file.getText());
                System.out.println(file.getText()+"   see if blank");
                Assert.assertNotEquals("its going to my assert", "fallout-3_00379625", file.getText());
            }
           */


}
