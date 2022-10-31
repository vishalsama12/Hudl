package core;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Component;



@Component
public class CucumberPageWrapper  {



    private static final long DRIVER_WAIT_TIME = 10;

    public WebDriver driver;

    protected WebDriverWait wait;

  public WebDriver driver(){
      return this.driver ;
  }


    /**
     * Find the dynamic element wait until its visible
     *
     * @param by Element location found by css, xpath, id etc...
     **/
    public WebElement waitForExpectedElement(final By by) {
        this.wait = new WebDriverWait(this.driver(),DRIVER_WAIT_TIME);
        return wait.until(visibilityOfElementLocated(by));
    }


    public ExpectedCondition<WebElement> visibilityOfElementLocated(final By by) throws NoSuchElementException {
        return driver -> {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
            WebElement element = driver.findElement(by);
            return element.isDisplayed() ? element : null;
        };
    }



}
