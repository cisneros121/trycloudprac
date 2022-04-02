package com.TryCloudPrac.StepDefinitions;

import com.TryCloudPrac.Pages.ModulesPage;
import com.TryCloudPrac.Utilities.BrowserUtil;
import com.TryCloudPrac.Utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class ContactsStepDefinition {

    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String string) {

        Assert.assertEquals("title is not equal",string, Driver.getDriver().getTitle());
    }



    @Then("verify the contact names are in the list")
    public void verifyTheContactNamesAreInTheList() {
        BrowserUtil.sleep(3);
        System.out.println("there are "+modulesPage.contactList.size()+ " contacts with the following names");
        int i=0;
        for (WebElement element : modulesPage.contactList) {
            if (i==modulesPage.contactList.size()-1){
                System.out.print(element.getText());
                break;
            }
            System.out.print(element.getText()+", ");
i++;
        }


    }
    ModulesPage modulesPage= new ModulesPage();
}
