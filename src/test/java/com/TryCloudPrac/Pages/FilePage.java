package com.TryCloudPrac.Pages;

import com.TryCloudPrac.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilePage {
    public FilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllCheckbox;
//input[@id='select_all_files']

    @FindBy(xpath = "//input[@class='selectCheckBox checkbox']")
    public List<WebElement> checkBoxes;


    @FindBy(xpath = "//a[@class='icon-quota svg']/p")
    public WebElement storage;





}