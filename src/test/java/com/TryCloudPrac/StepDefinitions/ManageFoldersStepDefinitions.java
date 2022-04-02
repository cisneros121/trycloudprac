package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.EditFilePage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.ConfigurationReader;
import com.TryCloudPrac.Utilities.Driver;
import com.github.javafaker.Faker;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;

public class ManageFoldersStepDefinitions {
    EditFilePage editFilePage= new EditFilePage();
    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        editFilePage.addButton.click();
    }
    @When("user click \"new folder”")
    public void user_click_new_folder() {
        editFilePage.newFolder.click();

    }
    @When("user write a folder name")
    public void user_write_a_folder_name() {
        editFilePage.newFolderTextBox.sendKeys("cameron");
    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
            editFilePage.submitBtn.click();

    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        BrowserUtil.sleep(3);
        BrowserUtil.confirmFileInList("cameron",editFilePage.files);

    }
int random=0;
    @And("user choose a folder from the page")
    public void userChooseAFolderFromThePage() {
        Faker faker= new Faker();
        random= faker.random().nextInt(0,editFilePage.files.size()-1);
        while (editFilePage.files.get(random).getText().contains("jpg")){
            System.out.println("random = " + random);
            random=faker.random().nextInt(0,editFilePage.files.size()-1);
        }
        editFilePage.files.get(random).click();

    }

    @When("the user uploads a file with the upload file option")
    public void theUserUploadsAFileWithTheUploadFileOption() {
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

    @Then("Verify the file is displayed on the page")
    public void verifyTheFileIsDisplayedOnThePage() {
        BrowserUtil.sleep(5);
        BrowserUtil.deleteFileInList("fallout-3_00379625\n" +
                ".jpg",editFilePage.files);

    }
}
