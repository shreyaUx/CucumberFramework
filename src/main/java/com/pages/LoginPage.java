package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	private WebDriver driver;
	
	//1.By locators
	private By emailid = By.id("email");
	private By password = By.id("passwd");
	private By loginBtn = By.id("SubmitLogin");
	private By forgotpasswordLink = By.linkText("Forgot your password?");
	
	//2. constructor of page class
	
	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	//3.Page actions feature behaviour of page methods
	
	public String getLoginPagetitle() {
		return driver.getTitle();

	}
	
	public boolean isForgotPasswordLinkExist() {
		return driver.findElement(forgotpasswordLink).isDisplayed();
	}
	
	public void enterUsername (String username ) {
		driver.findElement(emailid).sendKeys(username);
	}
	
	public void enterUserpassword(String pwd) {
		driver.findElement(password).sendKeys(pwd);
	}
	public void clickOnLogin() {
		driver.findElement(loginBtn).click();
	}
	
	public AccountsPage doLogin(String un , String pwd) {
		System.out.println("login with :"+un + "and" +pwd);
		driver.findElement(emailid).sendKeys(un);
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(loginBtn).click();
		return new AccountsPage(driver);
	}
	
	
	
//	public void clicklogin() {
//		driver.findElement(loginBtn).click();
//	}
}
