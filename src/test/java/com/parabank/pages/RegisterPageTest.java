package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class RegisterPageTest {
    private WebDriver driver;
    private RegisterPage registerPage;
    SoftAssert softAssert = new SoftAssert();

    @BeforeClass
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        registerPage = PageFactory.initElements(driver,RegisterPage.class);
    }

    @Test
    public void testRegister() {
        registerPage.fillForm("John", "Doe", "123 Main St", "Anytown", "US", "11111", "555-555-5555", "123-45-6789", "johndoe1234567", "password", "password");
        registerPage.submitForm();
        softAssert.assertEquals(driver.getTitle(), "ParaBank | Customer Created");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
