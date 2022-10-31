package core;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Hudl_Page {
    @Autowired
    CucumberPageWrapper  cucumberPageWrapper;

    public void visit_Hudl_Homepage(){
        System.setProperty("webdriver.chrome.driver","src/main/resources/chromedriver.exe");
        cucumberPageWrapper.driver = new ChromeDriver();
        cucumberPageWrapper.driver.get("http://hudl.com/");
        Assert.assertTrue(cucumberPageWrapper.waitForExpectedElement(By.cssSelector("a[data-qa-id='login']")).isDisplayed());
    }

    public void login_To_Hudl(String username, String password){
        cucumberPageWrapper.waitForExpectedElement(By.cssSelector("a[data-qa-id='login']")).click();
        cucumberPageWrapper.waitForExpectedElement(By.id("email")).sendKeys(username);
        cucumberPageWrapper.waitForExpectedElement(By.id("password")).sendKeys(password);
        cucumberPageWrapper.waitForExpectedElement(By.id("logIn")).click();
    }

    public void checkLoggedInSuccessfully(){
        Assert.assertTrue( cucumberPageWrapper.waitForExpectedElement(By.cssSelector("div[class='explore-tab-bar explore-tab-bar__home logged-in']")).isDisplayed());
    }

    public void checkErrorMessageDisplayed(){
        Assert.assertTrue(cucumberPageWrapper.waitForExpectedElement(By.cssSelector("div[class*='styles_errorDisplayInnerContainer']")).isDisplayed());
    }
}
