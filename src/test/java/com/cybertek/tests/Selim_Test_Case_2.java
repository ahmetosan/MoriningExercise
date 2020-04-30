package com.cybertek.tests;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Selim_Test_Case_2 {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = Driver.get();
        driver.get("http://practice-cybertekschool.herokuapp.com/");
        WebElement registrationForm = driver.findElement(By.linkText("Registration Form"));
        registrationForm.click();

    }

    @Test
    public void test1() {
        WebElement dateOfBirth = driver.findElement(By.xpath("//input[@type='text' and @name='birthday']"));
        dateOfBirth.sendKeys("wrong_dob" + Keys.ENTER);

        String expected = "The date of birth is not valid";
        WebElement message = driver.findElement(By.xpath("//small[@data-bv-result='INVALID']"));
        //      String actual = message.getAttribute("value");
        String actual = message.getText();
        System.out.println(actual);
        Assert.assertTrue(actual.equals(expected));
        System.out.println(dateOfBirth.getLocation());
        System.out.println(message.getLocation());
    }

    @Test
    public void test2() {
        WebElement cLang = driver.findElement(By.xpath("(//label[@class='form-check-label'])[1]"));
        System.out.println(cLang.getText());
        WebElement java = driver.findElement(By.xpath("(//label[@class='form-check-label'])[2]"));
        System.out.println(java.getText());
        WebElement script = driver.findElement(By.xpath("(//label[@class='form-check-label'])[3]"));
        System.out.println(script.getText());

        String expected1 = "C++";
        String expected2 = "Java";
        String expected3 = "JavaScript";
        Assert.assertEquals(cLang.getText(), expected1);
        Assert.assertEquals(java.getText(), expected2);
        Assert.assertEquals(script.getText(), expected3);

    }

    @Test
    public void test3() {
        String expected = "first name must be more than 2 and less than 64 characters long";
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']"));
        nameBox.sendKeys("w" + Keys.ENTER);

        WebElement nameMessage = driver.findElement(By.xpath("//small[@data-bv-for='firstname' and @data-bv-result='INVALID']"));
        System.out.println(nameMessage.getText());
        Assert.assertEquals(nameMessage.getText(), expected);
    }

    @Test
    public void test4() {
        String expected = "The last name must be more than 2 and less than 64 characters long";
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text' and @name='lastname']"));
        nameBox.sendKeys("w" + Keys.ENTER);

        WebElement nameMessage = driver.findElement(By.xpath("//small[@data-bv-for='lastname' and @data-bv-result='INVALID']"));
        System.out.println(nameMessage.getText());
        Assert.assertEquals(nameMessage.getText(), expected);
    }

    @Test
    public void test5() {
        WebElement nameBox = driver.findElement(By.xpath("//input[@type='text' and @name='firstname']"));
        nameBox.sendKeys("xxxxxxxxx");

        WebElement lastnameBox = driver.findElement(By.xpath("//input[@type='text' and @name='lastname']"));
        lastnameBox.sendKeys("xxxxxxx");

        WebElement username = driver.findElement(By.xpath("//input[@type='text' and @name='username']"));
        username.sendKeys("xxxxxx");

        WebElement email = driver.findElement(By.xpath("//input[@type='text' and @name='email']"));
        email.sendKeys("sdfsdf@sdfsdf.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password' and @name='password']"));
        password.sendKeys("xxxxxxxx");

        WebElement phoneNumber = driver.findElement(By.xpath("//input[@type='tel' and @name='phone']"));
        phoneNumber.sendKeys("235-235-4254");

        WebElement gender = driver.findElement(By.xpath("//input[@value='male']"));
        gender.click();

        WebElement birthday = driver.findElement(By.xpath("//input[@type='text' and @name='birthday']"));
        birthday.sendKeys("12/12/1999");

        WebElement element1 = driver.findElement(By.xpath("//select[@name='department']"));
        Select select = new Select(element1);
        select.selectByValue("MCTC");

        WebElement element2 = driver.findElement(By.xpath("//select[@name='job_title']"));
        Select select2 = new Select(element2);
        select2.selectByVisibleText("QA");

        WebElement java = driver.findElement(By.xpath("//input[@value='java']"));
        gender.click();

        WebElement signUp = driver.findElement(By.id("wooden_spoon"));
        signUp.click();

        String expected = "You've successfully completed registration!";

        WebElement message = driver.findElement(By.xpath("//p"));
        Assert.assertEquals(message.getText(), expected);
    }

    @Test
    public void test6() {
        driver = Driver.get();
        driver.get("https://www.tempmailaddress.com/");
    }
}
