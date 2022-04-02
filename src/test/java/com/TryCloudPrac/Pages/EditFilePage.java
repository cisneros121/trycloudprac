package com.TryCloudPrac.Pages;

import com.TryCloudPrac.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.LinkedHashSet;
import java.util.List;

public class EditFilePage {

    public EditFilePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//a[@class='action action-menu permanent']")
    public List<WebElement> actions;

    @FindBy(xpath = "//a[@class='nav-icon-favorites svg']")
    public WebElement favoritesTab;

    @FindBy(xpath = "//a[@class='name']")
    public List<WebElement> files;

    @FindBy(xpath = "//a[@class='menuitem action action-favorite permanent']")
    public WebElement addFavoriteButton;

    @FindBy(xpath = "//span[.='Remove from favorites']/..")
    public WebElement removeFavorite;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement addButton;

    @FindBy(xpath = "//label[@for='file_upload_start']")
    public WebElement uploadButton;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement deletedFile;

    @FindBy(xpath = "//span[@class='nametext extra-data']")
    public List<WebElement> deletedFiles;

    @FindBy(xpath = "//a[.='Deleted']")
    public WebElement deleteSort;

    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement upload;

    @FindBy (xpath = "//div[@id='uploadprogressbar']")
    public WebElement uploadBar;

    @FindBy(xpath = "//div[@class='toastify on dialogs error toastify-right toastify-top']/span")
    public WebElement notEnoughSpaceBtn;

    @FindBy(xpath = "//a[@class='name']/span[@class='nametext']")
    public List<WebElement> fileNames;

    @FindBy(xpath = "(//a[@class='menuitem'])[1]")
    public WebElement newFolder;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement newFolderTextBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement submitBtn;




    //Readme

}
