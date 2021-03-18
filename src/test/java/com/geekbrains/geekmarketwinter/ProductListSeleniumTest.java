package com.geekbrains.geekmarketwinter;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;




public class ProductListSeleniumTest {
    private WebDriver driver;

    @BeforeSuite
    public void init() {
        this.driver = new ChromeDriver();
        this.driver.manage().window().maximize();
    }

    @Test
    public void test1() {
        driver.get("http://localhost:8181/wintermarket/shop/?page=1");
        int rowCount = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr")).size();
        Assert.assertEquals(rowCount, 5);
    }

    @AfterSuite
    public void shutdown() {
        this.driver.quit();
    }

}
