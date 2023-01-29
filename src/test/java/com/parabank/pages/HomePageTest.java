package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class HomePageTest {

    HomePage homePage;
    WebDriver driver;
    SoftAssert softAssert;


    @BeforeClass
    public void setUp() {
        softAssert = new SoftAssert();
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/");
        homePage = PageFactory.initElements(driver, HomePage.class);
    }

    @Test
    public void testIsLogoDisplayed() {
        softAssert.assertTrue(homePage.isLogoDisplayed(), "Logo should be displayed");
    }

    @Test
    public void testIsLoginButtonEnabled() {
        softAssert.assertTrue(homePage.isLoginButtonEnabled(), "Login button should be displayed");
    }

    @Test
    public void testGetTitle() {
        softAssert.assertEquals("ParaBank | Welcome | Online Banking", homePage.getTitle());
    }


    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}