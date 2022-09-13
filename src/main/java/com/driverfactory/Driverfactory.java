package com.driverfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driverfactory {

	public WebDriver driver;
	public static ThreadLocal<WebDriver> tlDiver = new ThreadLocal<>();
/***
 * This method is used to initialize threadlocal driver on the basis of given browser
 * to initialize webdrivber
 * @param browser
 * @return
 */
	public WebDriver init_driver(String browser) {

		System.out.println("browser value is: " + browser);

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			tlDiver.set(new ChromeDriver());
//		} else if (browser.equals("firefox")) {
//			WebDriverManager.firefoxdriver().setup();
//			tlDiver.set(new FirefoxDriver());
//		} else if (browser.equals("safari")) {
//			tlDiver.set(new SafariDriver());
		} else {
			System.out.println("Please pass the correct browser value: " + browser);
		}

		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return getDriver();

	}

	/**
	 * this is used to get the driver with ThreadLocal
	 * 
	 * @return
	 */
	public static synchronized WebDriver getDriver() {
		return tlDiver.get();
	}
}