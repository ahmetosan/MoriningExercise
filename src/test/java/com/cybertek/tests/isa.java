package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

public class isa extends TestBase {

    //    Test Case #1
//             1. Go to “https://qa1.vytrack.com/"
//            2. Login as a store manager
//            3. Navigate to “Activities -> Calendar Events”
//            4. Hover on three dots “…” for “Testers meeting” calendar event
//            5. Verify that “view”, “edit” and “delete” options are available
    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("qa1_url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        calendarEventsPage.waitUntilLoaderScreenDisappear();

        action.moveToElement(calendarEventsPage.threeDot).perform();

        BrowserUtils.waitFor(3);


        WebElement View=driver.findElement(By.xpath("//tr[contains(.,'Testers Meeting')]/td[contains(.,'...')]/div/div/ul/li/ul/li[1]"));

        WebElement Edit=driver.findElement(By.xpath("//tr[contains(.,'Testers Meeting')]/td[contains(.,'...')]/div/div/ul/li/ul/li[2]"));

        WebElement Delete=driver.findElement(By.xpath("//tr[contains(.,'Testers Meeting')]/td[contains(.,'...')]/div/div/ul/li/ul/li[3]"));

        boolean result;
        if(View.isEnabled() && Edit.isEnabled() && Delete.isEnabled()){
            result=true;
        }else{
            result=false;
       }

    Assert.assertTrue(result);

    }


}
