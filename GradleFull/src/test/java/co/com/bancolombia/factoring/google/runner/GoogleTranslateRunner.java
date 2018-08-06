package co.com.bancolombia.factoring.google.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
		features = "src.test.resources/features/google_translate.feature",
		glue = {"co.com.bancolombia.factoring.google.step_definition"}		
)
		
public class GoogleTranslateRunner {

}
