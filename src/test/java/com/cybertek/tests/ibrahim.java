package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ibrahim extends TestBase {
    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Activities", "Calendar Events");
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
        action.moveToElement(calendarEventsPage.threeDot).perform();
        BrowserUtils.waitFor(2);
        WebElement View = driver.findElement(By.xpath("//tr[contains(.,'Testers Meeting')]/td[contains(.,'...')]/div/div/ul/li/ul/li[1]"));
        WebElement Edit = driver.findElement(By.xpath("//tr[contains(.,'Testers Meeting')]/td[contains(.,'...')]/div/div/ul/li/ul/li[2]"));
        WebElement Delete = driver.findElement(By.xpath("//tr[contains(.,'Testers Meeting')]/td[contains(.,'...')]/div/div/ul/li/ul/li[3]"));
        System.out.println(View.isEnabled());
        System.out.println(Edit.isEnabled());
        System.out.println(Delete.isEnabled());
        BrowserUtils.waitFor(2);
        boolean result;
        if(View.isEnabled() && Edit.isEnabled()&& Delete.isEnabled()){
            result=true;
        }else{
            result=false;
        }
      Assert.assertTrue(result,"hello");


    }

}
