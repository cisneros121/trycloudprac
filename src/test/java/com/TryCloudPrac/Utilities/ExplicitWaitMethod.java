package com.TryCloudPrac.Utilities;

import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ExplicitWaitMethod {
    public static WebDriverWait explicitWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
       return wait;
    }
}
