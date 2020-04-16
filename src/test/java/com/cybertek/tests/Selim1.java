package com.cybertek.tests;

import com.cybertek.pages.CalendarEventsPage;
import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void testCase5() throws InterruptedException {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");
        Thread.sleep(4000);

        WebElement calEvent = driver.findElement(By.xpath("//a[@title='Create Calendar event']"));
        wait.until(ExpectedConditions.elementToBeClickable(calEvent));
        calEvent.click();

        Thread.sleep(3000);
        WebElement timeS = driver.findElement(By.xpath("(//input[@placeholder='time'])[1]"));
        String timeStart = timeS.getAttribute("value"); // 6:43 AM
        System.out.println(timeStart); //12:40 PM

        WebElement timeE = driver.findElement(By.xpath("(//input[@placeholder='time'])[2]"));
        String timeEnd = timeE.getAttribute("value");  // 7:43 AM
        System.out.println(timeEnd);

        if (timeStart.substring(timeStart.indexOf(" ")).equals(timeEnd.substring(timeEnd.indexOf(" ")))) {
            System.out.println(timeStart.substring(timeStart.indexOf(" ")));
            int x = Integer.parseInt(timeStart.substring(0, timeStart.indexOf(":")));
            int y = Integer.parseInt(timeEnd.substring(0, timeEnd.indexOf(":")));
            System.out.println(x + y);
            if (x + 1 == y) {
                String min = timeStart.substring(timeStart.indexOf(":"), timeStart.indexOf(" "));
                String min2 = timeEnd.substring(timeEnd.indexOf(":"), timeEnd.indexOf(" "));
                if (min.equals(min2)) {
                    System.out.println("Pass");
                }
            }
        }
    }


    @Test
    public void testCase7() throws InterruptedException {
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
        WebElement allDayEvent = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        wait.until(ExpectedConditions.elementToBeClickable(allDayEvent));
        allDayEvent.click();

        Assert.assertTrue(allDayEvent.isSelected());

        WebElement time1 = driver.findElement(By.xpath("(//input[@placeholder='time'])[1]"));
        Assert.assertFalse(time1.isDisplayed());
        WebElement time2 = driver.findElement(By.xpath("(//input[@placeholder='time'])[2]"));
        Assert.assertFalse(time2.isDisplayed());

        WebElement date1 = driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[1]"));
        Assert.assertTrue(date1.isDisplayed());
        WebElement date2 = driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[2]"));
        Assert.assertTrue(date2.isDisplayed());
    }

    @Test
    public void testCase8() throws InterruptedException {
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

        WebElement repeat = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(repeat));
        repeat.click();

        Assert.assertTrue(repeat.isSelected());

        WebElement dropdown = driver.findElement(By.xpath("//select[@class='recurrence-repeats__select']"));
        //create select class using the web element
        Select dropdownList = new Select(dropdown);
        //get the selected option
        WebElement selectedOption = dropdownList.getFirstSelectedOption();

        String expected = "Daily";
        System.out.println(selectedOption.getText());

        List<WebElement> list = Arrays.asList(dropdown);
        for (WebElement each : list) {
            System.out.println(each.getText());
        }

    }

    @Test
    public void testCase9Ben() throws InterruptedException {
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

        WebElement repeat = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(repeat));
        repeat.click();

        WebElement repeatEvery = driver.findElement(By.xpath("//input[@type='radio']"));
        Assert.assertTrue(repeatEvery.isSelected());

    }

    @Test
    public void test9ibrahim() {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");


        WebElement createCalendar = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalendar.click();
        BrowserUtils.waitFor(2);

        WebElement repeat = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        BrowserUtils.waitFor(2);
        repeat.click();
        Assert.assertTrue(repeat.isSelected());

        WebElement repeatEvery = driver.findElement(By.xpath("//input[@type='radio' and @checked='checked']"));
        BrowserUtils.waitFor((2));
        Assert.assertTrue(repeatEvery.isSelected());

        WebElement never = driver.findElement(By.xpath("(//input[@type='radio'])[1]"));
        Assert.assertTrue(never.isSelected());

        WebElement every1Day = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']"));
        String expected = every1Day.getText();
        Assert.assertEquals(expected, "Daily every 1 day");
    }

    @Test
    public void test10() {
        driver.get(ConfigurationReader.get("qa1_url"));
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.get("storemanager_username");
        String password = ConfigurationReader.get("storemanager_password");
        loginPage.login(username, password);
        DashboardPage dashboardPage = new DashboardPage();
        dashboardPage.navigateToModule("Activities", "Calendar Events");

        BrowserUtils.waitFor(2);
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.waitUntilLoaderScreenDisappear();

        WebElement createCalendar = driver.findElement(By.xpath("//a[@class='btn main-group btn-primary pull-right ']"));
        createCalendar.click();
        BrowserUtils.waitFor(2);

        WebElement repeat = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        BrowserUtils.waitFor(2);
        repeat.click();

        WebElement after = driver.findElement(By.xpath("(//input[@type='radio'])[4]"));
        after.click();
        driver.findElement(By.xpath("//input[@data-related-field='occurrences']")).sendKeys("10" + Keys.ENTER);
        WebElement every1Day = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']"));
        String expected = every1Day.getText();
        Assert.assertEquals(expected, "Daily every 1 day, end after 10 occurrences");
    }

    @Test
    public void test11() throws InterruptedException {
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

        WebElement repeat = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(repeat));
        repeat.click();

        WebElement by = driver.findElement(By.xpath("(//input[@type='radio'])[5]"));
        by.click();

        WebElement date = driver.findElement(By.xpath("(//input[@placeholder='Choose a date'])[3]"));
        wait.until(ExpectedConditions.elementToBeClickable(date));
        date.click();

        WebElement year = driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
        Select select = new Select(year);
        select.selectByValue("2021");

        Thread.sleep(1000);
        WebElement month = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
        Select select1 = new Select(month);
        select1.selectByVisibleText("Nov");

        Thread.sleep(1000);
        WebElement day = driver.findElement(By.xpath("//tr[3]/td[5]"));
        day.click();


        //  date.sendKeys("Nov 18, 2021"+ Keys.ENTER);
        WebElement every1Day = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']"));
        String expected = every1Day.getText();
        Assert.assertEquals(expected, "Daily every 1 day, end by Nov 18, 2021");
    }

    @Test
    public void test12() throws InterruptedException {
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

        WebElement repeat = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        wait.until(ExpectedConditions.elementToBeClickable(repeat));
        repeat.click();

        WebElement selectBox = driver.findElement(By.xpath("//select[@class='recurrence-repeats__select']"));
        Select weekly = new Select(selectBox);
        weekly.selectByValue("weekly");

        WebElement monday = driver.findElement(By.xpath("//input[@value='monday']"));
        WebElement friday = driver.findElement(By.xpath("//input[@value='friday']"));
        monday.click();
        friday.click();
        System.out.println(monday.isSelected());
        System.out.println(friday.isSelected());


        WebElement every1Day = driver.findElement(By.xpath("//div[@data-name='recurrence-summary']"));
        String actual = every1Day.getText();
        System.out.println(actual);
        Assert.assertEquals(actual, "Weekly every 1 week on Monday, Friday");
    }
}