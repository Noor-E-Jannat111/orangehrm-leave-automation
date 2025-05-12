package test;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.DarazHomePage;
import pages.LogInPage;
import utilities.DriverSetup;

public class LogInTest extends DriverSetup {

	DarazHomePage darazHomePage = new DarazHomePage();

	LogInPage logInPage = new LogInPage();

	@Test(priority = 0)
	public void loginPageTitle() throws InterruptedException {

		getDriver().get("https://www.daraz.com.bd/#?");
		darazHomePage.clickOnSignUpLoginButton();
		//Thread.sleep(4000);
		assertEquals(getDriver().getTitle(), logInPage.LOGINPAGETITLE);
		//System.out.println(getDriver().getTitle());

	}

}
