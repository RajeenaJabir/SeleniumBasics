package com.obsqura.homeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Wikipedia {
    public static void main(String args[]) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pgesource= driver.getPageSource();
        System.out.println(pgesource);
        WebElement userID= driver.findElement(By.id("n-contents"));
        System.out.println(userID);
        WebElement userName= driver.findElement(By.name("format-detection"));
        System.out.println(userName);
        WebElement clsName= driver.findElement(By.className("mw-list-item"));
        System.out.println(clsName);
        WebElement cssSelect=driver.findElement(By.cssSelector("#n-contents"));
        System.out.println(cssSelect);
        WebElement xpath=driver.findElement(By.xpath("//*[@id=\"n-contents\"]"));
        System.out.println(xpath);
        WebElement lnktxt = driver.findElement(By.linkText("Contents"));
        System.out.println(lnktxt);
        List<WebElement> tags=driver.findElements(By.tagName("div"));
        System.out.println(tags.size());
       WebElement prtllnktxt = driver.findElement(By.partialLinkText("View "));
       System.out.println(prtllnktxt);
    }
}
