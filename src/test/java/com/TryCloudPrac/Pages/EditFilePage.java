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

    //Readme

}
