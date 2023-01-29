package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LogoutPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='logout']")
    private WebElement logoutButton;

    public LogoutPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void logout() {
        logoutButton.click();
        wait.until(ExpectedConditions.titleIs("ParaBank | Welcome | Online Banking"));
    }
}

