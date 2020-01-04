package cucumberJava;
 
import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class) 
@CucumberOptions(monochrome = true,
		features = "src/test/java/cucumberJava/cucumberJava.feature",
		glue= {"cucumberJava"},
		plugin = {"pretty", "html:target/cucumber-reports"},
		tags="@KeyTermSearch, @PartialKeyTerm") 

public class runTest { }