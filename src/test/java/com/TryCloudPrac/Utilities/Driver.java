package com.TryCloudPrac.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){

    }
    /*
    we want to close access from outside class static cause we will use it in static method
     */
    //private static WebDriver driver; // null by default
    private static InheritableThreadLocal<WebDriver> driverPool= new InheritableThreadLocal<>();
    // reusuable util method to return my private webDriver when called
    public static WebDriver getDriver(){
        if (driverPool.get()==null){

            /*
            so we can control what browser is opened outside our code
             */
            String browserType= ConfigurationReader.getProperty("browser");
 /*
           open matching browser depending on the case
             */
            switch (browserType){
                case "chrome":

                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "opera":
                    driverPool.set(new OperaDriver());
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            }
        }
        return driverPool.get();

    }static {
        WebDriverManager.chromedriver().setup();
    }
    // method will make sure driver value is null after using quit method. Session ID is null. Using WebDriver after calling quit()?
    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();// will terminate the session value sisnt null makes sure it doesnt exist after it
            driverPool.remove();
        }

    }
}