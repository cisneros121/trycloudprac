package com.TryCloudPrac.Pages;

import com.TryCloudPrac.Utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "user")
    public WebElement user;

    @FindBy(id="password")
    public WebElement password;

    @FindBy(id="submit-form")
    public WebElement loginButton;

    @FindBy(xpath ="//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;




}
