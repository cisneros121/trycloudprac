package com.TryCloudPrac.Utilities;

public class BrowserUtil {
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
