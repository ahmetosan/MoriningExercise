package com.cybertek.tests;

import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class test4Ahmet extends TestBase {

        @Test
        public void test5() {
            driver.get(ConfigurationReader.get("qa1_url"));

            LoginPage loginPage = new LoginPage();
            loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

            ContactsPage contactsPage = new ContactsPage();
            contactsPage.navigateToModule("Activities", "Calendar Events");

            WebElement cce = driver.findElement(By.xpath("//a[contains(@class,'btn main-group btn-primary pull-right')]"));
            cce.click();
            BrowserUtils.waitFor(2);
            WebElement ccn = driver.findElement(By.xpath("//a[contains(@class,'btn back icons-holder-text')]"));
            ccn.click();
            BrowserUtils.waitFor(2);

            WebElement ace = driver.findElement(By.xpath("//h1[@class='oro-subtitle']"));
            BrowserUtils.waitFor(2);
            Assert.assertTrue(ace.isDisplayed());


        }
}
