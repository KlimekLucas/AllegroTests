package cucumberSteps;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/main/cucumber/features/FindRazerGamepad.feature", plugin = {"pretty", "html:out"})
public class FindRazerGampadTest {
}