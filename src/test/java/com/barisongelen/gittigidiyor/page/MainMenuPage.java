package com.barisongelen.gittigidiyor.page;

import com.barisongelen.gittigidiyor.driver.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;
import java.util.List;


public class MainMenuPage extends Driver {

    public MainMenuPage(ChromeDriver driver) {
        super(driver);
    }

    public void SearchProduct(String productName){
        driver.findElement(By.cssSelector("[data-cy='header-search-input']")).sendKeys(productName);
        driver.findElement(By.cssSelector("[data-cy='search-find-button']")).click();
    }

    public void SelectPager(int pager){
        List<WebElement> pagerList = driver.findElements(By.cssSelector("#best-match-right .pager .clearfix > li"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", pagerList.get(pager - 1));
        pagerList.get(pager - 1).click();
    }

    public void SelectProduct(int productNo){
        List<WebElement> productList = driver.findElements(By.cssSelector(".catalog-view.products-container > li"));
        productList.get(productNo).click();
    }

    public void BasketControl(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.id("add-to-basket")));
        driver.findElement(By.id("add-to-basket")).click();
        driver.findElement(By.className("basket-container")).click();
        Assert.assertTrue("Fiyat goruntulenmedi", driver.findElement(By.className("total-price")).isDisplayed());
    }
    public void IncreaseAmount(){
        driver.findElement(By.tagName("Option")).click();
        driver.findElement(By.cssSelector("option[value='2']")).click();

    }
    public void DeleteProduct(){
        driver.findElement(By.className("btn-delete")).click();



    }}

