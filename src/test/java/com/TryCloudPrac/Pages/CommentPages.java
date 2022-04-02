package com.TryCloudPrac.Pages;

import com.TryCloudPrac.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CommentPages {

    public CommentPages (){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy (xpath = "//a[@id='commentsTabView']")
    public WebElement commentTab;

    @FindBy(xpath = "//div[@class='message']")
    public WebElement messageBox;

    @FindBy(xpath = " //input[@class='submit icon-confirm has-tooltip']")
    public WebElement sendMessage;

    @FindBy(xpath = " //*[@id=\"commentsTabView\"]/ul/li/div[2]")
    public WebElement findMessage;


}
