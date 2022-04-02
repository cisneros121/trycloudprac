package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.EditFilePage;
import com.TryCloudPrac.Pages.FilePage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.ConfigurationReader;
import com.TryCloudPrac.Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.util.concurrent.TimeUnit;

public class StorageStepDefinitions {
    int storage=0;
    FilePage filePage= new FilePage();
    EditFilePage editFilePage= new EditFilePage();
    @When("user checks the current storage usage")
    public void user_checks_the_current_storage_usage() {
                storage= BrowserUtil.stringToNumber(filePage.storage);

    }

    @And("users uploads file with the upload file option")
    public void usersUploadsFileWithTheUploadFileOption() {
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


    @When("user refresh the page")
    public void user_refresh_the_page() {
        Driver.getDriver().navigate().refresh();
    }
    @Then("the user should be able to see storage usage is increased")
    public void the_user_should_be_able_to_see_storage_usage_is_increased() {
            int newStorage=BrowserUtil.stringToNumber(filePage.storage);
        System.out.println("asserting if storage increased");
        Assert.assertTrue(newStorage>storage);
            BrowserUtil.deleteFileInList("fallout-3_00379625\n" +
                    ".jpg",editFilePage.files);
    }



}
