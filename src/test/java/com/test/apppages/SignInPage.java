package com.test.apppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInPage {

    WebDriver driver;

    @FindBy(id="email")
    private WebElement emailInput;

    @FindBy(id="step_one_submit")
    private WebElement submitStep1Button;

    @FindBy(id = "full_name")
    private WebElement fullNameInput;

    @FindBy(id = "pwd")
    private WebElement passwordInput;

    @FindBy(id="step_two_submit")
    private WebElement submitButton;

    @FindBy(xpath = "//h1")
    private WebElement welcomeMessage;

    public void waitElementToLoad(WebElement webElement){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(webElement));
    }

    public SignInPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }


    public void fillEmailAndSubmit(String email){
        waitElementToLoad(emailInput);
        emailInput.sendKeys(email);
        submitStep1Button.click();
    }

    public void fillSignInForm(String fullName, String password){
        waitElementToLoad(fullNameInput);
        fullNameInput.sendKeys(fullName);
        passwordInput.sendKeys(password);
        submitButton.click();
    }

    public String getWelcomeMessage(){
        waitElementToLoad(welcomeMessage);
        return welcomeMessage.getText().trim();
    }



}
