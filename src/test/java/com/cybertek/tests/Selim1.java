package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Selim1 extends TestBase {

    @Test
    public void test1() {
        //this is new try add new comment line
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

    @Test
    public void testCase2() throws InterruptedException {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//i[@class='fa-cog hide-text']"));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
        Thread.sleep(2000);
        //tbody/tr[7]/td[3]

        for (int i = 2; i <= 7; i++) {
            WebElement checkboxes = driver.findElement(By.xpath("//tbody/tr[" + i + "]/td[3]"));
            if (checkboxes.isDisplayed()) {
                checkboxes.click();
            }

        }
        WebElement title = driver.findElement(By.xpath("//tbody/tr[" + 1 + "]/td[3]"));
        Assert.assertTrue(title.isDisplayed());
    }

    @Test
    public void testCase3() throws InterruptedException {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        Thread.sleep(5000);
        WebElement calEvent = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        wait.until(ExpectedConditions.elementToBeClickable(calEvent));
        calEvent.click();

        Thread.sleep(3000);
        WebElement expandButton = driver.findElement(By.xpath("//span[@class='caret']"));
        wait.until(ExpectedConditions.elementToBeClickable(expandButton));
        expandButton.click();

        //verify 3 buttons
        WebElement button1 = driver.findElement(By.xpath("(//*[contains(text(),'Save and Close')])[2]"));
        WebElement button2 = driver.findElement(By.xpath("//*[contains(text(),'Save and New')]"));
        WebElement button3 = driver.findElement(By.xpath("//*[contains(text(),'Save')]"));
        Assert.assertTrue(button1.isDisplayed());
        Assert.assertTrue(button2.isDisplayed());
        Assert.assertTrue(button3.isDisplayed());
    }
}