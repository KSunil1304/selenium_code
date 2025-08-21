package StepDefinitions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(features = {
		"src/test/java/StepDefinitions/Masterdata.feature" }, tags = "@healthcoach", glue = "StepDefinitions", plugin = {
				"html:target/Cucumberreport.html" }, monochrome = true)

//@CucumberOptions(plugin = { "html:target/Cucumberreport.html", "json:target/Cucumberreport.json",
//"junit:target/Cucumberreport.xml" })

//@CucumberOptions(tags = "@login, @registration", plugin = { "html:target/Cucumberreport.html" }) tags = "not @demandprogram",

public class Myrunner extends AbstractTestNGCucumberTests {
}

//tags = "not @demandprogram and not @hc",
//"src/test/java/StepDefinitions/AddingPatients.feature", "src/test/java/StepDefinitions/BookingServices.feature"

//"src/test/java/StepDefinitions/AddingPatients.feature","src/test/java/StepDefinitions/BookingServices.feature","src/test/java/StepDefinitions/LabTechnician.feature","src/test/java/StepDefinitions/Bookinglabhome.feature","src/test/java/StepDefinitions/IPPackage.feature","src/test/java/StepDefinitions/Patientprofileicons.feature","src/test/java/StepDefinitions/Masterdata.feature"
