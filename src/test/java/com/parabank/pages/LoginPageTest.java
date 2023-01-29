package com.parabank.pages;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.asserts.SoftAssert;

public class LoginPageTest {
    private WebDriver driver;
    private LoginPage loginPage;
    private SoftAssert softAssert;

    @BeforeMethod
    public void setUp() {
        softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/");
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }

    @Test
    public void testSuccessfulLogin() {
        loginPage.enterUsername("johnDoe");
        loginPage.enterPassword("password");
        loginPage.clickLogin();

        // Verify that the login is successful by checking the page title
        String expectedTitle = "ParaBank | Accounts Overview";
        String actualTitle = driver.getTitle();
        softAssert.assertEquals(actualTitle, expectedTitle, "Login failed");
    }

    @Test
    public void testFailedLogin() {
        loginPage.enterUsername("invalidUsername");
        loginPage.enterPassword("invalidPassword");
        loginPage.clickLogin();

        // Verify that the login failed by checking for an error message
        String expectedErrorMessage = "The username and password could not be verified.";
        String actualErrorMessage = loginPage.getErrorMessage();
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message does not match");
    }
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
