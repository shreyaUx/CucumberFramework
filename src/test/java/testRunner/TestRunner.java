package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(features="C:\\Users\\shreya\\cucumberframework\\src\\test\\resource\\feature\\Accounts.feature",
glue={"stepdefination","apphooks"},

	plugin = {"html:reports/webreport.html,json:reports/jsonreport.json,html:target/cucumber-reports.html"}

)
public class TestRunner {

}
