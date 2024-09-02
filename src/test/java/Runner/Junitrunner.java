package Runner;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "C:\\Users\\shubh\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\ConstructWeekProject\\src\\test\\resources\\Naptol",
glue="NaptolTest", 
plugin={"pretty"})


public class Junitrunner {
	

}
