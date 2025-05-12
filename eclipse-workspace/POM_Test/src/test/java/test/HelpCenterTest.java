package test;

import static org.testng.Assert.assertEquals;

import pages.DarazHomePage;
import pages.HelpCentrePage;
import utilities.DriverSetup;

public class HelpCenterTest extends DriverSetup {

	DarazHomePage darazHomePage = new DarazHomePage();
	HelpCentrePage helpCentrePage = new HelpCentrePage();

	public void TestHelpCenterPageTitle() {
		getDriver().get("https://www.daraz.com.bd");
		darazHomePage.clickOnElemet(darazHomePage.CUSTOMER_CARE_BUTTON);
		darazHomePage.waitForElementVisiable(darazHomePage.HELP_CENTER_BUTTON);
		darazHomePage.clickOnElemet(darazHomePage.HELP_CENTER_BUTTON);
		helpCentrePage.waitForElementVisiable(helpCentrePage.HELP_CENTER_TEXT);
		assertEquals(getDriver().getTitle(), helpCentrePage.HELP_CENTER_PAGE_TITLE);

	}

}
