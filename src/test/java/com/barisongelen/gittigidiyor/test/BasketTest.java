package com.barisongelen.gittigidiyor.test;

import com.barisongelen.gittigidiyor.driver.Driver;
import com.barisongelen.gittigidiyor.page.LoginPage;
import com.barisongelen.gittigidiyor.page.MainMenuPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;

import java.util.Date;
import java.util.logging.Logger;

public class BasketTest {
    ChromeDriver driver;
    public Logger log = Logger.getAnonymousLogger();


    @Before
    public void Browser(){
        driver = Driver.LaunchChromeDriver();
    }

    @Test
    public void BasketProcess(){
        LoginPage loginPage = new LoginPage(driver);
        MainMenuPage mainMenuPage = new MainMenuPage(driver);;
        loginPage.LoginGittiGidiyor("barisongelen@gmail.com","08081995");
        mainMenuPage.SearchProduct("Bilgisayar");
        mainMenuPage.SelectPager(2);
        mainMenuPage.SelectProduct(2);
        mainMenuPage.BasketControl();
        mainMenuPage.IncreaseAmount();
        mainMenuPage.DeleteProduct();

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
