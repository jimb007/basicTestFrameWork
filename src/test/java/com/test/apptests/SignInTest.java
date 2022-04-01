package com.test.apptests;
import com.test.apppages.SignInPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class SignInTest {

    WebDriver driver;

    @BeforeTest
    public void setDriver(){
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/src/main/resources/drivers/chromedriver.exe");

        driver = new ChromeDriver();
    }

    @AfterTest
    public void destroyDriver(){
        driver.quit();
    }

    @Test
    public void signInUserTest(){
        //Test data input
        String fullName= "Will Smith";
        String password= "slappingMachine";
        String email = "wsssmith123454@test.com";
        String testUrl="https://todoist.com/users/showregister#";

        //Step 1 go to page
        driver.get(testUrl);
        SignInPage signInPage = new SignInPage(this.driver);

        //Step 2 fill email and submit
        signInPage.fillEmailAndSubmit(email);

        //Step 3 fill sign in form
        signInPage.fillSignInForm(fullName,password);

        //Step 3 validate welcome message is displayed
        Assert.assertEquals(signInPage.getWelcomeMessage(),"Selecciona tu tema:",
                "Failed, welcome message didn't match with expected value");

    }

}
