package Step_Definitions;


import core.CucumberPageWrapper;
import core.Hudl_Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;


@ContextConfiguration("classpath:cucumber.xml")
public class HudlLoginSteps {
    @Autowired
    CucumberPageWrapper  cucumberPageWrapper;

    @Autowired
    Hudl_Page hudl_page;

    @Given("I launch the chrome browser and navigate to homepage")
    public void iLaunchTheChromeBrowserAndNavigateToHomepage() {
        hudl_page.visit_Hudl_Homepage();
    }


    @When("^I enter Username as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
    public void iEnterUsernameAsAndPasswordAs(String username, String password) throws Throwable {
        hudl_page.login_To_Hudl(username,password);
    }

    @Then("I should be logged in successfully")
    public void iShouldBeLoggedInSuccessfully()  {
          hudl_page.checkLoggedInSuccessfully();
    }



    @Then("an error message should be displayed")
    public void anErrorMessageShouldBeDisplayed() {
       hudl_page.checkErrorMessageDisplayed();
    }

}


