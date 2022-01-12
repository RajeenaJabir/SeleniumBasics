package com.obsqura.seleniumCommands;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

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

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test(priority = 1)
    public void verifyLogin() {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement loginMenu = driver.findElement(By.xpath("//a[@class='ico-login']"));
        loginMenu.click();
        WebElement email = driver.findElement(By.id("Email"));
        email.sendKeys("rajeena123@gmail.com");
        // email.clear();
        WebElement password = driver.findElement(By.cssSelector("#Password"));
        password.sendKeys("rajeena123");
        WebElement loginButton = driver.findElement(By.xpath("//input[@class='button-1 login-button']"));
        String value = loginButton.getAttribute("value");
        System.out.println(value);
        String lgnbtn = loginButton.getTagName();
        System.out.println(lgnbtn);
        Point location = loginButton.getLocation();
        System.out.println(location);//location.x
        Dimension size = loginButton.getSize();
        System.out.println(size);//size.width
        Boolean enabled = loginButton.isEnabled();
        System.out.println(enabled);
        loginButton.click();
    }

    @Test(priority = 2)
    public void verifyRegister() {
        driver.get("http://demowebshop.tricentis.com/register");
        WebElement registerMenu = driver.findElement(By.className("ico-register"));
        registerMenu.click();
        WebElement genderRadioButton = driver.findElement(By.xpath("//div[@class='gender' ]//following-sibling::input[@id='gender-female']"));
        Boolean selectedStatus = genderRadioButton.isSelected();
        System.out.println(selectedStatus);
        genderRadioButton.click();
        WebElement firstName = driver.findElement(By.id("FirstName"));
        firstName.sendKeys("minnu");
        WebElement lastName = driver.findElement(By.id("LastName"));
        lastName.sendKeys("mm");
        WebElement email1 = driver.findElement(By.id("Email"));
        email1.sendKeys("minnumm@gmail.com");
        WebElement password1 = driver.findElement(By.id("Password"));
        password1.sendKeys("minnumm123");
        WebElement confirmPassword = driver.findElement(By.id("ConfirmPassword"));
        confirmPassword.sendKeys("minnumm123");
        WebElement registerButton = driver.findElement(By.id("register-button"));
        registerButton.click();
        WebElement successMessage=driver.findElement(By.xpath("//div[@class='page-body']/div"));
        String message=successMessage.getText();
        System.out.println(message);
    }

    @Test(priority = 3)
    public void verifyFindElements() {
        driver.get("http://demowebshop.tricentis.com/register");
        WebElement registerMenu = driver.findElement(By.className("ico-register"));
        registerMenu.click();
        selectGender("Female");
    }
    public void selectGender(String gender) {
        List<WebElement> genderSelect = driver.findElements(By.xpath("//input[@id='gender-male' or @id='gender-female']"));
        for (int i = 0; i < genderSelect.size(); i++) {
            String value = genderSelect.get(i).getText();
            if (value.equals(gender))
            //if (genderSelect.get(i).getText().equals(gender))
            {
                genderSelect.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 4)
    public void verifyNavigationCommands()//for browser navigation
    {
        driver.get("http://demowebshop.tricentis.com/");
        WebElement registerMenu = driver.findElement(By.className("ico-register"));
        registerMenu.click();
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.navigate().to("https://demo.guru99.com/test/newtours/");
    }

    @Test(priority = 5)
    public void verifyCommunityPoll() {
        driver.get("http://demowebshop.tricentis.com/");
        selectCommunityPoll("Poor");
    }
    public void selectCommunityPoll(String pollText) {
        List<WebElement> pollSelect = driver.findElements(By.xpath("//input[@name='pollanswers-1' or  type='radio']//following-sibling::label"));
        for (int j = 0; j < pollSelect.size(); j++) {
            if (pollSelect.get(j).getText().equals(pollText)) {
                pollSelect.get(j).click();
                break;
            }
        }

    }

}
