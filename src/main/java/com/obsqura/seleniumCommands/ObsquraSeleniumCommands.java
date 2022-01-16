package com.obsqura.seleniumCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import javax.jnlp.ClipboardService;
import java.util.ArrayList;
import java.util.List;

public class ObsquraSeleniumCommands {
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
        testInitlz("Chrome");
    }

    @AfterMethod
    public void tearDown() {
        //driver.close();
    }

    @Test(priority = 1)
    public void verifySimpleInputForm() {
        driver.get("https://selenium.obsqurazone.com/index.php");
        WebElement inputFormMenu = driver.findElement(By.xpath("//li[@class='nav-item']/a[@class='nav-link' and @href='simple-form-demo.php']"));
        inputFormMenu.click();
        WebElement enterMessage = driver.findElement(By.id("single-input-field"));
        enterMessage.sendKeys("Test123");
        WebElement showMessageBtn = driver.findElement(By.id("button-one"));
        showMessageBtn.click();
        WebElement showMessage = driver.findElement(By.id("message-one"));
        String message = showMessage.getText();
        System.out.println(message);
    }

    @Test(priority = 2)
    public void verifyTwoInputFields() {
        driver.get("https://selenium.obsqurazone.com/simple-form-demo.php");
        WebElement valueA = driver.findElement(By.id("value-a"));
        valueA.sendKeys("10");
        WebElement valueB = driver.findElement(By.id("value-b"));
        valueB.sendKeys("20");
        WebElement getTotalBtn = driver.findElement(By.id("button-two"));
        getTotalBtn.click();
        WebElement getTotalResult = driver.findElement(By.id("message-two"));
        String totalMessage = getTotalResult.getText();
        System.out.println(totalMessage);
    }

    @Test(priority = 3)
    public void verifySingleCheckBoxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        WebElement checkBoxSelect = driver.findElement(By.id("gridCheck"));
        checkBoxSelect.click();
        boolean chkboxSelectStatus = checkBoxSelect.isSelected();
        System.out.println(chkboxSelectStatus);
        WebElement successMessage = driver.findElement(By.id("message-one"));
        String sMessage = successMessage.getText();
        System.out.println(sMessage);
    }

    @Test(priority = 4)
    public void verifyMultipleCheckBoxDemo() {
        driver.get("https://selenium.obsqurazone.com/check-box-demo.php");
        selectCheckBox("check-box-two", "check-box-four");
    }

    public void selectCheckBox(String select1, String select2) {
        List<WebElement> chkBoxSelect = driver.findElements(By.xpath("//input[@id='check-box-one' or @id='check-box-two' or @id='check-box-three' or @id='check-box-four']"));
        for (int i = 0; i < chkBoxSelect.size(); i++) {
            String val = chkBoxSelect.get(i).getAttribute("id");
            if (val.equals(select1)) {
                chkBoxSelect.get(i).click();
            }
            if (val.equals(select2)) {
                chkBoxSelect.get(i).click();
            }
        }
    }

    @Test(priority = 5)
    public void verifyRadioButtonDemo() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        WebElement showSelectedBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary' and @id='button-one']"));
        selectGender("Male");
        showSelectedBtn.click();
        WebElement showMsg = driver.findElement(By.xpath("//div[@id='message-one' and @class='my-2']"));
        String msg = showMsg.getText();
        System.out.println(msg);
    }

    public void selectGender(String gender) {
        List<WebElement> genderSelection = driver.findElements(By.xpath("//input[@class='form-check-input' and @name='inlineRadioOptions']//following-sibling::label"));
        for (int i = 0; i < genderSelection.size(); i++) {
            if (genderSelection.get(i).getText().equals(gender)) {
                genderSelection.get(i).click();
                break;
            }
        }
    }

    @Test(priority = 6)
    public void verifyGroupRadioBtn() {
        driver.get("https://selenium.obsqurazone.com/radio-button-demo.php");
        selectGender2("Male");
        WebElement showSelectedValueBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary' and @id='button-one']"));
        showSelectedValueBtn.click();
        WebElement radioMsg = driver.findElement(By.xpath("//div[@id='message-one' and @class='my-2']"));
        System.out.println(radioMsg.getText());
        patientsAgeGroup("19 t0 44");
        WebElement getResultBtn = driver.findElement(By.xpath("//button[@class='btn btn-primary' and @id='button-two']"));
        getResultBtn.click();
        WebElement patientMsg = driver.findElement(By.xpath("//div[@id='message-two' and @class='my-2']"));
        String pMsg = patientMsg.getText();
        System.out.println(pMsg);
    }

    public void selectGender2(String gender2) {
        List<WebElement> genderSelection2 = driver.findElements(By.xpath("//input[@class='form-check-input' and @name='student-gender']//following-sibling::label"));
        for (int i = 0; i < genderSelection2.size(); i++) {
            if (genderSelection2.get(i).getText().equals(gender2)) {
                genderSelection2.get(i).click();
                break;
            }
        }
    }

    public void patientsAgeGroup(String age) {
        List<WebElement> patientsAge = driver.findElements(By.xpath("//input[@class='form-check-input' and @name='student-age']//following-sibling::label"));
        for (int j = 0; j < patientsAge.size(); j++) {
            if (patientsAge.get(j).getText().equals(age)) {
                patientsAge.get(j).click();
            }
        }

    }

    @Test(priority = 7)
    public void verifyDropDown() {
        driver.get("https://demo.guru99.com/selenium/newtours/register.php");
        WebElement dropDownElmnt = driver.findElement(By.xpath("//select[@name='country' and @size='1']"));
        Select dropDownSelect = new Select(dropDownElmnt);

        //expected dropdown
        List<String> expDropDwn = new ArrayList<>();
        expDropDwn.add("ALBANIA");
        expDropDwn.add("ALGERIA");
        expDropDwn.add("AMERICAN SAMOA");

         List<WebElement> dropDownSelectOptions = dropDownSelect.getOptions();
        List<String> actDropDown = new ArrayList<>();
              for (int i = 0; i < dropDownSelectOptions.size(); i++) {
            actDropDown.add(dropDownSelectOptions.get(i).getText());
        }
        for(int a=0;a<expDropDwn.size();a++){
            for (int b=0;b<actDropDown.size();b++){
                if(a==b){
                    Assert.assertEquals(actDropDown.get(a),expDropDwn.get(b),"ERROR::Invalid value");
                    System.out.println(expDropDwn);
                    System.out.println(actDropDown);
                }
            }
        }
    }
}
