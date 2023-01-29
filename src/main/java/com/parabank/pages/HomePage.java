package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

WebDriver driver;

public HomePage(WebDriver driver){
    this.driver= driver;
}

@FindBy(xpath = "//img[@title='ParaBank']")
    WebElement logo;
@FindBy(xpath = "//input[@value='Log In']")
    WebElement loginButton;

public boolean isLogoDisplayed(){
    return logo.isDisplayed();
}

public boolean isLoginButtonEnabled(){
    return loginButton.isEnabled();
}

public String getTitle(){
    return driver.getTitle();
    }
}
