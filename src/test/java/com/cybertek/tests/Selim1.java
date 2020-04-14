package com.cybertek.tests;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selim1 extends TestBase {

    @Test
    public void test1() {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);

        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        action.moveToElement(calendarEventsPage.threeDot).perform();
        BrowserUtils.waitFor(3);

        WebElement eye = driver.findElement(By.xpath("//i[@class='fa-eye hide-text']"));
        WebElement edit = driver.findElement(By.xpath("//i[@class='fa-pencil-square-o hide-text']"));
        WebElement delete = driver.findElement(By.xpath("//i[@class='fa-trash-o hide-text']"));

        System.out.println(eye.isEnabled());
        System.out.println(eye.getText());
        System.out.println(eye.isSelected());
        System.out.println(eye.isDisplayed());

        System.out.println(edit.isEnabled());
        System.out.println(edit.getText());
        System.out.println(edit.isSelected());
        System.out.println(edit.isDisplayed());

        System.out.println(delete.isEnabled());
        System.out.println(delete.isSelected());
        System.out.println(delete.isDisplayed());
    }
}
