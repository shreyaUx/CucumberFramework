package apphooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import com.driverfactory.Driverfactory;
import com.util.ConfigReader;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class ApplicationHooks {

	private Driverfactory driverfactory;
	private WebDriver driver;
	private ConfigReader configreader;
	Properties prop;
	
	
	
	@Before(order = 0)
	public void getProperty() throws Exception {
		configreader =  new ConfigReader();
		prop = configreader.init_prop();
		}
	
	@Before(order = 1)
	public void lauchBrowser() {
		String browsername = prop.getProperty("browser");
		driverfactory = new Driverfactory();
		driver = driverfactory.init_driver(browsername);
	}
	
//	@After(order=1)
//	public void tearDown(Scenario scenario) {
//		if(scenario.isFailed()) {
//			//TAKE SCEENSHOT
//			
//		String scrrenshotName = scenario.getName().replaceAll(" ","_");
//		byte [] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//		
	//	}
	}
	

