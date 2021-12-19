package com.obsqura.homeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class OrangeHRM {
    public static void main(String args[]) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.orangehrm.com/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pgesource1= driver.getPageSource();
        System.out.println(pgesource1);
        WebElement userID= driver.findElement(By.id("optanon"));
        System.out.println(userID);
        WebElement userName= driver.findElement(By.name("generator"));
        System.out.println(userName);
        WebElement clsName= driver.findElement(By.className("ex-nav"));
        System.out.println(clsName);
        WebElement cssSelect=driver.findElement(By.cssSelector("#header-navbar > ul.nav.navbar-nav.navbar-right.extended-nav > li:nth-child(2) > a"));
        System.out.println(cssSelect);
        WebElement xpath=driver.findElement(By.xpath("//*[@id=\"header-navbar\"]/ul[3]/li[2]/a"));
        System.out.println(xpath);
        WebElement lnktxt1 = driver.findElement(By.linkText("FREE TRIAL"));
        System.out.println(lnktxt1);
        List<WebElement> tags=driver.findElements(By.tagName("input"));
        System.out.println(tags.size());
        //WebElement prtllnktxt = driver.findElement(By.partialLinkText("Contact "));//NoSuchElementException: no such element: Unable to locate element: {"method":"partial link text","selector":"Contact Sales"}
       // System.out.println(prtllnktxt);
    }
}
