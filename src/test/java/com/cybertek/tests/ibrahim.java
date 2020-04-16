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

import java.util.List;

public class ibrahim extends TestBase {
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

        WebElement getSetting = driver.findElement(By.xpath("//a[@title='Grid Settings']"));
        getSetting.click();

//        for (int i = 2; i <= 7 ; i++) {
//            WebElement calendar = driver.findElement(By.xpath("//tr[@class='renderable']["+i+"]/td[3]"));
//            calendar.click();
//            BrowserUtils.waitFor(2);
//        }
        List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='renderable']/td[3]"));
        for (int i = 0; i <8 ; i++) {
            elements.get(i).click();
        }
        WebElement Displayed = driver.findElement(By.xpath("//tr[@class='renderable'][1]/td[3]"));
        Assert.assertTrue(Displayed.isEnabled());
    }

}

//
//
//
//
//
//

//
////        for (int i = 2; i <= 7 ; i++) {
////            WebElement calendar = driver.findElement(By.xpath("//tr[@class='renderable']["+i+"]/td[3]"));
////            calendar.click();
////            BrowserUtils.waitFor(2);
////        }
//        List<WebElement> elements = driver.findElements(By.xpath("//tr[@class='renderable']/td[3]"));
//        for (int i = 1; i <8 ; i++) {
//            elements.get(i).click();
//        }
//        WebElement Displayed = driver.findElement(By.xpath("//tr[@class='renderable'][1]/td[3]"));
//        Assert.assertTrue(Displayed.isEnabled());
//    }
//
//}