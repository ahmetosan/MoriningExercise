package com.cybertek.tests;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.ContactsPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class testt2 extends TestBase {
    @Test
    public void test4() {
        driver.get(ConfigurationReader.get("qa1_url"));

        LoginPage loginPage = new LoginPage();
        loginPage.login(ConfigurationReader.get("storemanager_username"), ConfigurationReader.get("storemanager_password"));

        ContactsPage contactsPage = new ContactsPage();
        contactsPage.navigateToModule("Activities", "Calendar Events");


        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        WebElement getSetting = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        getSetting.click();

//        for (int i = 2; i <= 7 ; i++) {
//            WebElement calendar = driver.findElement(By.xpath("//tr[@class='renderable']["+i+"]/td[3]"));
//            calendar.click();
//            BrowserUtils.waitFor(2);
//        }
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='renderable']/td[3]"));
        for (int i = 1; i <7 ; i++) {
            elements.get(i).click();
        }
        WebElement Displayed = driver.findElement(By.xpath("//tr[@class='renderable'][1]/td[1]"));
        Assert.assertTrue(Displayed.isDisplayed());
    }

}
