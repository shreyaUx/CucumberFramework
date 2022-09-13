package stepdefination;

import java.util.List;
import java.util.Map;

import org.junit.Assert;

import com.driverfactory.Driverfactory;
import com.pages.AccountsPage;
import com.pages.LoginPage;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class AccountpageSteps {

	private AccountsPage accountspage;
	private LoginPage loginPage = new LoginPage(Driverfactory.getDriver());

	@Given("user has already logged in to application")
	public void user_has_already_logged_in_to_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		Driverfactory.getDriver()
				.get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
		accountspage = loginPage.doLogin(username, password);
	}

	@Given("user is on Accounts page")
	public void user_is_on_accounts_page() {
		accountspage.getAccountsPageTitle();
	}

	@Then("user gets accounts section")
	public void user_gets_accounts_section(io.cucumber.datatable.DataTable sectiontable) {
		List<String> expectedSectionList = sectiontable.asList();
		System.out.println(expectedSectionList);
		List<String> actualList = accountspage.getAccountSectionList();
		System.out.println(actualList);

	}

	@Then("accounts section count should be {int}")
	public void accounts_section_count_should_be(Integer expectedCount) {
		Assert.assertTrue(accountspage.getAccountsectionCount() == expectedCount);
	}
}
