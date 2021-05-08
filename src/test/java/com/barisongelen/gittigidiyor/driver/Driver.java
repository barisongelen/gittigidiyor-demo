package com.barisongelen.gittigidiyor.driver;

import org.junit.After;
import org.junit.BeforeClass;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Driver {

    public Logger log = Logger.getAnonymousLogger();
    public ChromeDriver driver;
    public Driver(ChromeDriver driver){
        this.driver = driver;
    }

    public static ChromeDriver LaunchChromeDriver(){
        ChromeDriver driver;
        ChromeOptions co = new ChromeOptions();
        Map<String, Object> prefs = new HashMap<>();
        LoggingPreferences logPrefs = new LoggingPreferences();
        logPrefs.enable (LogType.BROWSER, Level.ALL);
        co.setCapability(CapabilityType.LOGGING_PREFS, logPrefs);
        co.setExperimentalOption("prefs", prefs);
        co.addArguments("--test-type");
        co.addArguments("--disable-popup-blocking");
        co.addArguments("--disable-save-password-bubble");
        co.addArguments("--ignore-certificate-errors");
        co.addArguments("--disable-translate");
        co.addArguments("--start-maximized");
        co.addArguments("--allow-silent-push");
        co.addArguments("--enable-automation");
        co.addArguments("--enable-javascript");
        System.setProperty("webdriver.chrome.driver", "properties/driver/chromedriver.exe");
        driver = new ChromeDriver(co);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS) ;
        driver.get("https://www.gittigidiyor.com/");
        return driver;
    }

}
