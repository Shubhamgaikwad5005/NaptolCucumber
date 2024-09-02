package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;

@io.cucumber.testng.CucumberOptions( features = "C:\\Users\\shubh\\Documents\\workspace-spring-tool-suite-4-4.24.0.RELEASE\\ConstructWeekProject\\src\\test\\resources\\Naptol",
					glue="NaptolTest", 
					plugin={"pretty"})

public class Test1 extends AbstractTestNGCucumberTests{
	
	
}
