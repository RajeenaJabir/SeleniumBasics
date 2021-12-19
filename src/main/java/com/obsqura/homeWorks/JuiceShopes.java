package com.obsqura.homeWorks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class JuiceShopes {
    public static void main(String args[]) {
        WebDriver driver;
        System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://owasp.org/www-project-juice-shop/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        String actualTitle=driver.getTitle();
        System.out.println(actualTitle);
        String currentUrl= driver.getCurrentUrl();
        System.out.println(currentUrl);
        String pgesource= driver.getPageSource();
        System.out.println(pgesource);
        WebElement userID= driver.findElement(By.id("description"));
        System.out.println(userID);
        WebElement userName= driver.findElement(By.name("description"));
        System.out.println(userName);
        WebElement clsName= driver.findElement(By.className("nav-button"));
        System.out.println(clsName);
        WebElement cssSelect=driver.findElement(By.cssSelector("body > header > div.header-wrapper > nav.top-nav > div > div > a.cta-button.green"));
        System.out.println(cssSelect);
        WebElement xpath=driver.findElement(By.xpath("/html/body/header/div[3]/nav[2]/div/div/a[2]"));
        System.out.println(xpath);
        WebElement lnktxt = driver.findElement(By.linkText("Donate"));
        System.out.println(lnktxt);
        List<WebElement> tags=driver.findElements(By.tagName("div"));
        System.out.println(tags.size());
        WebElement prtllnktxt = driver.findElement(By.partialLinkText("Join"));
        System.out.println(prtllnktxt);
    }
}
