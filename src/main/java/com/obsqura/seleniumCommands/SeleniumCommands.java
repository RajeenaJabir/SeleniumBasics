package com.obsqura.seleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SeleniumCommands {
    WebDriver driver;

    public void testInitlz(String browser) {
        if (browser.equals("Chrome")) {
            System.setProperty("webdriver.chrome.driver", "C:\\SELENIUM\\chromedriver.exe");
            driver = new ChromeDriver();
        } else if (browser.equals("Edge")) {
            System.setProperty("webdriver.edge.driver", "C:\\SELENIUM\\msedgedriver.exe");
            driver = new EdgeDriver();
        } else if (browser.equals("Firefox")) {
            System.setProperty("webdriver.gecko.driver", "C:\\SELENIUM\\geckodriver.exe");
            driver = new FirefoxDriver();
        } else {
            try {
                throw new Exception("Invalid browser exception");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
    }
    @BeforeMethod
    public void setUp() {
        //call precondition
        testInitlz("Chrome");
    }
    @Test(priority = 1)
    public void verifyLogin() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement  loginMenu=driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement  email= driver.findElement(By.id("Email"));
        email.sendKeys("rajeena123@gmail.com");
        WebElement password= driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("rajeena123");
        WebElement  loginButton= driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        String value=loginButton.getAttribute("value");
        System.out.println(value);
        loginButton.click();
    }
    @Test(priority = 2)
    public void verifyRegister(){
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu=driver.findElement(By.className("ico-register"));
        registerMenu.click();
        WebElement genderRadioButton= driver.findElement(By.xpath("//div[@class='gender' ]//following-sibling::input[@id='gender-female']"));
        genderRadioButton.click();
        WebElement firstName= driver.findElement(By.id("FirstName"));
        firstName.sendKeys("abcd");
        WebElement lastName= driver.findElement(By.id("LastName"));
        lastName.sendKeys("ee");
        WebElement email1= driver.findElement(By.id("Email"));
        email1.sendKeys("abcd@gmail.com");
        WebElement password1= driver.findElement(By.id("Password"));
        password1.sendKeys("abcd123");
        WebElement confirmPassword= driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("abcd123");
        WebElement registerButton= driver.findElement(By.id("register-button"));
        registerButton.click();
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='page-body']/div"));
        String message=successMessage.getText();
        System.out.println(message);
        //WebElement registerHeading=driver.findElement(By.xpath("//div[@class='page-title']/h1"));
        //String ms=registerHeading.getText();
        //System.out.println(ms);
    }
    @AfterMethod
    public void tearDown() {
        driver.close();
    }
}
