package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.SettingPage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.Driver;
import com.TryCloudPrac.Utilities.ExplicitWaitMethod;
import com.github.javafaker.Faker;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import okhttp3.internal.http.BridgeInterceptor;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SettingsStepDefinition {
    SettingPage settingPage = new SettingPage();

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
        settingPage.settingButton.click();

    }

    int random2 = 0;

    @Then("the user should be able to click any buttons")
    public void the_user_should_be_able_to_click_any_buttons() {


int i=0;
        for (WebElement checkBox : settingPage.checkBoxes) {
            Boolean before=settingPage.checkBoxBtn.get(i).isSelected();
                    settingPage.checkBoxes.get(i).click();
           Boolean after=settingPage.checkBoxBtn.get(i).isSelected();
            System.out.println("before = " + before);
            System.out.println("after = " + after);
            i++;
            System.out.println("checkBox.getAttribute(\"innerText\") = " + checkBox.getAttribute("innerText"));
            Assert.assertNotEquals(before,after);
            BrowserUtil.sleep(2);
        }



    }


}

