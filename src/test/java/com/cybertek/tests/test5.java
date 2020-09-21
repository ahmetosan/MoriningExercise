package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class test5 extends TestBase {
    @Test
    public void test2() {
        driver.get(ConfigurationReader.get("qa1_url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Activities", "Calendar Events");
        BrowserUtils.waitFor(2);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();
       WebElement event=driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right']"));
        WebElement getSetting =driver.findElement(By.xpath("//a[@title='Grid Settings']"));
       event.click();
       //(By.xpath("//li[@class='ui-timepicker-pm ui-timepicker-selected']"));
//       WebElement start=driver.findElement(By.xpath("//input[@id='time_selector_oro_calendar_event_form_start-uid-5e97dc6fd4d62']"));
//       start.click();
//        System.out.println(start.getText());
    }
}