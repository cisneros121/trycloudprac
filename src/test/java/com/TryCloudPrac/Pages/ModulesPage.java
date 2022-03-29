package com.TryCloudPrac.Pages;

import com.TryCloudPrac.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ModulesPage {
    public ModulesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//span")
   public List<WebElement> modules;

    @FindBy(xpath = "//a[@aria-label='Files']")
    public WebElement Files;

}
