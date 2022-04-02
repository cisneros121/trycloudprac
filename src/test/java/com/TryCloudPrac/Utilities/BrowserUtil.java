package com.TryCloudPrac.Utilities;

import com.TryCloudPrac.Pages.EditFilePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BrowserUtil {
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void highlight(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), ConfigurationReader.getNumber("timeout"));
        wait.until(ExpectedConditions.visibilityOf(element));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) Driver.getDriver();

        jsExecutor.executeScript("arguments[0].style.border='3px solid orange'", element);
        jsExecutor.executeScript("arguments[0].style.backgroundColor='yellow'", element);
        jsExecutor.executeScript("arguments[0].style.color='black'", element);
        //BrowserUtils.sleep(0.5);

        jsExecutor.executeScript("arguments[0].style.backgroundColor=''", element);
        jsExecutor.executeScript("arguments[0].style.border='0px solid black'", element);
        jsExecutor.executeScript("arguments[0].style.color=''", element);
    }
//TRY TO STUDY THIS!!
    public static void waitForPageToLoad(long timeOutInSeconds) {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(Driver.getDriver(), timeOutInSeconds);
            wait.until(expectation);
        } catch (Throwable error) {
            error.printStackTrace();
        }
    }


    public static int stringToNumber(WebElement element){
String result="";
int returnNum=0;
        for (char c : element.getText().toCharArray()) {

            if (Character.isDigit(c)){
                result+=c;
            }


        }
        returnNum=Integer.parseInt(result);


        return returnNum;
    }

    public static void deleteFileInList(String file, List<WebElement> files){
        EditFilePage editFilePage= new EditFilePage();
int i=0;
        for (WebElement fileName : files) {
            if (fileName.getText().equals(file)){
                System.out.println("Asserting if file is contained");
                Assert.assertEquals(file,fileName.getText());
                System.out.println("assert passed now deleting file");
                editFilePage.actions.get(i).click();
                WebElement a= Driver.getDriver().findElement(By.xpath("//a[@class='menuitem action action-delete permanent']"));
                BrowserUtil.sleep(3);
                a.click();
                break;
            }
            i++;
        }
    }

    public static void confirmFileInList(String file,List<WebElement>files){

int i=0;
EditFilePage editFilePage= new EditFilePage();

        for (WebElement element : files) {
            System.out.println(element.getText());
            if (element.getText().equals(file)){
                System.out.println("asserting");
                Assert.assertEquals(file,element.getText());
                editFilePage.actions.get(i).click();
                BrowserUtil.sleep(3);
                WebDriverWait wait=new WebDriverWait(Driver.getDriver(),20);
               // wait.until(ExpectedConditions.visibilityOf(editFilePage.deletedFile)).click();
                System.out.println("deleted newly created file");
                WebElement a= Driver.getDriver().findElement(By.xpath("//span[.='Delete folder']/.."));
                a.click();
                return;

                //span[.='Delete file']
            }
            i++;

        }
        System.err.println("Assertion in confirmFileInList Failed");


    }



}
