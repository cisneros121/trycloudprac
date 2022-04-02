package com.TryCloudPrac.Pages;

import com.TryCloudPrac.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SettingPage {
    public SettingPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(className = "settings-button")
    public WebElement settingButton;

    @FindBy(xpath = "//div[@id='app-settings-content']//*[@class='checkbox']/../label")
    public List<WebElement> checkBoxes;
//div[@id='app-settings-content']//input[@type='checkbox']//following-sibling::label



    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
    public List<WebElement> checkBoxBtn;

    @FindBy(xpath = "//div[@id='recommendations']")
    public WebElement checkedRecommended;

    @FindBy(xpath = "//div[@Id='rich-workspace']")
    public WebElement checkedWorkSpace;

    @FindBy(xpath = "//div[@class='viewcontainer has-comments has-selection']")
    public WebElement checkedHidden;

    @FindBy(xpath ="//div[@class='viewcontainer has-comments has-selection hide-hidden-files']" )
    public WebElement hiddenUnchecked;

    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
    public List<WebElement> test;





}
