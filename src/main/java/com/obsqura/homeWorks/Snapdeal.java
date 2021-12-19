package com.obsqura.homeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Snapdeal {
    public static void main(String args[]) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.snapdeal.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pgesource= driver.getPageSource();
        System.out.println(pgesource);
        WebElement userID= driver.findElement(By.id("newAutoSuggestor"));
        System.out.println(userID);
        WebElement userName= driver.findElement(By.name("newAutoSuggestor"));
        System.out.println(userName);
        WebElement clsName= driver.findElement(By.className("cartToastMsg"));
        System.out.println(clsName);
        WebElement cssSelect=driver.findElement(By.cssSelector("#sdHeader > div.headerBar.reset-padding > div.topBar.top-bar-homepage.top-freeze-reference-point > div > div.col-xs-5.reset-padding.header-right.rfloat > div.cartContainer.col-xs-11.reset-padding > div > span"));
        System.out.println(cssSelect);
        WebElement xpath=driver.findElement(By.xpath("//*[@id=\"sdHeader\"]/div[4]/div[2]/div/div[3]/div[1]/div/span"));
        System.out.println(xpath);
        List<WebElement> tags=driver.findElements(By.tagName("div"));
        System.out.println(tags.size());
        WebElement lnktxt = driver.findElement(By.linkText("Help Center"));
        System.out.println(lnktxt);
        WebElement prtllnktxt = driver.findElement(By.partialLinkText("Help "));
        System.out.println(prtllnktxt);


    }
}
