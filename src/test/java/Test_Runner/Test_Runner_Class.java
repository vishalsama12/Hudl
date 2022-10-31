package Test_Runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features/",tags={"@Hudl_Tests"},monochrome = true, plugin = {
        "pretty", "html:target/site/cucumber-report/",
        "json:target/cucumber-report/cucumber.json"}, glue="Step_Definitions")


public class Test_Runner_Class {

}
