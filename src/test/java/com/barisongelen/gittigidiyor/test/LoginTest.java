package com.barisongelen.gittigidiyor.test;

import com.barisongelen.gittigidiyor.driver.Driver;
import com.barisongelen.gittigidiyor.page.LoginPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.util.Date;
import java.util.logging.Logger;

public class LoginTest {
    ChromeDriver driver;
    public Logger log = Logger.getAnonymousLogger();
    @Before
    public void Browser(){
        driver = Driver.LaunchChromeDriver();
    }

    @Test
    public void LoginProcessTest(){
        new LoginPage(driver).LoginGittiGidiyor("user_email","password");
    }

    @After
    public void Close(){
        try{
            LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);
            logEntries.forEach (entry -> log.info("CONSOLE LOGS == > "+new Date(entry.getTimestamp()) + " " + entry.getLevel () + " " + entry.getMessage()));
        }catch (Exception e){
            e.printStackTrace ();
        }
        driver.quit();
    }
}
