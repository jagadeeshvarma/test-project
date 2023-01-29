package com.parabank.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class RegisterPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//*[@id='customer.firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//*[@id='customer.lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//*[@id='customer.address.street']")
    private WebElement streetField;

    @FindBy(xpath = "//*[@id='customer.address.city']")
    private WebElement cityField;

    @FindBy(xpath = "//*[@id='customer.address.state']")
    private WebElement stateField;

    @FindBy(xpath = "//*[@id='customer.address.zipCode']")
    private WebElement zipCodeField;

    @FindBy(xpath = "//*[@id='customer.phoneNumber']")
    private WebElement phoneNumberField;

    @FindBy(xpath = "//*[@id='customer.ssn']")
    private WebElement ssnField;

    @FindBy(xpath = "//*[@id='customer.username']")
    private WebElement usernameField;

    @FindBy(xpath = "//*[@id='customer.password']")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='repeatedPassword']")
    private WebElement confirmPasswordField;

    @FindBy(xpath = "//*[@value='Register']")
    private WebElement registerButton;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void fillForm(String firstName, String lastName, String street, String city, String state, String zipCode, String phoneNumber, String ssn, String username, String password, String confirmPassword) {
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        streetField.sendKeys(street);
        cityField.sendKeys(city);
        stateField.sendKeys(state);
        zipCodeField.sendKeys(zipCode);
        phoneNumberField.sendKeys(phoneNumber);
        ssnField.sendKeys(ssn);
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
        confirmPasswordField.sendKeys(confirmPassword);
    }

    public void submitForm() {
        registerButton.click();
        wait.until(ExpectedConditions.titleIs("ParaBank | Customer Created"));
    }
}

