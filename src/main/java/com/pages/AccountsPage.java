package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {

	private WebDriver driver;

	private By accountsSection = By.cssSelector("div#center_column span");

	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getAccountsPageTitle() {
		return driver.getTitle();
	}

	public int getAccountsectionCount() {
		return driver.findElements(accountsSection).size();
	}

	public List<String> getAccountSectionList() {
		List<String> accountList = new ArrayList<String>();
		List<WebElement> List = driver.findElements(accountsSection);
		for (WebElement e : List) {
			String text = e.getText();
			accountList.add(text);

		}
		return accountList;

	}
}
