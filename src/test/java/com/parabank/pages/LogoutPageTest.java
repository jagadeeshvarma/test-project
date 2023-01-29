package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutPageTest {
    private WebDriver driver;
    private LogoutPage logoutPage;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/");
        logoutPage = PageFactory.initElements(driver, LogoutPage.class);
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void testLogout() {

        loginPage.enterUsername("jagadeeshvarma");
        loginPage.enterPassword("ParaBanak@1234");
        loginPage.clickLogin();

        logoutPage.logout();

        String expectedTitle = "ParaBank | Welcome | Online Banking";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle, "Logout failed");
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
