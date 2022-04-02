package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.CommentPages;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.ExplicitWaitMethod;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WriteCommentStepDefinition {
CommentPages commentPages= new CommentPages();
String comment="apple";
    @When("user write a comment inside the input box")
    public void user_write_a_comment_inside_the_input_box() {
        commentPages.commentTab.click();
        commentPages.messageBox.sendKeys(comment);

    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
        commentPages.sendMessage.click();
    }
    @Then("Verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        BrowserUtil.sleep(3);
        Assert.assertEquals("not equal message",comment,commentPages.findMessage.getText());
    }

}
