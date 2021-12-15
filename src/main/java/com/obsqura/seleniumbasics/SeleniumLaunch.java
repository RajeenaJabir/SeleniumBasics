package com.obsqura.seleniumbasics;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumLaunch {
    static WebDriver driver;

    public static void testInitlz(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\SELENIUM\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\geckodriver.exe");
            driver = new FirefoxDriver();
        }
    }

    public static void main(String args[]) {
        testInitlz("Chrome");
        testInitlz("Edge");
        testInitlz("Firefox");

    }
}