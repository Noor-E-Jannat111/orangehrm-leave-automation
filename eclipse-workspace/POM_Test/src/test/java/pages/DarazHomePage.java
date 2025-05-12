package pages;

import org.openqa.selenium.By;

public class DarazHomePage extends BaseDriver {

	public By SIGNUPLOGINBUTTON = By.xpath("https://member.daraz.com.bd/user/login");

	public By LOOGED_ACCOUNT_NAME = By.xpath("//span[@id='myAccountTrigger']");
	public By CUSTOMER_CARE_BUTTON = By.xpath("//span[normalize-space()='CUSTOMER CARE']");
	public By HELP_CENTER_BUTTON = By.xpath("//a(contains(text(),'Help Center')");

	public void clickOnSignUpLoginButton() {

		clickOnElemet(SIGNUPLOGINBUTTON);

	}

}
