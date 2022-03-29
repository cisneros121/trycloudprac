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
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class EditFilesStepDefinitions {
    LoginPage loginPage= new LoginPage();
    ModulesPage modulesPage= new ModulesPage();
    EditFilePage editFilePage= new EditFilePage();
    @Given("user on the dashboard page")
    public void user_on_the_dashboard_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
       loginPage.logIn();
    }
    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String string) {
        int count=0;
        String result=string.toLowerCase();
        for (WebElement module : modulesPage.modules) {

            if (module.getAttribute("innerText").contains(string)){
                WebElement select=Driver.getDriver().findElement(By.xpath("//a[@aria-label='"+string+"']"));
                select.click();
                break;
            }

        }

    }
    String confirm="";
    int random2=0;
    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        Faker faker= new Faker();
        int random=faker.number().numberBetween(0,6);
        random2=random;
        confirm=editFilePage.files.get(random).getText();
       editFilePage.actions.get(random).click();




    }
    @When("user choose the {string} option")
    public void user_choose_the_option(String string) {
        BrowserUtil.sleep(4);
        //editFilePage.addFavoriteButton.click();
        WebElement a=Driver.getDriver().findElement(By.xpath("//span[.='"+string+"']/.."));
        a.click();


    }
    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String string) {
            //editFilePage.favoritesTab.click();

               WebElement a= Driver.getDriver().findElement(By.xpath("//a[.='"+string+"']"));
                a.click();
                BrowserUtil.sleep(4);
    }
    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        int count=1;
        for (WebElement file : editFilePage.files) {

            if (file.getText().equals(confirm)){
                Assert.assertEquals("not equal",confirm,file.getText());
            }else if (count==editFilePage.files.size()){
                Assert.assertTrue(false);
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
editFilePage.uploadButton.sendKeys("C:\\Users\\Cameron\\Pictures\\Saved Pictures\\fallout-3_00379625.jpg");
    }
    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

        System.out.println("editFilePage.files.size() = " + editFilePage.files.size());
      //  Assert.assertTrue();
    }
}
