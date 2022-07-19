package com.cucumberFramework.testRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.TestNGCucumberRunner;


@CucumberOptions(features = 
{	
"src/test/resources/features/module/loginlogout.feature",
"src/test/resources/features/module/searchbookPayment.feature",
"src/test/resources/features/module/searchForAvailableRoom.feature",
"src/test/resources/features/module/cancel.feature",
"src/test/resources/features/module/bookingManagement.feature",
"src/test/resources/features/module/searchforRoom.feature",
"src/test/resources/features/module/checkOut.feature"
}

, glue = { "com/cucumberFramework/stepdefinitions" }
//, tags = {"@Testing"}
, plugin = { "json:target/cucumber-reports/CucumberReport.json" }
,monochrome = true
,dryRun = false)
public class TestRunner {
	
	private TestNGCucumberRunner testNGCucumberRunner;
	   
	@BeforeClass(alwaysRun = true)
	public void setUpClass() {
		testNGCucumberRunner = new TestNGCucumberRunner(this.getClass());
	}

	@Test(groups = "cucumber", description = "Runs cucumber Features", dataProvider = "features")
	public void feature(CucumberFeatureWrapper cucumberFeature) {
		testNGCucumberRunner.runCucumber(cucumberFeature.getCucumberFeature());
	}

	@DataProvider
	public Object[][] features() {
		return testNGCucumberRunner.provideFeatures();
	}

	@AfterClass(alwaysRun = true)
	public void testDownClass() {
		testNGCucumberRunner.finish();
	}

}
