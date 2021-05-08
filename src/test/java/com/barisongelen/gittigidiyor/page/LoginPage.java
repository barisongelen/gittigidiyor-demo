package com.barisongelen.gittigidiyor.page;

import com.barisongelen.gittigidiyor.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LoginPage extends Driver {

    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    public void LoginGittiGidiyor(String email, String password){
        if(driver.findElement(By.cssSelector("[data-cy='header-user-menu']")).isDisplayed()){
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(By.cssSelector("[data-cy='header-user-menu']"))).perform();
            driver.findElement(By.cssSelector("[data-cy='header-login-button']")).click();
        }
        Assert.assertTrue("Uye girisi goruntulenmedi", driver.findElement(By.id("L-UserNameField")).isDisplayed());
        log.info("Login Page Kontrolu -- PASS");
        driver.findElement(By.id("L-UserNameField")).sendKeys(email);
        driver.findElement(By.id("L-PasswordField")).sendKeys(password);
        driver.findElement(By.id("gg-login-enter")).click();
        try{
            Assert.assertTrue("Login islemi basarisiz", driver.findElement(By.className("gg-input-error-text")).isDisplayed());
        }catch (Exception e){
            log.info("Login Islemi -- PASS");
        }

    }
}
