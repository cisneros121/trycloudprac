package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.EditFilePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ManageFoldersStepDefinitions {
    EditFilePage editFilePage= new EditFilePage();
    @When("user clicks the add icon on the top")
    public void user_clicks_the_add_icon_on_the_top() {
        editFilePage.addButton.click();
    }
    @When("user click \"new folder”")
    public void user_click_new_folder() {

    }
    @When("user write a folder name")
    public void user_write_a_folder_name() {

    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {

    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {

    }
}
