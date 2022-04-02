package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.FilePage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class FilesStepDefinitions {
FilePage filePage= new FilePage();
    @Then("verify the page title is \"Files - Trycloud QA.”")
    public void verify_the_page_title_is_files_trycloud_qa() {

        String expected="Files - Trycloud QA."; // not equal Has QA.

       Assert.assertEquals("not equal", expected,Driver.getDriver().getTitle());
    }

    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filePage.selectAllCheckbox.click();
    }
    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {

        for (WebElement checkBox : filePage.checkBoxes) {
            System.out.println(checkBox);
            Assert.assertTrue(checkBox.isSelected());

        }

    }


}
